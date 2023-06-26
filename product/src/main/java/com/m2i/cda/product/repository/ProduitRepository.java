package com.m2i.cda.product.repository;

import com.m2i.cda.product.entity.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {

    public Produit findByReferenceOrMarque(String search);
    public List<Produit> findAllByReferenceLike(String search);

    @Query("SELECT Produit from Produit where reference= :search")
    public List<Produit> getAllReference(String search);
}
