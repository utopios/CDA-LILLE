package com.m2i.cda.lille.service.impl;


import com.m2i.cda.lille.entity.Personne;
import com.m2i.cda.lille.service.PersonneService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Override
    public List<Personne> getAllPersonne() {

        Personne personne = new Personne(1, "Karim","Papin",35);
        Personne personne1 = new Personne(2, "Vincent","Pierre",30);
        Personne personne2 = new Personne(3, "Tim","Tom",39);

        return  Arrays.asList(personne, personne1, personne2);
    }
}
