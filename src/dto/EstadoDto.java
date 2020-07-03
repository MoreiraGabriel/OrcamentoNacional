/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import java.util.stream.Collectors;
import model.Estado;

/**
 *
 * @author gabriel.moreira
 */
public class EstadoDto {
    private Long id;
    private String nome;
    private String sigla;

    public EstadoDto() {
    }

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.sigla = estado.getSigla();
    }
    
    public static List<EstadoDto> converter(List<Estado> lista){        
        return lista.stream().map(EstadoDto::new).collect(Collectors.toList());
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

    @Override
    public String toString() {
        return "(" +sigla + ") - " + nome;
    }
}
