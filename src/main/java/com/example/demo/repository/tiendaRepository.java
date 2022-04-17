package com.example.demo.repository;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.atomic.AtomicInteger;
import com.example.demo.model.tiendaModel;

public interface tiendaRepository extends CrudRepository<tiendaModel,String> {

    AtomicInteger idTienda = new AtomicInteger();

    @Query("SELECT * FROM TIENDA WHERE TIENDA.IDTIENDA=:idTienda")
    Iterable<tiendaModel> getTiendaById(String idTienda);

    @Modifying //SIEMPRE PONERLO CUANDO SE MODIFICA LA BASE DE DATOS
    @Query("INSERT INTO TIENDA (idTienda,nombre,ciudad,direccion,telefono,horario) VALUES (:idTienda,:nombre,:ciudad,:direccion,:telefono,:horario)")
    void addTienda(int idTienda, String nombre, String ciudad, String direccion, String telefono, String horario);

}

