/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamentonacional;

import dao.CidadeDao;
import dao.EstadoDao;
import model.Cidade;
import model.Estado;
import servico.CidadeServiceImpl;
import servico.EstadoServiceImpl;

/**
 *
 * @author asus
 */
public class OrcamentoNacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CidadeServiceImpl serviceCidade = new CidadeServiceImpl();
        EstadoServiceImpl serviceEstado = new EstadoServiceImpl();

        Estado estado = new Estado();  
        estado.setId(1L);
        estado.setNome("Rio de Janeiro");
        estado.setSigla("RJ");
        estado.setDistritoFederal(false);
        estado.setGastosTotais(7000.00F);
        estado.setOrcamentoTotal(6000.00F);

        //serviceEstado.cadastrarEstado(estado);

        Cidade cidade = new Cidade();
        //cidade.setId(5L);
        cidade.setNome("Cataguases");
        cidade.setClima("Subtropical");
        cidade.setPopulacao(60000);
        cidade.setGastos(6000F);
        cidade.setEstado(estado);
        
        Cidade leopoldina = new Cidade();
        leopoldina.setNome("Leopoldina");
        leopoldina.setClima("Equatorial");
        leopoldina.setPopulacao(25000);
        leopoldina.setGastos(1000F);
        leopoldina.setEstado(estado);
        
        serviceCidade.cadastrarCidade(cidade);
        //serviceCidade.cadastrarCidade(leopoldina);
        
        /*List<Cidade> cidades = cidadeDao.findAll();
        List<Estado> estados = estadoDao.findAll();
        Estado estado1 = estadoDao.findById(1L);
        Cidade cidade1 = cidadeDao.findById(1L);*/
        //List<Cidade> cidadeEstado = cidadeDao.findCidadePorEstado(5L);
        
        //System.out.println(cidadeEstado);
        
   
        //System.out.println(serviceEstado.ObterEstadosDevedores());
        serviceEstado.atualizarGastosTotais(3L);
        System.out.println(serviceEstado.obterGastosTotais(3L));
    }
    
}
