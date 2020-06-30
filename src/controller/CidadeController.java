/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CidadeDao;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import model.Cidade;
import model.Estado;

/**
 *
 * @author asus
 */

public class CidadeController {
    
    private final EstadoController controllerEstado = new EstadoController();
    private final CidadeDao dao = new CidadeDao();
    
    public Boolean cadastrarCidade(Cidade cidade){
        Estado estado = controllerEstado.obterPorId(cidade.getEstado().getId());
        Boolean validarOrcamento = controllerEstado.validarOrcamentoEstado(estado);
        Optional<Cidade> validarNomeCidade = validarNomeCidade(cidade);

        if(validarOrcamento == false){
            System.out.println("Esse estado não pode receber mais cidades, tem mais gastos do que orçamento disponível.");
            return false;
        }
        
        if(validarOrcamento && !validarNomeCidade.isPresent()){
           dao.persist(cidade);           
           controllerEstado.atualizarGastosTotais(estado.getId());
           System.out.println("Cidade cadastrada");
           return true;           
        } else{            
            cidade.setId(validarNomeCidade.get().getId());
            atualizarCidade(cidade);
            controllerEstado.atualizarGastosTotais(estado.getId());
            System.out.println("Cidade já cadastrada anteriormente, gastos da cidade atualizados.");
            return true;
        }      
    }
    
    public List<Cidade> obterTodas(){
        return dao.findAll();
    }
    
    public Cidade obterPorNome(String nome){
        return dao.findByName(nome);
    }
    
    public List<Cidade> obterPorEstado(Long idEstado){
        return dao.findCidadePorEstado(idEstado);
    }
    
    public List<Cidade> obterCidadePorClima(String clima){
       return dao.findCidadePorClima(clima);
    }
    
    public List<Cidade> obterPorSiglaEstado(String sigla){
        return dao.findCidadePorSiglaEstado(sigla);
    }
    
    public Boolean atualizarCidade(Cidade cidade){
        if(cidade.getEstado().getId() != null && cidade.getId() != null){
            dao.update(cidade);
            return true;
        } 
        System.out.println("Estado ou Cidade sem id para validação.");
        return false;
    }
    
    public Boolean excluirCidade(Long id){
        return dao.remove(id);
    }
    
    private Optional<Cidade> validarNomeCidade(Cidade cidade){
        List<Cidade> cidades = dao.findCidadePorEstado(cidade.getEstado().getId());
        Stream<Cidade> city = cidades.stream().filter(c -> c.getNome().equals(cidade.getNome()));
        Optional<Cidade> c = city.findFirst();
        System.out.println(c);
        return c;
    }
}
