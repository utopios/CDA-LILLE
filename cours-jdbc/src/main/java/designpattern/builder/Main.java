package designpattern.builder;



public class Main {
    public static void main(String[] args) {
//        Voiture v1 = new Voiture.Builder().marque("m 1").couleur("c 1").build();
//        Voiture v2 = new Voiture.Builder().couleur("c2").annee(1900).build();
        Livre l1 = new Livre.Builder().ISBN("134454545").nombrePages(40).build();
        Livre l2 = new Livre.Builder().ISBN("4555").auteur("toto").build();
        System.out.println(l1);
        System.out.println(l2);
        Personne p = new Personne.PersonneBuilder().nom("toto").prenom("tata").build();
        //Dans un autre package
        Personne p2 = Personne.builder().nom("toto").prenom("tata").build();
    }
}