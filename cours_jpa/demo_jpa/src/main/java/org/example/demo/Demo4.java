package org.example.demo;

import org.example.entity.oneToMany.Department;
import org.example.entity.oneToMany.Employee;
import org.example.entity.oneToMany.Group;
import org.example.entity.oneToMany.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class Demo4 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(6);
        Employee employee1 = new Employee();
        employee1.setId(8);

        Department department = new Department();
        department.setId(1);
        department.setDname("Science");

        employee.setD(department);
        employee1.setD(department);

        Collection<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);

        department.setEmps(list);

        em.persist(department);
        em.persist(employee);
        em.persist(employee1);

        em.getTransaction().commit();

        Department departmentsearch = em.find(Department.class, 1);
        Collection<Employee> emptp = departmentsearch.getEmps();
        for(Employee emp : emptp){
            System.out.println(emp.getId());
        }

        em.close();
        emf.close();

    }

    public static void main2() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();

        user.setUsername("toto");
        user.setPassword("1234");

        Group group = new Group();

        group.setName("CDA Lille");

        user.setGroup(group);
        group.getUsers().add(user);


        em.persist(user);
        em.persist(group);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
