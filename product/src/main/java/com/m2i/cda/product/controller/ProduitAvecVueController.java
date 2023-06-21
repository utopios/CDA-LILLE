package com.m2i.cda.product.controller;



import com.m2i.cda.product.entity.Produit;
import com.m2i.cda.product.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProduitAvecVueController {

    @Autowired
    IProduitService produitService;

    @GetMapping("")
    public ModelAndView getProduits() {
        ModelAndView modelAndView = new ModelAndView();
        if (produitService.findAll().isEmpty()) {
            modelAndView.setViewName("error");
        } else {
            modelAndView.setViewName("produit");
            modelAndView.addObject("produits", produitService.findAll());
        }
        return modelAndView;
    }


    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable("id") Integer id) {
        return produitService.findById(id);
    }

    @GetMapping("/search")
    public String searchProductById(@RequestParam("productId") Integer productId, Model model) {
        Produit produit = produitService.findById(productId);
        model.addAttribute("produit", produit);
        return "product-details";
    }




    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Integer id) {
        Produit p = produitService.findById(id);
        if (p != null && produitService.delete(p)) {
            return "redirect:/product";
        }
        return "Aucun produit avec cet id";
    }


    @GetMapping("/form")
    public String afficherFormulaireCreationProduit(Model model) {
        model.addAttribute("produit", new Produit());
        return "formulaire";
    }
}
