/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.CidadeDao;
import java.util.List;
import model.Cidade;
import model.Estado;

/**
 *
 * @author asus
 */

public class CidadeServiceImpl {
    
    private final EstadoServiceImpl serviceEstado = new EstadoServiceImpl();
    private final CidadeDao dao = new CidadeDao();
    
    public Boolean cadastrarCidade(Cidade cidade){
        Estado estado = serviceEstado.obterPorId(cidade.getEstado().getId());
        Boolean validarOrcamento = validarOrcamentoEstado(estado);
        Boolean validarNomeCidade = validarNomeCidade(cidade);
        
        if(validarOrcamento && validarNomeCidade == true){
           dao.persist(cidade);
           System.out.println("Cidade cadastrada");
           return true;           
        }      
        System.out.println("Erro ao cadastrar cidade " + cidade.getNome());
        return false;
    }
    
    public List<Cidade> obterTodas(){
        return dao.findAll();
    }
    
    public Cidade obterPorId(Long id){
        return dao.findById(id);
    }
    
    public List<Cidade> obterPorEstado(Long idEstado){
        return dao.findCidadePorEstado(idEstado);
    }
    
    public List<Cidade> obterCidadePorClima(String clima){
       return dao.findCidadePorClima(clima);
    }
    
    public Boolean atualizarCidade(Cidade cidade){
        if(cidade.getEstado().getId() != null){
            dao.update(cidade);
            return true;
        } 
        System.out.println("Estado sem id para validação.");
        return false;
    }
    
    public Boolean excluirCidade(Long id){
        return dao.remove(id);
    }
    
    private Boolean validarOrcamentoEstado(Estado estado){
        System.out.println("Esse estado não pode receber mais cidades, tem mais gastos do que orçamento.");
        return (estado.getOrcamentoTotal() > estado.getGastosTotais());
    }
    
    private Boolean validarNomeCidade(Cidade cidade){
        List<Cidade> cidades = dao.findCidadePorEstado(cidade.getEstado().getId());
        System.out.println("Já existe cidade com esse nome no estado");
        return cidades.stream().noneMatch(c -> c.getNome().equals(cidade.getNome()));
    }
}