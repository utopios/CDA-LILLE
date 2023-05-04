package exercice3avectransaction;

import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;

public class Customer extends BaseJDBC {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Customer(int id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO customer (first_name, last_name, phone) values (?,?,?)";
        _connection = new DataBaseManager().getConnection();
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getFirstName());
        statement.setString(2, getLastName());
        statement.setString(3, getPhone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

    public static Customer getById(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customer where id = ?";
        _connection = new DataBaseManager().getConnection();
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            customer = new Customer(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone")
                    );
        }
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
