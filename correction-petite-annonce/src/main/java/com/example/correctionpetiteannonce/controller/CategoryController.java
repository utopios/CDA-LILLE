package com.example.correctionpetiteannonce.controller;

import com.example.correctionpetiteannonce.exception.*;
import com.example.correctionpetiteannonce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView get() throws NotSignInException {
        ModelAndView mv = new ModelAndView("category");
        mv.addObject("categories", categoryService.getCategories());
        return mv;
    }
    @GetMapping("/add")
    public ModelAndView formAddCategory() {
        ModelAndView mv = new ModelAndView("categoryform");
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditCategory(@PathVariable int id) throws NotSignInException, CategoryNotExistException {
        ModelAndView mv = new ModelAndView("categoryform");
        mv.addObject("category", categoryService.getCategoryById(id));
        return mv;
    }

    @PostMapping("/edit/{id}")
    public String submitFormEditCategory(@PathVariable int id, @RequestParam String title) throws NotSignInException, CategoryNotExistException, EmptyFieldsException, NotAdminException {
        if(categoryService.updateCategory(id, title)){
            return "redirect:/category";
        }
        return null;
    }

    @PostMapping("/add")
    public String submitAddCategory(@RequestParam String title) throws NotSignInException, CategoryExistException, EmptyFieldsException, NotAdminException {
        if(categoryService.saveCategory(title)){
            return "redirect:/category";
        }
        return null;
    }

    @ExceptionHandler(NotSignInException.class)
    public ModelAndView handleException(NotSignInException ex) {
        ModelAndView mv = new ModelAndView("signin");
        mv.addObject("message", ex.getMessage());
        return mv;
    }
    @ExceptionHandler(NotAdminException.class)
    public ModelAndView handleException(NotAdminException ex) {
        ModelAndView mv = new ModelAndView("categoryform");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }
    @ExceptionHandler(CategoryExistException.class)
    public ModelAndView handleException(CategoryExistException ex) {
        ModelAndView mv = new ModelAndView("categoryform");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }
    @ExceptionHandler(CategoryNotExistException.class)
    public ModelAndView handleException(CategoryNotExistException ex) {
        ModelAndView mv = new ModelAndView("categoryform");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }
    @ExceptionHandler(EmptyFieldsException.class)
    public ModelAndView handleException(EmptyFieldsException ex) {
        ModelAndView mv = new ModelAndView("categoryform");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }
}
