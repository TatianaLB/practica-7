package com.example.demo.service;

import com.example.demo.model.tiendaModel;

public interface tiendaService {
    Iterable<tiendaModel> getTiendasService();

    Iterable<tiendaModel> getTiendaByIdService(String idTienda);

    void deleteTiendaByIdService(String idTienda);

    void addTiendaService(tiendaModel tienda);
}