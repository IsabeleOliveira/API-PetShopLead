package com.api.petshoplead.services;

import com.api.petshoplead.model.ProdutosLeadModel;
import com.api.petshoplead.repositories.ProdutosLeadRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutosLeadService {

    final ProdutosLeadRepository produtosLeadRepository;

    public ProdutosLeadService(ProdutosLeadRepository produtosLeadRepository){
        this.produtosLeadRepository = produtosLeadRepository;
    }


    @Transactional
    public Object save(ProdutosLeadModel produtosLeadModel) {
        return produtosLeadRepository.save(produtosLeadModel);

    }


    public List<ProdutosLeadModel> findAll() {
        return produtosLeadRepository.findAll();
    }

    public Optional<ProdutosLeadModel> findById(UUID id) {
        return produtosLeadRepository.findById(id);
    }

    @Transactional
    public void delete(ProdutosLeadModel produtosLeadModel) {
        produtosLeadRepository.delete(produtosLeadModel);
    }
}
