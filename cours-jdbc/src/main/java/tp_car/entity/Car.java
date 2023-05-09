package tp_car.entity;

public class Car {
    private int id;
    private String model;
    private int power;
    private double price;
    private String year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Car(String model, int power, double price, String year) {
        this.model = model;
        this.power = power;
        this.price = price;
        this.year = year;
    }

    public Car(int id, String model, int power, double price, String year) {
        this(model, power, price, year);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", price=" + price +
                ", year='" + year + '\'' +
                '}';
    }
}
