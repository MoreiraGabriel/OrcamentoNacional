/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Estado;

/**
 *
 * @author asus
 */
public class EstadoDao {

    public void persist(Estado estado) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Estado findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Estado estado = new Estado();
        
        try {
            estado = em.find(Estado.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return estado;
    }
    
    public List<Estado> findEstadoDevedor(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Estado> lista = em.createQuery("Select a From Estado a Where orcamentototal < gastostotais", Estado.class).getResultList();
        return lista;
    }
    
    public Estado update(Estado estado){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
         try {
            em.merge(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return estado;
    }
    
    public List<Estado> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Estado> lista = em.createQuery("Select a From Estado a", Estado.class).getResultList();
        return lista;
    }
    
    public void remove(Long id){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
       try {
           em.remove(em.getReference(Estado.class, id));
           em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    } 
    
    public Double obterGastosTotais(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Double> result = null;
        
        try {
            result = em.createQuery("Select Sum(gastos) from Cidade a Where Id_estado = " + id).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao obter gastos totais.");
        } finally{
            em.close();
        }
        
        return result.get(0);
    }
    
    public void atualizarGastos(Long idEstado){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            List result = em.createQuery("Update Estado Set Gastostotais = (Select Sum(gastos) From Cidade Where Id_estado = "+idEstado+") Where Id = "+idEstado+"").getResultList();
            System.out.println(result);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao atualizar gastos totais.");
        } finally{
            em.close();
        }
    }
}
