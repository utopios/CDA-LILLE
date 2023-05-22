package org.example.dao;

import org.example.model.Account;
import org.example.model.BankBranch;
import org.example.model.Client;

public interface CompteDao {

    void begin();

    Account insertAccount(String libelle, String iban, float solde, BankBranch agence, Client client);

    void deleteCompte(Account compte);

    Account searchAccount(int num_compte);

    void envoie();
}
