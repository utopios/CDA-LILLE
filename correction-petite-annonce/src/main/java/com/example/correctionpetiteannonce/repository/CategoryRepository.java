package com.example.correctionpetiteannonce.repository;

import com.example.correctionpetiteannonce.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public boolean existsCategoryByTitle(String title);
}
