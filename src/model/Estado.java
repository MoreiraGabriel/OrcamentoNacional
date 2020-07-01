/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.EstadoDto;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author asus
 */
@Entity
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 63)
    private String nome;
    @Column(length = 2)
    private String sigla;
    private Boolean distritoFederal;
    private Float orcamentoTotal;
    private Float gastosTotais;
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla, Boolean distritoFederal, Float orcamentoTotal, Float gastosTotais, List<Cidade> cidades) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.distritoFederal = distritoFederal;
        this.orcamentoTotal = orcamentoTotal;
        this.gastosTotais = gastosTotais;
        this.cidades = cidades;
    }
    
    public Estado(EstadoDto dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.sigla = dto.getSigla();
    }
    
    public static List<Estado> converter(List<EstadoDto> lista){        
        return lista.stream().map(Estado::new).collect(Collectors.toList());
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

    public Float getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(Float orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public Float getGastosTotais() {
        return gastosTotais;
    }

    public void setGastosTotais(Float gastosTotais) {
        this.gastosTotais = gastosTotais;
    }

    public List<Cidade> getIdCidades() {
        return cidades;
    }

    public void setIdCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", distritoFederal=" + distritoFederal + ", orcamentoTotal=" + orcamentoTotal + ", gastosTotais=" + gastosTotais + '}';
    }
}
