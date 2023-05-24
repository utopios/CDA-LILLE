package org.example;


import org.example.composant.Adresse;
import org.example.composant.Agence;
import org.example.pkCompose.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registre= new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory= new MetadataSources(registre). buildMetadata(). buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Adresse adresse = new Adresse("Tourcoing","France",59200);
        Agence agence = new Agence(42,"Gur kebab",adresse);

        session.save(agence);

        Personne personne = new Personne();
        personne.setNom("toto");
        personne.setPrenom("tata");

        session.save(personne);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}