package com.api.petshoplead.repositories;

import com.api.petshoplead.model.ProdutosLeadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutosLeadRepository extends JpaRepository<ProdutosLeadModel, UUID> {
}
