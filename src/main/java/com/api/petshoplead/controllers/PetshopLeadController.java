package com.api.petshoplead.controllers;


import com.api.petshoplead.dtos.PetshopLeadDto;
import com.api.petshoplead.model.PetshopLeadModel;
import com.api.petshoplead.services.PetshopLeadService;
import com.fasterxml.jackson.databind.util.BeanUtil;
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
@RequestMapping("/Petshop-Lead")
public class PetshopLeadController {

    final PetshopLeadService petshopLeadService;

    public PetshopLeadController(PetshopLeadService petshopLeadService){
        this.petshopLeadService = petshopLeadService;
    }

    @PostMapping
    public ResponseEntity<Object> savePetshopLead(@RequestBody @Valid PetshopLeadDto petshopLeadDto){
        var petShopLeadModel = new PetshopLeadModel();
        BeanUtils.copyProperties(petshopLeadDto, petShopLeadModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(petshopLeadService.save(petShopLeadModel));
    }

    @GetMapping
    public ResponseEntity<List<PetshopLeadModel>> getAllPetshopLead(){
        return ResponseEntity.status(HttpStatus.OK).body(petshopLeadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePetshopLead(@PathVariable(value = "id")UUID id){
        Optional<PetshopLeadModel> petshopLeadModelOptional =  petshopLeadService.findById(id);
        if(!petshopLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(petshopLeadModelOptional.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePetshopLead(@PathVariable(value = "id") UUID id){
        Optional<PetshopLeadModel> petshopLeadModelOptional = petshopLeadService.findById(id);
        if (!petshopLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
        }
        petshopLeadService.delete(petshopLeadModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pet deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePetshopLead(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid PetshopLeadDto petshopLeadDto){
        Optional<PetshopLeadModel> petshopLeadModelOptional = petshopLeadService.findById(id);
        if(!petshopLeadModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
        }
        var petshopLeadModel = new PetshopLeadModel();
        BeanUtils.copyProperties(petshopLeadDto, petshopLeadModel);
        petshopLeadModel.setId(petshopLeadModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(petshopLeadService.save(petshopLeadModel));
    }
}
