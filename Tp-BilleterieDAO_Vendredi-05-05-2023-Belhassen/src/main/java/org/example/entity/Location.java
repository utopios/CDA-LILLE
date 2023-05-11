package org.example.entity;

public class Location {
    private  int idLocation;

    private String name;

    private String address;

    private int capacity;

    public Location(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public Location(int idLocation, String name, String address, int capacity) {
        this(name, address, capacity);
        this.idLocation = idLocation;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public  void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "Location{" + "idLocation=" + idLocation + ", name='" + name + '\'' + ", address='" + address + '\'' + ", capacity=" + capacity + '}';
    }


}
