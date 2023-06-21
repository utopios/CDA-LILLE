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


    @PostMapping("/create")
    public String postProduit(@ModelAttribute Produit produit) {

        System.out.println("produit " + produit);
        if (produit.getId() == null) {
            if (produitService.create(produit)) {
                return "redirect:/product";
            }
            return "product/error";

        } else {
            Produit existProduit = produitService.findById(produit.getId());
            if (existProduit != null) {
                existProduit.setDateAchat(produit.getDateAchat());
                existProduit.setMarque(produit.getMarque());
                existProduit.setReference(produit.getReference());
                existProduit.setStock(produit.getStock());
                existProduit.setPrix(produit.getPrix());
                if (produitService.update(existProduit)) {
                    return "redirect:/product";
                }
            }

            return "product/error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) {
        Produit pr = produitService.findById(id);
        System.out.println("pr " + pr);
        model.addAttribute("produit", pr);


        return "formulaire";
    }



    @PostMapping("/update/{id}")
    public Produit updateProduit(@PathVariable("id") Integer id, @RequestBody Produit produit) {
        Produit existProduit = produitService.findById(id);
        if (existProduit != null) {
            existProduit.setDateAchat(produit.getDateAchat());
            existProduit.setMarque(produit.getMarque());
            existProduit.setReference(produit.getReference());
            existProduit.setStock(produit.getStock());
            existProduit.setPrix(produit.getPrix());
            if (produitService.update(existProduit)) {
                return existProduit;
            }
        }
        return existProduit;
    }




}
