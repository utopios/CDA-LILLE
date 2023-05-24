package org.example;

import org.example.services.ProduitService;

import java.util.Scanner;

public class Ihm {

    private ProduitService produitService;

    private Scanner scanner;

    public Ihm(){
        produitService = new ProduitService();
        scanner = new Scanner(System.in);
    }

    public void start(){

    }

    private void menu(){

    }
}
