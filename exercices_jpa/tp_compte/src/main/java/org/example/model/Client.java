package org.example.model;


import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="num_client")
    private Long numClient;
    
    @Column(name="nom_client",nullable = false)
    private String nomClient;
    
    @Column(name="prenom_client",nullable = false)
    private String prenomClient;

    @Column(name="date_naissance",nullable = false)
    @Temporal(TemporalType.DATE)
    // Annotation qui permet de stocke uniquement le jour,mois et l'année sans tenir compte des heures
    private Date dateNaissance;
    
    @ManyToMany(mappedBy = "clients", cascade=CascadeType.DETACH)
    private List<Account> accounts = new ArrayList<>();

    public Client() {
    }

    public Client(String nomClient, String prenomClient, Date dateNaissance) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.dateNaissance = dateNaissance;
    }

    public Long getNumClient() {
        return numClient;
    }

    public void setNumClient(Long numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Date getDateNaiss() {
        return dateNaissance;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaissance = dateNaiss;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        this.accounts.add(account);
    }
    
    
    
    
    
    
}
