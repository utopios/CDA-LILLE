package org.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void main() {
        EntityManager em = emf.createEntityManager();


        em.close();
        emf.close();

    }
}
