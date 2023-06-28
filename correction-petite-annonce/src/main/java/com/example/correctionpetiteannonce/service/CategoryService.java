package com.example.correctionpetiteannonce.service;

import com.example.correctionpetiteannonce.entity.Ad;
import com.example.correctionpetiteannonce.entity.Category;
import com.example.correctionpetiteannonce.exception.*;
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

    @Autowired
    private LoginService loginService;

    public boolean saveCategory(String title) throws CategoryExistException, EmptyFieldsException, NotAdminException, NotSignInException {
        if(loginService.isLogged()) {
            if (loginService.isAdmin()) {
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
            throw new NotAdminException();
        }
        throw new NotSignInException();
    }

    public boolean updateCategory(int id, String title) throws EmptyFieldsException, NotAdminException, NotSignInException, CategoryNotExistException {
        if(loginService.isLogged()) {
            if (loginService.isAdmin()) {
                if(title != null) {
                    try {
                        Category category = categoryRepository.findById(id).get();
                        category.setTitle(title);
                        categoryRepository.save(category);
                        return true;
                    }catch (Exception ex) {
                        throw new CategoryNotExistException();
                    }

                }
                throw EmptyFieldsException.with("title");
            }
            throw new NotAdminException();
        }
        throw new NotSignInException();
    }

    public List<Category> getCategories() throws NotSignInException {
        if(loginService.isLogged()) {
            return (List<Category>) categoryRepository.findAll();
        }
        throw new NotSignInException();
    }

    public Category getCategoryById(int id) throws NotSignInException, CategoryNotExistException {
        if(loginService.isLogged()) {
            try {
                return categoryRepository.findById(id).get();
            }catch (Exception ex) {
                throw new CategoryNotExistException();
            }
        }
        throw new NotSignInException();
    }

    public List<Ad> getAdsByCategoryId(int id) throws NotSignInException {
        if(loginService.isLogged()) {
            List<Ad> ads = categoryRepository.findById(id).get().getAds();
            return ads;
        }
        throw new NotSignInException();
    }
}
