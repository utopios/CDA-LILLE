package org.example.dao;

import org.example.model.BankBranch;
import org.example.model.Client;

public interface AgenceDao {


    BankBranch insertAgence(String adresse);

    void begin();

    void deleteAgence(BankBranch agence);

    Client searchClient(int numClient);

    void envoie();
}
