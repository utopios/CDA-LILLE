package org.example.ihm;

import org.example.dao.ClientDAO;
import org.example.dao.EvenementDAO;
import org.example.dao.LocationDAO;
import org.example.dao.TicketDAO;
import org.example.service.ClientService;
import org.example.service.EvenementService;
import org.example.service.LocationService;
import org.example.service.TicketService;


import java.sql.Connection;
import java.util.Scanner;

public class IHM {
    Scanner scanner;
    String choix;
    private ClientService clientService;
    private EvenementService evenementService;

    private LocationService locationService;
    private TicketService ticketService;
    private Connection connection;

    private ClientDAO clientDAO;
    private LocationDAO locationDAO;
    private EvenementDAO evenementDAO;

    private TicketDAO ticketDAO;


    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start(){
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1" -> crudLieu();
                case "2" -> crudEvenement();
                case "3" -> crudClient();
                case "4" -> buyTicketAction();
                case "5" -> cancelTicketAction();
                case "6" -> showAllEventAction();
                case "7" -> showAllTicketAction();
                case "9" -> System.out.println("Au revoir");
                default -> System.out.println("Choix non valide");
            }
        } while (!choix.equals("9"));
    }

    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter, modifier et supprimer des lieux");
        System.out.println("2.Ajouter, modifier et supprimer des événements");
        System.out.println("3.Ajouter, modifier et supprimer des clients");
        System.out.println("4.Acheter des billets pour un événement");
        System.out.println("5.Annuler un achat de billet");
        System.out.println("6.Afficher la liste des événements disponibles");
        System.out.println("7.Afficher la liste des billets achetés par un client");
        System.out.println("9. Quitter");
        System.out.println("***************************************");
    }

    // 1 - CRUD Lieu
    private void crudLieu() {
        do {
            menuLieu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    saveLocationActionAction();
                    break;
                case "2":
                    getAllLocationsAction();
                    break;
                case "3":
                    updateLocationAction();
                    break;
                case "4":
                    deleteLocationAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }

    // Sous Menu Lieu
    private void menuLieu() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un lieu");
        System.out.println("2.Afficher la liste des lieux");
        System.out.println("3.Modifier un lieu");
        System.out.println("4.Supprimer un lieu");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation lieu
    private void saveLocationActionAction() {
        System.out.println("Saississez le nom du lieu");
        String name = scanner.nextLine();
        System.out.println("Saisisissez l'adresse du lieu");
        String address = scanner.nextLine();
        System.out.println("Saississez la capacité du lieu");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        LocationService locationService = new LocationService();
        if (locationService.saveLocationAction(name, address, capacity)) {
            System.out.println("Le lieu a été enregistré avec succès");
        } else {
            System.out.println("Le lieu n'a pas été enregistré");
        }
    }

    // 2 - Afficher tous les lieux
    private void getAllLocationsAction() {
        System.out.println("Liste des lieux :");
        LocationService locationService = new LocationService();
            locationService.getAllLocations().forEach(
                    location -> System.out.println(
                            "Id : " +  location.getIdLocation() +
                                    " Nom : " + location.getName() +
                                    " Adresse : " + location.getAddress() +
                                    " Capacité : " + location.getCapacity()
                    )
            );
        }

    // 3 - Modifier un lieu
    private void updateLocationAction() {
        System.out.println("Saississez l'id du lieu à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom du lieu");
        String name = scanner.nextLine();
        System.out.println("Saisisissez l'adresse du lieu");
        String address = scanner.nextLine();
        System.out.println("Saississez la capacité du lieu");
        int capacity = scanner.nextInt();
        LocationService locationService = new LocationService();
        if (locationService.updateLocation(id, name, address, capacity)) {
            System.out.println("Le lieu a été modifié avec succès");
        } else {
            System.out.println("Le lieu n'a pas été modifié");
        }
    }

    // 4 - Supprimer un lieu
    private void deleteLocationAction() {
        System.out.println("Saississez l'id du lieu à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        LocationService locationService = new LocationService();
        if (locationService.deleteLocation(id)) {
            System.out.println("Le lieu a été supprimé avec succès");
        } else {
            System.out.println("Le lieu n'a pas été supprimé");
        }
    }
// Crud Evenement
    private void crudEvenement() {
        do {
            menuEvenement();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    saveEvenementAction();
                    break;
                case "2":
                    getAllEvenementAction();
                    break;
                case "3":
                    updateEvenementAction();
                    break;
                case "4":
                    deleteEvenementAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }

    //  Sous Menu Evenement
    private void menuEvenement() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un evenement");
        System.out.println("2.Afficher la liste des evenements");
        System.out.println("3.Modifier un evenement");
        System.out.println("4.Supprimer un evenement");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation evenement
    private void saveEvenementAction() {
        System.out.println("Saississez le nom de l'evenement");
        String nameEvent = scanner.nextLine();
        System.out.println("Saississez la date de l'evenement");
        String date = scanner.nextLine();
        System.out.println("Saississez l'heure de l'evenement");
        String time = scanner.nextLine();
        System.out.println("Saississez l'id du lieu de l'evenement");
        int location = scanner.nextInt();
        System.out.println("Saississez le prix de l'evenement");
        int price = scanner.nextInt();
        System.out.println("Saississez le nombre de tickets vendus");
        int ticketsSold = scanner.nextInt();
        scanner.nextLine();
        EvenementService evenementService = new EvenementService();
        if (evenementService.saveEvenement(nameEvent, date, time, location, price, ticketsSold)) {
            System.out.println("L'evenement a été enregistré avec succès");
        } else {
            System.out.println("L'evenement n'a pas été enregistré");
        }

    }

    // 2 - Afficher tous les evenements
    private void getAllEvenementAction() {
        System.out.println("Liste des evenements :");
        EvenementService evenementService = new EvenementService();
        if (evenementService.getAllEvenement() != null) {
            evenementService.getAllEvenement().forEach(
                    evenement -> System.out.println(
                            "Id : " + evenement.getIdEvent() +
                                    " Nom : " + evenement.getNameEvent() +
                                    " Date : " + evenement.getDate() +
                                    " Heure : " + evenement.getTime() +
                                    " Lieu : " + evenement.getLocation() +
                                    " Prix : " + evenement.getPrice() +
                                    " Tickets vendus : " + evenement.getTicketsSold()
                    )
            );
        } else {
            System.out.println("Il n'y a pas d'evenement enregistré");
        }
    }

    // 3 - Modifier un evenement
    private void updateEvenementAction() {
        System.out.println("Saississez l'id de l'evenement à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom de l'evenement");
        String name = scanner.nextLine();
        System.out.println("Saississez la date de l'evenement");
        String date = scanner.nextLine();
        System.out.println("Saississez l'heure de l'evenement");
        String time = scanner.nextLine();
        System.out.println("Saississez l'id du lieu de l'evenement");
        int location = scanner.nextInt();
        System.out.println("Saississez le prix de l'evenement");
        int price = scanner.nextInt();
        System.out.println("Saississez le nombre de tickets vendus");
        int ticketsSold = scanner.nextInt();
        scanner.nextLine();
        EvenementService evenementService = new EvenementService();
        if (evenementService.updateEvenement(id, name, date, time, location, price, ticketsSold)) {
            System.out.println("L'evenement a été modifié avec succès");
        } else {
            System.out.println("L'evenement n'a pas été modifié");
        }
    }

    // 4 - Supprimer un evenement
    private void deleteEvenementAction() {
        System.out.println("Liste des evenements :");
        getAllEvenementAction();
        System.out.println("Saississez l'id de l'evenement à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        EvenementService evenementService = new EvenementService();
        if (evenementService.deleteEvenement(id)) {
            System.out.println("L'evenement a été supprimé avec succès");
        } else {
            System.out.println("L'evenement n'a pas été supprimé");
        }
    }

    // 3 - CRUD Client
    private void crudClient() {
        do {
            menuClient();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    saveClientAction();
                    break;
                case "2":
                    getAllclientAction();
                    break;
                case "3":
                    updateClientAction();
                    break;
                case "4":
                    deleteClientAction();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Choix non valide");
            }
        } while (!choix.equals("5"));
    }

    //  Sous Menu Client
    private void menuClient() {
        System.out.println("-------------------------------");
        System.out.println(" TP Billeterie DAO JDBC");
        System.out.println("-------------------------------");
        System.out.println("***************************************");
        System.out.println("Veuillez choisir une option :");
        System.out.println("***************************************");
        System.out.println("1.Ajouter un client");
        System.out.println("2.Afficher la liste des clients");
        System.out.println("3.Modifier un client");
        System.out.println("4.Supprimer un client");
        System.out.println("5.Retour");
        System.out.println("***************************************");
    }

    // 1 - Creation client
    private void saveClientAction() {
        System.out.println("Saississez le nom du client");
        String name = scanner.nextLine();
        System.out.println("Saississez le prenom du client");
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'email du client");
        String email = scanner.nextLine();
        ClientService clientService = new ClientService();
        if (clientService.saveClient(name, firstname, email)) {
            System.out.println("Le client a été enregistré avec succès");
        } else {
            System.out.println("Le client n'a pas été enregistré");
        }
    }

    // 2 - Afficher la liste des clients
    private void getAllclientAction() {
        System.out.println("Liste des clients :");
        ClientService clientService = new ClientService();
        if (clientService.getAllclient() != null) {
            clientService.getAllclient().forEach(
                    client -> System.out.println(
                            "Id : " + client.getIdclient() +
                                    " Nom : " + client.getLastname() +
                                    " Prenom : " + client.getFirstname() +
                                    " Email : " + client.getEmail()
                    )
            );
        } else {
            System.out.println("Il n'y a pas de client enregistré");
        }
    }

    // 3 - Modifier un client
    private void updateClientAction() {
        System.out.println("Saississez l'id du client à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nom du client");
        String name = scanner.nextLine();
        System.out.println("Saississez le prenom du client");
        String firstname = scanner.nextLine();
        System.out.println("Saississez l'email du client");
        String email = scanner.nextLine();
        clientService = new ClientService();
        System.out.println("Saississez le nombre de tickets vendus");
        int ticketsSold = scanner.nextInt();
        if (clientService.updateClient(id, name, firstname, email, ticketsSold)) {
            System.out.println("Le client a été modifié avec succès");
        } else {
            System.out.println("Le client n'a pas été modifié");
        }
    }

    // 4 - Supprimer un client
    private void deleteClientAction() {
        System.out.println("Saississez l'id du client à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        clientService = new ClientService();
        if (clientService.deleteClient(id)) {
            System.out.println("Le client a été supprimé avec succès");
        } else {
            System.out.println("Le client n'a pas été supprimé");
        }
    }

    //  3 - Achat de billet pour un événement
    private void buyTicketAction() {
        getAllclientAction();
        System.out.println("Saississez l'id du client");
        int idClient = scanner.nextInt();
        scanner.nextLine();
        getAllEvenementAction();
        System.out.println("Saississez l'id de l'événement");
        int idEvent = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saississez le nombre de billets");
        int nbTickets = scanner.nextInt();
        scanner.nextLine();
        TicketService ticketService = new TicketService();
        if (ticketService.saveTicket(idClient, idEvent, nbTickets)) {
            System.out.println("Le ticket a été acheté avec succès");
        } else {
            System.out.println("Le ticket n'a pas été acheté");
        }
    }

    // 5 - Annuler un achat de billet
    private void cancelTicketAction() {
        getAllTickets();
        System.out.println("Saississez l'id du ticket à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        TicketService ticketService = new TicketService();
        if (ticketService.deleteTicket(id)) {
            System.out.println("Le ticket a été supprimé avec succès");
        } else {
            System.out.println("Le ticket n'a pas été supprimé");
        }
    }

    private void getAllTickets() {
        System.out.println("Liste des tickets :");
        TicketService ticketService = new TicketService();
        if (ticketService.getAllTickets() != null) {
            ticketService.getAllTickets().forEach(
                    ticket -> System.out.println(
                            "Id : " + ticket.getId() + " " +
                                   "IdClient :" + ticket.getIdClient() + " " +
                                    "IdEvent :" + ticket.getIdEvent() + " " +
                                    "NbTickets :" + ticket.getNbTickets()
                    )
            );
        } else {
            System.out.println("Il n'y a pas de ticket enregistré");
        }
    }

    // 6 - Afficher la liste des événemennts disponibles
    private void showAllEventAction() {
        getAllEvenementAction();
        System.out.println("Liste des événements :");
        EvenementService evenementService = new EvenementService();
        if (evenementService.getAllEvenement() != null) {
            evenementService.getAllEvenement().forEach(
                    evenement -> System.out.println(
                            "Id : " + evenement.getIdEvent() +
                                    " Nom : " + evenement.getNameEvent() +
                                    " Date : " + evenement.getDate() +
                                    " Lieu : " + evenement.getLocation() +
                                    " Nb Places : " + evenement.getTicketsSold() +
                                    " Prix : " + evenement.getPrice()
                    )
            );
        } else {
            System.out.println("Il n'y a pas d'événement enregistré");
        }
    }

    // 7 - Afficher la liste des billes achetés par un client
    private void showAllTicketAction() {
        getAllclientAction();
        System.out.println("Saississez l'id du client");
        int id = scanner.nextInt();
        scanner.nextLine();
        TicketService ticketService = new TicketService();
        if (ticketService.getAllTickets() != null) {
            ticketService.getAllTickets().forEach(
                    ticket -> System.out.println(
                            "Id : " + ticket.getId() +
                                    " Client ID  : " + ticket.getIdClient() +
                                    " Evenement : " + ticket.getIdEvenement() +
                                    " Nb Tickets : " + ticket.getNbTickets()
                    )
            );
        } else {
            System.out.println("Il n'y a pas de ticket enregistré");
        }
    }


}

