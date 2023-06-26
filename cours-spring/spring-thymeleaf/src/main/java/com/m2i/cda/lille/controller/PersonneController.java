package com.m2i.cda.lille.controller;

import com.m2i.cda.lille.entity.Personne;
import com.m2i.cda.lille.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/personne")
public class PersonneController {


    @Autowired
    PersonneService personneService;


    @GetMapping("")
    public List<Personne> getListPersonne(){

        return personneService.getAllPersonne();

    }

    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable Integer id){
       List<Personne> personnes = personneService.getAllPersonne();
       Personne personne = new Personne();
        for (Personne p:personnes) {

            if (p.getId() == id){

                personne = p;
            }

        }
        return personne ;
    }

    @PostMapping("/post")
    public Personne post(@RequestBody Personne personne){
        return personne;
    }

    @GetMapping("/param")
    public Personne post2(@RequestParam String nom, @RequestParam String prenom){
        return new Personne(nom, prenom);
    }





}
