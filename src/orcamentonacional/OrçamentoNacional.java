/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamentonacional;

import dao.CidadeDao;
import dao.EstadoDao;
import java.util.List;
import model.Cidade;
import model.Estado;
import servico.CidadeServiceImpl;

/**
 *
 * @author asus
 */
public class OrçamentoNacional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CidadeServiceImpl service = new CidadeServiceImpl();
        
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = new Estado();  
        estado.setId(1L);
        estado.setNome("Minas Gerais");
        estado.setSigla("MG");
        estado.setDistritoFederal(false);
        estado.setGastosTotais(1000.00F);
        estado.setOrcamentoTotal(2000.00F);

        //estadoDao.persist(estado);
        
        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = new Cidade();
        cidade.setNome("Juiz de Fora");
        cidade.setClima("Tropical");
        cidade.setPopulacao(35000);
        cidade.setGastos(1000F);
        cidade.setEstado(estado);
        //cidadeDao.persist(cidade);
        
        Cidade leopoldina = new Cidade();
        cidade.setNome("Leopoldina");
        cidade.setClima("Equatorial");
        cidade.setPopulacao(25000);
        cidade.setGastos(1000F);
        cidade.setEstado(estado);
        
        /*service.cadastrarCidade(cidade);
        service.cadastrarCidade(leopoldina);*/
        
        /*List<Cidade> cidades = cidadeDao.findAll();
        List<Estado> estados = estadoDao.findAll();
        Estado estado1 = estadoDao.findById(1L);
        Cidade cidade1 = cidadeDao.findById(1L);*/
        //List<Cidade> cidadeEstado = cidadeDao.findCidadePorEstado(5L);
        
        //System.out.println(cidadeEstado);
        
   
        System.out.println(service.obterCidadePorClima("Tropical"));
    }
    
}
