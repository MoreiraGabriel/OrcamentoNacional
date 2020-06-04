/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author asus
 */
public class Estado {
    
    private Long id;
    private String nome;
    private String sigla;
    private Boolean distritoFederal;
    private Float orçamentoTotal;
    private Float gastosTotais;
    private List<Long> idCidades;

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getDistritoFederal() {
        return distritoFederal;
    }

    public void setDistritoFederal(Boolean distritoFederal) {
        this.distritoFederal = distritoFederal;
    }

    public Float getOrçamentoTotal() {
        return orçamentoTotal;
    }

    public void setOrçamentoTotal(Float orçamentoTotal) {
        this.orçamentoTotal = orçamentoTotal;
    }

    public Float getGastosTotais() {
        return gastosTotais;
    }

    public void setGastosTotais(Float gastosTotais) {
        this.gastosTotais = gastosTotais;
    }

    public List<Long> getIdCidades() {
        return idCidades;
    }

    public void setIdCidades(Long id) {
       idCidades.add(id);
    }
}
