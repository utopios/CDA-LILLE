package org.example.demo;

import org.example.entity.oneToMany.Group;
import org.example.entity.oneToMany.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo4 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void main() {
        EntityManager em = emf.createEntityManager();
     /*   em.getTransaction().begin();

        User user = new User();

        user.setUsername("toto");
        user.setPassword("1234");

        Group group = new Group();

        group.setName("CDA Lille");
        group.getUsers().add(user);

        em.persist(user);
        em.persist(group);

        em.getTransaction().commit();*/

        em.close();
        emf.close();

    }
}
