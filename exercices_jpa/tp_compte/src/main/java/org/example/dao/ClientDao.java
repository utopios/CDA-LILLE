package org.example.dao;

import org.example.model.Client;

import java.util.Date;

public interface ClientDao {

    void begin();
    Client insertClient(String nom, String prenom, Date date);
    Client searchClient(int numClient);
    void deleteClient(Client client);
    void envoie();


}
