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
import model.Estado;

/**
 *
 * @author asus
 */
public class CidadeDao {

    EstadoDao estadoDao = new EstadoDao();
    
    public void persist(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estado estado = estadoDao.findById(cidade.getEstado().getId());
        cidade.setEstado(estado);
        try {
            em.persist(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar cidade.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
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
        
        List<Cidade> lista = em.createQuery("Select a From Cidade a", Cidade.class).getResultList();
        return lista;
    }
    
    public void remove(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcamentoNacionalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
           em.remove(em.getReference(Cidade.class, id));
           em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao remover cidade.");
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    } 
}
