/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.EstadoDao;
import java.util.List;
import model.Estado;

/**
 *
 * @author asus
 */
public class EstadoServiceImpl {
    private final EstadoDao estadoDao = new EstadoDao();
    
    public Boolean cadastrarEstado(Estado estado){
        try {
            estadoDao.persist(estado);
            return true;
        } catch (Exception e) {
            throw e;            
        }
    }
    
    public Boolean atualizarEstado(Estado estado){
        try {
            estadoDao.update(estado);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Boolean excluirEstadao(Long id){
        try {
            estadoDao.remove(id);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Estado obterPorId(Long id){
        return estadoDao.findById(id);
    }
    
    public List<Estado> obterTodos(){
        return estadoDao.findAll();
    }
    
    public List<Estado> ObterEstadosDevedores(){
        return estadoDao.findEstadoDevedor();
    }
    
    public Double obterGastosTotais(Long id){
        return estadoDao.obterGastosTotais(id);
    }
    
    public Boolean validarOrcamentoEstado(Estado estado){
        return estado.getOrcamentoTotal() > estado.getGastosTotais();
    }
    
    public void atualizarGastosTotais(Long idEstado){
        estadoDao.atualizarGastos(idEstado);
    }
}
