package tp_product.entity;

public class Product {

    private int id;
    private String name;
    private String qty;
    private String description;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, String qty, String description, double price) {
        this.name = name;
        this.qty = qty;
        this.description = description;
        this.price = price;
    }

    public Product(int id, String name, String qty, String description, double price) {
        this(name, qty, description, price);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
