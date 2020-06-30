/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import java.util.stream.Collectors;
import model.Cidade;

/**
 *
 * @author gabriel.moreira
 */
public class CidadeDto {
    
    private Long id;
    private String nome;
    private Float gastos;
    private String clima;
    private Integer populacao;
    private String sigla;

    public CidadeDto(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.gastos = cidade.getGastos();
        this.clima = cidade.getClima();
        this.populacao = cidade.getPopulacao();
        this.sigla = cidade.getEstado().getSigla();
    }
    
    public static List<CidadeDto> converter(List<Cidade> cidades) {	
        return cidades.stream().map(CidadeDto::new).collect(Collectors.toList());
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

    public Float getGastos() {
        return gastos;
    }

    public void setGastos(Float gastos) {
        this.gastos = gastos;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "CidadeDto{" + "id=" + id + ", nome=" + nome + ", gastos=" + gastos + ", clima=" + clima + ", populacao=" + populacao + ", sigla=" + sigla + '}';
    }  
}
