/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamentonacional;

import java.util.List;
import model.Cidade;
import model.Estado;
import controller.CidadeController;
import controller.EstadoController;

/**
 *
 * @author asus
 */
public class OrcamentoNacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CidadeController controllerCidade = new CidadeController();
        EstadoController controllerEstado = new EstadoController();

        Estado estado = new Estado();  
        estado.setId(1L);
        estado.setNome("Rio de Janeiro");
        estado.setSigla("RJ");
        estado.setDistritoFederal(false);
        estado.setGastosTotais(7000.00F);
        estado.setOrcamentoTotal(6000.00F);

        //serviceEstado.cadastrarEstado(estado);

        Cidade cidade = new Cidade();
        cidade.setId(11L);
        cidade.setNome("Belo Horizonte");
        cidade.setClima("Subtropical");
        cidade.setPopulacao(100000);
        cidade.setGastos(8000F);
        cidade.setEstado(estado);
        
        Cidade leopoldina = new Cidade();
        leopoldina.setNome("Leopoldina");
        leopoldina.setClima("Equatorial");
        leopoldina.setPopulacao(25000);
        leopoldina.setGastos(1000F);
        leopoldina.setEstado(estado);
        
        controllerCidade.cadastrarCidade(cidade);
        //serviceCidade.cadastrarCidade(leopoldina);
        
        /*List<Cidade> cidades = serviceCidade.obterTodas();
        List<Estado> estados = serviceEstado.obterTodos();*/
   
        //List<Cidade> cidadeEstado = cidadeDao.findCidadePorEstado(5L);
        
        //System.out.println(cidadeEstado);
        
   
        //System.out.println(serviceEstado.ObterEstadosDevedores());
        //serviceEstado.atualizarGastosTotais(3L);
        //System.out.println(cidades);        
        //System.out.println(estados);
    }
    
}
