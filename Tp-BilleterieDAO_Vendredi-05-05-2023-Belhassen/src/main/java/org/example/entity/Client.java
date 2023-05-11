package org.example.entity;

import java.util.List;

public class Client {

    private int idclient;
    private String lastName;
    private String firstName;
    private String email;

    public void setTickets(List<Evenement> tickets) {
        this.tickets = tickets;
    }

    private List<Evenement> tickets;

    public Client() {
    }
    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public Client(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Client(int idclient, String lastName, String firstName, String email) {
        this.idclient = idclient;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Client(int idclient, String lastName, String firstName, String email, List<Evenement> tickets) {
        this.idclient = idclient;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.tickets = tickets;
    }

    public int getIdclient() {
        return idclient;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idclient +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", tickets=" + tickets +
                '}';
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }
}
