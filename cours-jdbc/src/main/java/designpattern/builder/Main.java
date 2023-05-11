package designpattern.builder;



public class Main {
    public static void main(String[] args) {
        Voiture v1 = new Voiture.Builder().marque("m 1").couleur("c 1").build();
        Voiture v2 = new Voiture.Builder().couleur("c2").annee(1900).build();
    }
}