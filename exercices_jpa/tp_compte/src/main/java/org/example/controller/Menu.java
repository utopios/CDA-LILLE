package org.example.controller;

import org.example.dao.AgenceDao;
import org.example.dao.ClientDao;
import org.example.dao.CompteDao;
import org.example.impl.AgenceDAOImpl;
import org.example.impl.ClientDAOImpl;
import org.example.impl.CompteDAOImpl;
import org.example.model.Account;
import org.example.model.BankBranch;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankManager");
    private static AgenceDAOImpl agenceDao = new AgenceDAOImpl(emf);
    private static ClientDAOImpl clientDao = new ClientDAOImpl(emf);
    private static CompteDAOImpl compteDao = new CompteDAOImpl(emf);


    public static void demarrage() {

        BankBranch bankBranch = null;
        Client client = null;
        Account account = null;
        menu();
        bankBranch = menu2();
        client = menu3();
        menu4(bankBranch, client);


    }


    public static void menu() {
        System.out.println(" 3 etapes obligatoires : ");
        System.out.println(" Etape 1 : créer une banque");
        System.out.println(" Etape 2 : créer un client");
        System.out.println(" Etape 3 : créer un compte");

    }

    public static BankBranch menu2() {

        agenceDao.begin();
        BankBranch bankBranch = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("infos Banque : ");
        System.out.println("Donnez l'adresse de l'agence : ");
        String adresse = sc.nextLine();
        bankBranch = agenceDao.insertAgence(adresse);
        agenceDao.envoie();
        return bankBranch;
    }

    public static Client menu3() {
      //  clientDao.begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("infos Client : ");
        System.out.println("Donnez le nom du client : ");
        String nom = sc.nextLine();
        System.out.println("Donnez le prenom du client : ");
        String prenom = sc.nextLine();
        System.out.println("Donnez moi la date de naissance du client :");
        String date = sc.nextLine();
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
      //  Client client = clientDao.insertClient(nom, prenom, date1);
        Client client = new Client(nom,prenom,date1);
      //  clientDao.envoie();
        return client;
    }

    public static void menu4(BankBranch bankBranch, Client client) {
        compteDao.begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("infos Compte : ");
        System.out.println("Donnez le libelle : ");
        String libelle = sc.nextLine();
        System.out.println("Donnez l'IBAN: ");
        String iban = sc.nextLine();
      //  sc.nextLine(); // Consomme la nouvelle ligne
      //  System.out.println(iban);
        System.out.println("Donnez moi le solde :");
        float solde = sc.nextFloat();
        Account compte = compteDao.insertAccount(libelle, iban, solde, bankBranch, client);
        compteDao.envoie();
        emf.close();
    }


}
