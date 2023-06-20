package com.m2i.cda.product.service;

import com.m2i.cda.product.entity.Produit;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IProduitService {

    boolean create(Produit p);
    boolean update(Produit p);

    boolean delete(Produit p);

    Produit findById(int id);

    List<Produit> findAll();




}
