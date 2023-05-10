package tp_car.util;

import tp_car.service.CarService;
import tp_car.service.PersonService;
import tp_car.service.SaleService;

import java.util.Scanner;

public class IHM {

    private Scanner sc;
    private String choix;
    private CarService carService;
    private PersonService personService;
    private SaleService saleService;
    public void start() {
        sc = new Scanner(System.in);


        do {
            menu();
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    createCar();
                    break;
                case "2":
                    listCar();
                    break;
                case "3":
                    deleteCar();
                    break;
                case "4":
                    updateCar();
                    break;
                case "5":
                    createPerson();
                    break;
                case "6":
                    listPerson();
                    break;
                case "7":
                    deletePerson();

                    break;
                case "8":
                    updatePerson();

                    break;
                case "9":
                    createSale();

                    break;
                case "10":
                    getAllSales();

                    break;
                case "11":
                    selectCarByPersonId();
                    break;

            }
        } while (!choix.equals("0"));
    }

    private void selectCarByPersonId() {

    }

    private void getAllSales() {
    }

    private void createSale() {
    }

    private void updatePerson() {
    }

    private void deletePerson() {
    }

    private void listPerson() {
    }

    private void createPerson() {
    }

    private void updateCar() {
        
    }

    private void deleteCar() {
        
    }

    private void listCar() {
        
    }

    private void createCar() {
        
    }

    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP 2 VOITURE ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1 - Enregistrer la voiture ");
        System.out.println("2 - Lister toutes les voitures ");
        System.out.println("3 - Supprimer la voiture ");
        System.out.println("4 - Modifier une voiture ");
        System.out.println("5 - Inscrire un acheteur");
        System.out.println("6 - Lister toutes les acheteur");
        System.out.println("7 - Supprimer une personne");
        System.out.println("8 - Modifier un acheteur");
        System.out.println("9 - Faire la vente");
        System.out.println("10 - Afficher les ventes de voiture ");
        System.out.println("11 - Afficher la liste des ventes d'un véhicule pour un acheteur");
        System.out.println("12 - Quitter");
    }
}
