package com.example.correctionpetiteannonce.service;

import com.example.correctionpetiteannonce.entity.Ad;
import com.example.correctionpetiteannonce.entity.Category;
import com.example.correctionpetiteannonce.exception.CategoryExistException;
import com.example.correctionpetiteannonce.exception.EmptyFieldsException;
import com.example.correctionpetiteannonce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public boolean saveCategory(String title) throws CategoryExistException, EmptyFieldsException {
        if(title != null) {
            if(!categoryRepository.existsCategoryByTitle(title)) {
                Category category = Category.builder().title(title).build();
                categoryRepository.save(category);
                return category.getId() > 0;
            }
            throw new CategoryExistException();
        }
        throw EmptyFieldsException.with("title");
    }

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Ad> getAdsByCategoryId(int id) {
        List<Ad> ads = categoryRepository.findById(id).get().getAds();
        return ads;
    }
}
