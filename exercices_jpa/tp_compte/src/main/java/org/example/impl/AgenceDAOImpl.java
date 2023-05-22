/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.impl;


import org.example.dao.AgenceDao;
import org.example.model.BankBranch;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AgenceDAOImpl implements AgenceDao {
    
    private EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("BankManager");
    private EntityManager em;// = emf.createEntityManager();

    public AgenceDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void begin(){
    em.getTransaction().begin();
    System.out.println("Démarrage de la persistance");
    }
    
    public BankBranch insertAgence(String adresse){
        BankBranch agence = new BankBranch();
        agence.setAdresse(adresse);
        em.persist(agence);
        return agence;
    }
    
    
    public void deleteAgence(BankBranch agence){
        em.remove(agence);
    }
    
    

    
    public Client searchClient(int numClient){
        return em.find(Client.class, numClient);
    }
    
    public void envoie()
	{

            em.getTransaction().commit();
            em.close();
          //  emf.close();
            
        } 
}
