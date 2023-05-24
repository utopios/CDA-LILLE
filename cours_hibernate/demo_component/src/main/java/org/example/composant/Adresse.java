package org.example.composant;


import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private String ville;
    private String pays;
    private int codePostal;

    public Adresse() {
    }

    public Adresse(String ville, String pays, int codePostal) {
        this.ville = ville;
        this.pays = pays;
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
}
