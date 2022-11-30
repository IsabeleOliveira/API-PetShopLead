package com.api.petshoplead.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PetshopLeadDto {

    @NotBlank
    private String nomePet;
    @NotBlank
    private String raca;
    @NotNull
    private float preco;
    @NotNull
    private float peso;
    @NotBlank
    private String descricao;

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
