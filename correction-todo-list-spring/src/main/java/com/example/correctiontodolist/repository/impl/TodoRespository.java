package com.example.correctiontodolist.repository.impl;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.repository.BaseRepository;
import com.example.correctiontodolist.tool.ServiceHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Annotation pour déclarer un spring beans en tant que repository comme service ou controller
@Repository
public class TodoRespository implements BaseRepository<Todo> {

    private Session _session;

    private ServiceHibernate _serviceHibernate;

    public TodoRespository(ServiceHibernate serviceHibernate) {
        _serviceHibernate = serviceHibernate;
        _session = _serviceHibernate.getSession();
    }

    @Override
    public boolean create(Todo element) {
        _session.beginTransaction();
        _session.persist(element);
        _session.getTransaction().commit();
        return element.getId() > 0;
    }

    //Un void aurait suffi pour cette méthode
    @Override
    public boolean update(Todo element) {
        _session.beginTransaction();
        _session.update(element);
        _session.getTransaction().commit();
        return true;
    }

    //Un void aurait suffi, également, pour cette méthode
    @Override
    public boolean delete(Todo element) {
        _session.beginTransaction();
        _session.delete(element);
        _session.getTransaction().commit();
        return true;
    }

    @Override
    public Todo findById(int id) {
        return (Todo)_session.get(Todo.class, id);
    }

    public List<Todo> findByStatus(boolean status) {
        Query<Todo> todoQuery = _session.createQuery("from Todo where status = :status", Todo.class);
        todoQuery.setParameter("status", status);
        return todoQuery.list();
    }
}
