package com.example.demo.controller;
import com.example.demo.model.prendaModel;
import com.example.demo.service.prendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class PrendaController {

    @Autowired
    prendaService prendaService;


    @GetMapping("/prendas")
    public ResponseEntity<Iterable<prendaModel>> getPrendas(){
        return ResponseEntity.ok().body(prendaService.getPrendasService());
    }

    @GetMapping("/prenda/{idPrenda}")
    public ResponseEntity<Iterable<prendaModel>> getPrendaByName(@PathVariable String idPrenda){
        //return ResponseEntity.ok().body(idPrenda);
        return ResponseEntity.ok().body(prendaService.getPrendaByIdService(idPrenda));
    }

    @GetMapping("/prenda/delete/{idPrenda}")
    public ResponseEntity<Void> deletePrendaById(@PathVariable String idPrenda){
        prendaService.deletePrendaByIdService(idPrenda);
        return ResponseEntity.ok().build();
    }
    /*@DeleteMapping("/prenda/delete/{idPrenda}")
    public ResponseEntity<prendaModel> deletePrendaById(@PathVariable String idPrenda) {
        prendaService.deletePrendaByIdService(idPrenda);
        return ResponseEntity.noContent().build();
    }*/

    @PostMapping("/prenda/add")
    public ResponseEntity<String> addPrendaById(
            @RequestBody prendaModel prenda,
            BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }else{
            prendaService.addPrendaService(prenda);
            return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }

    }

    @PutMapping("/prendas/{idPrenda}")
    public ResponseEntity<prendaModel> updatePrenda(@PathVariable String idPrenda, @RequestBody prendaModel prenda) {
        prendaModel newPrenda = prendaService.updatePrenda(idPrenda, prenda);
        if (newPrenda == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newPrenda);
    }
}


