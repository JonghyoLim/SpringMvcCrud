/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author hyoku
 */

@Service
public class AgentService {
    
    public List<Agents> getAllAgents() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Agents> tq = em.createNamedQuery("Agents.findAll", Agents.class);

        List<Agents> agentsList = new ArrayList<>();
        try {
            agentsList = tq.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return agentsList;
    }

    
     public void addAnAgent(Agents a) { 
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public Agents getAgentById(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Agents> tq = em.createNamedQuery("Agents.findByAgentId", Agents.class).setParameter("agentId", id);

        Agents a = null;
        try {
            a = tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return a;
    }

    public void editAgent(Agents a) {
        System.out.println(" -- AgentService -- : to edit agent!!!!!!!!!!!!!!!!!!!!!!!!!!");
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void deleteAnAgent(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            Agents a = getAgentById(id);
            transaction.begin();
            em.remove(em.merge(a));
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
    
}
