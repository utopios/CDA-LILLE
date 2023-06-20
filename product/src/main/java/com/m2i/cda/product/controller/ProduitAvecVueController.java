package com.m2i.cda.product.controller;



import com.m2i.cda.product.entity.Produit;
import com.m2i.cda.product.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProduitAvecVueController {

    @Autowired
    IProduitService produitService;

    @GetMapping("/affiche")
    public ModelAndView getProduits() {
        ModelAndView modelAndView = new ModelAndView();

        if(produitService.findAll().isEmpty()){
            modelAndView.setViewName("error");
        }else{
            modelAndView.setViewName("produits");
            modelAndView.addObject("produits",produitService.findAll());
        }
        return modelAndView;
    }

    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable("id") Integer id) {
        return produitService.findById(id);
    }

    @GetMapping("/getproduit")
    public Produit getProduitByParams(@RequestParam("id") Integer id) {
        return produitService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") Integer id) {
        Produit p = produitService.findById(id);
        if(p != null && produitService.delete(p)) {
            return "Suppression Ok";
        }
        return "Aucun produit avec cet id";
    }

    @PostMapping("")
    public Produit postProduit(@RequestBody Produit produit) {
        if(produitService.create(produit)) {
            return produit;
        }
        return null;
    }

    @PostMapping("/update/{id}")
    public Produit updateProduit(@PathVariable("id") Integer id, @RequestBody Produit produit)  {
        Produit existProduit = produitService.findById(id);
        if(existProduit != null) {
            existProduit.setDateAchat(produit.getDateAchat());
            existProduit.setMarque(produit.getMarque());
            existProduit.setReference(produit.getReference());
            existProduit.setStock(produit.getStock());
            existProduit.setPrix(produit.getPrix());
            if(produitService.update(existProduit)) {
                return  existProduit;
            }
        }
        return existProduit;
    }
}
