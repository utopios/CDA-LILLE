package org.example.interfaces;

import org.example.entities.Produit;

public interface Repository<T> {

    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    T findById(int id);
}
