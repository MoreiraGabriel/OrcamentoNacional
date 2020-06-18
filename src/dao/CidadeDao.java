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
import model.Cidade;

/**
 *
 * @author asus
 */
public class CidadeDao {
    
    public Boolean persist(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
       
        try {
            em.persist(cidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cidade." + cidade.getNome());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }
    
    public Cidade findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Cidade cidade = new Cidade();
        
        try {
            cidade = em.find(Cidade.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao encontrar cidade.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return cidade;
    }
    
    public Cidade update(Cidade cidade){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
         try {
            em.merge(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
             System.out.println("Erro ao atualizar cidade.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return cidade;
    }
    
    public List<Cidade> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Cidade> lista = em.createQuery("Select a From Cidade a Order By Nome", Cidade.class).getResultList();
        return lista;
    }
    
    public Boolean remove(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
           em.remove(em.getReference(Cidade.class, id));
           em.getTransaction().commit();
           return true;
        } catch (Exception e) {
            System.out.println("Erro ao remover cidade.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    } 
    
    public List<Cidade> findCidadePorEstado(Long idEstado){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Cidade> lista = em.createQuery("Select a From Cidade a Where Id_estado = "+ idEstado +"", Cidade.class).getResultList();
        return lista;
    }
    
    public List<Cidade> findCidadePorClima(String clima){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Cidade> lista = em.createQuery("Select a From Cidade a Where Clima = '"+ clima +"'", Cidade.class).getResultList();
        return lista;
    }
}
