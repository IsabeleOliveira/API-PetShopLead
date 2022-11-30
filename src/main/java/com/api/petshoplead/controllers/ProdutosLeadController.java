package com.api.petshoplead.controllers;

import com.api.petshoplead.dtos.ProdutosLeadDto;
import com.api.petshoplead.model.ProdutosLeadModel;
import com.api.petshoplead.services.ProdutosLeadService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/Produto-Lead")
public class ProdutosLeadController {
    final ProdutosLeadService produtosLeadService;

    public ProdutosLeadController(ProdutosLeadService produtosLeadService){
        this.produtosLeadService = produtosLeadService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProdutosLead(@RequestBody @Valid ProdutosLeadDto produtosLeadDto){
        var produtosLeadModel = new ProdutosLeadModel();
        BeanUtils.copyProperties(produtosLeadDto, produtosLeadModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosLeadService.save(produtosLeadModel));
    }

    @GetMapping
    public ResponseEntity<List> getAllProdutosLead(){
           return ResponseEntity.status(HttpStatus.OK).body(produtosLeadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProdutosLead(@PathVariable(value = "id")UUID id){
        Optional<ProdutosLeadModel> produtosLeadModelOptional = produtosLeadService.findById(id);
        if(!produtosLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found. ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtosLeadModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProdutosLead(@PathVariable(value = "id") UUID id){
        Optional<ProdutosLeadModel> produtosLeadModelOptional = produtosLeadService.findById(id);
        if(!produtosLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found. ");
        }
        produtosLeadService.delete(produtosLeadModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProdutosLead(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid ProdutosLeadDto produtosLeadDto){
        Optional<ProdutosLeadModel> produtosLeadModelOptional = produtosLeadService.findById(id);
        if(!produtosLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var produtosLeadModel = new ProdutosLeadModel();
        BeanUtils.copyProperties(produtosLeadDto, produtosLeadModel);
        produtosLeadModel.setId(produtosLeadModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(produtosLeadService.save(produtosLeadModel));
    }
}
