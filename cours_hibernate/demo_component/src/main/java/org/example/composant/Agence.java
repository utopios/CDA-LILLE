package org.example.composant;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agence {

    @Id
    private int code;
    private String libelle;
    @Embedded
    private Adresse adresse;

    public Agence() {
    }

    public Agence(int code, String libelle, Adresse adresse) {
        this.code = code;
        this.libelle = libelle;
        this.adresse = adresse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
