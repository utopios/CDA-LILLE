package com.example.correctiontodolist.repository.impl;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.entity.UserTodo;
import com.example.correctiontodolist.repository.BaseRepository;
import com.example.correctiontodolist.tool.ServiceHibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserTodoRepository implements BaseRepository<UserTodo> {

    private Session _session;

    private ServiceHibernate _serviceHibernate;

    public UserTodoRepository(ServiceHibernate serviceHibernate) {
        _serviceHibernate = serviceHibernate;
        _session = _serviceHibernate.getSession();
    }

    @Override
    public boolean create(UserTodo element) {
        _session.beginTransaction();
        _session.persist(element);
        _session.getTransaction().commit();
        return element.getId() > 0;
    }

    @Override
    public boolean update(UserTodo element) {
        return false;
    }

    @Override
    public boolean delete(UserTodo element) {
        return false;
    }

    @Override
    public UserTodo findById(int id) {
        return (UserTodo)_session.get(UserTodo.class, id);
    }

    public UserTodo findByEmail(String email) {
        Query<UserTodo> query = _session.createQuery("from UserTodo where email=:email", UserTodo.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }
}
