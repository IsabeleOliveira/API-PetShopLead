package com.api.petshoplead.services;


import com.api.petshoplead.model.PetshopLeadModel;
import com.api.petshoplead.repositories.PetshopLeadRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetshopLeadService {

    final PetshopLeadRepository petshopLeadRepository;

    public PetshopLeadService (PetshopLeadRepository petshopLeadRepository){
        this.petshopLeadRepository = petshopLeadRepository;
    }

    @Transactional
    public Object save(PetshopLeadModel petShopLeadModel) {
        return petshopLeadRepository.save(petShopLeadModel);
    }

    public List<PetshopLeadModel> findAll() {
        return petshopLeadRepository.findAll();
    }

    public Optional<PetshopLeadModel> findById(UUID id) {
        return petshopLeadRepository.findById(id);
    }

    @Transactional
    public void delete(PetshopLeadModel petshopLeadModel) {
        petshopLeadRepository.delete(petshopLeadModel);
    }


}
