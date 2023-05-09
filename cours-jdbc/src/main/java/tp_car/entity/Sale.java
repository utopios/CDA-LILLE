package tp_car.entity;

import java.util.Date;

public class Sale {
    private int id;
    private Date saleDate;
    private Car car;
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Sale(int id, Date saleDate) {
        this.id = id;
        this.saleDate = saleDate;
    }

    public Sale(Date saleDate, Car car, Person person) {
        this.saleDate = saleDate;
        this.car = car;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", car=" + car +
                ", person=" + person +
                '}';
    }
}
