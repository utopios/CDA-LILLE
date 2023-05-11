package org.example.entity;

public class Evenement {
    private int idEvent;

    private String nameEvent;

    private String date;

    private String time;

    private int location;

    private double price;

    private int ticketsSold;

    public Evenement(String nameEvent, String date, String time, int location, double price, int ticketsSold) {
        this.nameEvent = nameEvent;
        this.date = date;
        this.time = time;
        this.location = location;
        this.price = price;
        this.ticketsSold = ticketsSold;
    }

    public Evenement(int idEvent, String nameEvent, String date, String time, int location, double price, int ticketsSold) {
        this(nameEvent, date, time, location, price, ticketsSold);
        this.idEvent = idEvent;
    }


    public int getIdEvent() {
        return idEvent;
    }

    public int setIdEvent(int idEvent) {
        return this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDate() {
        return String.valueOf(date);
    }


    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return String.valueOf(time);
    }


    public void setTime(String time) {
        this.time = time;
    }
    public int getLocation() {
        return location;
    }


    public void setLocation(int location) {
        this.location = location;
    }
    public int getIdLocation() {
        return location;
    }


    public void setIdLocation(int location) {
        this.location = location;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "idEvent=" + idEvent +
                ", name='" + nameEvent + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", location=" + location +
                ", price=" + price +
                ", ticketsSold=" + ticketsSold +
                '}';
    }

}
