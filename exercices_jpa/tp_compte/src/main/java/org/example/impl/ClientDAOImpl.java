/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.impl;


import org.example.dao.ClientDao;
import org.example.model.Client;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClientDAOImpl implements ClientDao {
 
    
    private EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("BankManager");
    private EntityManager em;// = emf.createEntityManager();

    public ClientDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void begin(){
    em.getTransaction().begin();
    System.out.println("Démarrage de la persistance");
    }
    
    public Client insertClient( String nom, String prenom, Date date){
        Client client = new Client();
        client.setNomClient(nom);
        client.setPrenomClient(prenom);
        client.setDateNaiss(date);
        em.merge(client);
        return client;
    }

    public Client searchClient(int numClient){
        return em.find(Client.class, numClient);
    }    
    
    public void deleteClient(Client client){
        em.detach(client);
    } 
    
    public List<Client> listeClients(){ 
        List<Client> liste = em.createQuery("SELECT * FROM CLIENT GROUP BY NUMCLIENT").getResultList();
        return liste;
    }
    
    public void envoie()
	{
            em.getTransaction().commit();
            em.close();
        //  emf.close();
        }
}
