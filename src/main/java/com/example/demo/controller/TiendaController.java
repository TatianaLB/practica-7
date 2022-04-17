package com.example.demo.controller;

import com.example.demo.model.tiendaModel;
import com.example.demo.service.tiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class TiendaController {

    @Autowired
    tiendaService tiendaService;


    @GetMapping("/tiendas")
    public ResponseEntity<Iterable<tiendaModel>> getTiendas(){
        return ResponseEntity.ok().body(tiendaService.getTiendasService());
    }

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<Iterable<tiendaModel>> getTiendaByName(@PathVariable String idTienda){


        //return ResponseEntity.ok().body(id);

        return ResponseEntity.ok().body(tiendaService.getTiendaByIdService(idTienda));
    }

    @GetMapping("/tienda/delete/{idTienda}")
    public ResponseEntity<Void> deleteTiendaById(@PathVariable String idTienda){
        tiendaService.deleteTiendaByIdService(idTienda);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tienda/add")
    public ResponseEntity<String> addTiendaById(
            @RequestBody tiendaModel tienda,
            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }else{
            tiendaService.addTiendaService(tienda);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }

    }
}



