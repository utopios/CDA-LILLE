package org.example.model;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="agence")
public class BankBranch{
    
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="code_agence")
    private Long codeAgence;
    
    @Column(nullable = false)
    private String adresse;

    public BankBranch() {
    }

    public Long getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(Long codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    
    
}
