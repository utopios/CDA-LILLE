package org.example.entity;

public class Ticket {
    private int id;
    private int idClient;
    private int idEvenement;
    private int nbTickets;


    public Ticket(int idClient, int idEvenement, int nbTickets) {
        this.idClient = idClient;
        this.idEvenement = idEvenement;
        this.nbTickets = nbTickets;
    }

    public Ticket(int id, int idClient, int idEvenement, int nbTickets) {
        this(idClient, idEvenement, nbTickets);
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public int setId(int id) {
        return this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public int getNbTickets() {
        return nbTickets;
    }

    public int getIdEvent() {
        return idEvenement;
    }

    public void setIdClient(int idClient) {
    }

    public void setIdEvenement(int idEvenement) {
    }

    public void setNbTickets(int nbTickets) {
    }
}

