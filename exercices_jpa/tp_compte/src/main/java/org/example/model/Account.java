package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="account")
public class Account{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="num_compte")
    private Long num_compte;
    
    @Column(nullable = false)
    private String libelle;
    
    @Column(name="iban",length = 27)
    private String Iban;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private float solde;
    
    @ManyToOne
    @JoinColumn(name = "agence_id", nullable = false)
    private BankBranch agence;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "account_client",
    joinColumns = @JoinColumn(name = "num_compte", referencedColumnName = "num_compte"),
    inverseJoinColumns = @JoinColumn(name = "num_client", referencedColumnName = "num_client"))
  //  private Set<Client> clients = new HashSet<Client>();
    private List<Client> clients = new ArrayList<>();

    public Account() {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(Client client) {
        this.clients.add(client);
    }

    
    public Long getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(Long num_compte) {

            this.num_compte = num_compte;

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
      //  if(iban.length() == 27){
           this.Iban = iban;
      //  }
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public BankBranch getAgence() {
        return agence;
    }

    public void setAgence(BankBranch agence) {
        this.agence = agence;
    }    
    
}
