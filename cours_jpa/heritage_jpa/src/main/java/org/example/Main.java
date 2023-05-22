package org.example;

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

          session.close();
          sessionFactory.close();
    }
}