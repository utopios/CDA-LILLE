package designpattern.builder;

public class Livre {
    private String titre;
    private String auteur;
    private int nombrePages;
    private int anneePublication;
    private String genre;
    public String ISBN;

    public Livre(Builder builder) {
        this.titre = builder.titre;
        this.auteur = builder.auteur;
        this.nombrePages = builder.nombrePages;
        this.anneePublication = builder.anneePublication;
        this.genre = builder.genre;
        this.ISBN = builder.ISBN;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", nombrePages=" + nombrePages +
                ", anneePublication=" + anneePublication +
                ", genre='" + genre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public static class Builder {
        private String titre;
        private String auteur;
        private int nombrePages;
        private int anneePublication;
        private String genre;
        public String ISBN;

        public Builder titre(String titre) {
            this.titre = titre;
            return this;
        }

        public Builder auteur(String auteur) {
            this.auteur = auteur;
            return this;
        }

        public Builder nombrePages(int nombrePages) {
            this.nombrePages = nombrePages;
            return this;
        }

        public Builder anneePublication(int anneePublication) {
            this.anneePublication = anneePublication;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder ISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Livre build(){
            return new Livre(this);
        }
    }
}
