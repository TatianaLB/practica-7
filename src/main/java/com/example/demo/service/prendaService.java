package com.example.demo.service;
import com.example.demo.model.prendaModel;

public interface prendaService {
    Iterable<prendaModel> getPrendasService();

    Iterable<prendaModel> getPrendaByIdService(String idPrenda);

    prendaModel updatePrenda(String idPrenda, prendaModel prenda);

    void deletePrendaByIdService(String idPrenda);

    void addPrendaService(prendaModel prenda);
}
