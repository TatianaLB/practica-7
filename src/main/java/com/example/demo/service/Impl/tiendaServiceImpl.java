package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;
import com.example.demo.model.tiendaModel;
import com.example.demo.repository.tiendaRepository;
import com.example.demo.service.tiendaService;

@Service
public class tiendaServiceImpl implements tiendaService {

    AtomicInteger idTienda = new AtomicInteger();
    @Autowired
    private tiendaRepository tiendaRepository;

    @Override
    public Iterable<tiendaModel> getTiendasService(){
        return tiendaRepository.findAll();
    }

    @Override
    public Iterable<tiendaModel> getTiendaByIdService(String idTienda){
        return tiendaRepository.getTiendaById(idTienda);
    }

    @Override
    public void deleteTiendaByIdService(String idTienda){
        tiendaRepository.deleteById(idTienda);
    }

    @Override
    public void addTiendaService(tiendaModel tienda){
        int idTienda2 = tienda.getIdTienda();
        String nombre = tienda.getNombre();
        String ciudad = tienda.getCiudad();
        String direccion = tienda.getDireccion();
        String telefono = tienda.getTelefono();
        String horario = tienda.getHorario();
        tiendaRepository.addTienda(idTienda2,nombre,ciudad,direccion,telefono,horario);
    }
}
