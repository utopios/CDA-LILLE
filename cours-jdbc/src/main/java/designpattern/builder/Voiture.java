package designpattern.builder;

public class Voiture {
    private String marque;
    private String modele;
    private String couleur;
    private int annee;

    public Voiture(Builder builder) {
        marque = builder.marque;
        modele = builder.modele;
        couleur = builder.couleur;
        annee = builder.annee;
    }

    public static class Builder {
        private String marque;
        private String modele;
        private String couleur;
        private int annee;

        public Builder marque(String marque) {
            this.marque = marque;
            return this;
        }
        public Builder couleur(String couleur) {
            this.couleur = couleur;
            return this;
        }
        public Builder modele(String modele) {
            this.modele = modele;
            return this;
        }
        public Builder annee(int annee) {
            this.annee = annee;
            return this;
        }

        public Voiture build() {
            return new Voiture(this);
        }
    }
}
