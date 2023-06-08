package com.example.correctionpatient.repository;

import org.hibernate.Session;

import java.util.List;

public  abstract class Repository<T> {
    protected Session _session;
    public Repository(Session session) {
        _session = session;
    }
    public boolean create(T o) {
        _session.save(o);
        return true;
    }

    abstract boolean update(T o);

    abstract boolean delete(T o);

    abstract T findById(int id);

    abstract List<T> findAll();
}
