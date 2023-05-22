/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.impl;

import org.example.dao.CompteDao;
import org.example.model.Account;
import org.example.model.BankBranch;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompteDAOImpl implements CompteDao {
      
    private EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("BankManager");
    private EntityManager em;// = emf.createEntityManager();

   public CompteDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void begin(){
    em.getTransaction().begin();
    System.out.println("Démarrage de la persistance");
    }
    
    public Account insertAccount(String libelle, String iban, float solde, BankBranch agence, Client client){
        Account compte = new Account();
       // System.out.println(libelle);
      //  System.out.println(iban);
        compte.setLibelle(libelle);
        compte.setSolde(solde);
        compte.setIban(iban);
        compte.setAgence(agence);
        compte.getClients().add(client);
        client.getAccounts().add(compte);
        em.persist(compte);
        return compte;
    }
    
    public void deleteCompte(Account compte){
        em.detach(compte);
    }   
    
    public Account searchAccount(int num_compte){
        return em.find(Account.class, num_compte);
    }
    
    public void envoie()
	{

            em.getTransaction().commit();
            em.close();
         //   emf.close();
            
        }  
}
