package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import com.example.demo.model.prendaModel;
import com.example.demo.repository.prendaRepository;
import com.example.demo.service.prendaService;

@Service
public class prendaServiceImpl implements prendaService {

    AtomicInteger idPrenda = new AtomicInteger();
    @Autowired
    private prendaRepository prendaRepository;

    @Override
    public Iterable<prendaModel> getPrendasService(){
        return prendaRepository.findAll();
    }

    @Override
    public Iterable<prendaModel> getPrendaByIdService(String idPrenda){
        return prendaRepository.getPrendaById(idPrenda);
    }

   /* @Override
    public void deletePrendaByIdService(String idPrenda){
        prendaRepository.deleteById(idPrenda);
    }*/
   @Override
   public void deletePrendaByIdService(String idPrenda){
       prendaRepository.deleteById(idPrenda);
   }

    @Override
    public void addPrendaService(prendaModel prenda){
        int idPrenda2 = prenda.getIdPrenda();
        String descripcion = prenda.getDescripcion();
        int existencias = prenda.getExistencias();
        prendaRepository.addPrenda(idPrenda2,descripcion,existencias);
    }

    @Override
    public prendaModel updatePrenda(String idPrenda, prendaModel prenda) {
        if (prendaRepository.existsById(idPrenda)) {
            return prendaRepository.save(prenda);
        } else {
            return null;
        }
    }

}
