package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.atomic.AtomicInteger;
import com.example.demo.model.prendaModel;

public interface prendaRepository extends CrudRepository<prendaModel,String> {

    AtomicInteger idPrenda = new AtomicInteger();

    @Query("SELECT * FROM ROPA WHERE ROPA.IDPRENDA=:idPrenda")
    Iterable<prendaModel> getPrendaById(String idPrenda);

    @Modifying //SIEMPRE PONERLO CUANDO SE MODIFICA LA BASE DE DATOS
    @Query("INSERT INTO ROPA (idPrenda,descripcion,existencias) VALUES (:idPrenda,:descripcion,:existencias)")
    void addPrenda(int idPrenda, String descripcion, int existencias);

    @Modifying //SIEMPRE PONERLO CUANDO SE MODIFICA LA BASE DE DATOS
    @Query("DELETE * ROPA WHERE ROPA.IDPRENDA=:idPrenda")
    void deleteById(String idPrenda);

}
