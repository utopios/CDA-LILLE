package exercice2;

import org.example.util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    private List<Email> emails;
    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public Statut statut;


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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Contact(int id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO contact (first_name, last_name, phone) values (?, ?, ?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getFirstName());
        statement.setString(2, getLastName());
        statement.setString(3, getPhone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }
    public boolean update() throws SQLException {
        request = "UPDATE  contact set first_name = ?, last_name = ?, phone = ? where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setString(1, getFirstName());
        statement.setString(2, getLastName());
        statement.setString(3, getPhone());
        statement.setInt(4, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public boolean delete() throws SQLException {
        request = "DELETE FROM contact  where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public static Contact getById(int id) throws SQLException {
        Contact contact = null;
        request = "SELECT * FROM contact where id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            contact = new Contact(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone"));
        }
        return contact;
    }

    public static List<Contact> search(String word) throws SQLException {
        List<Contact> results = new ArrayList<>();
        request = "SELECT * FROM contact where first_name like ? OR last_name like ? OR phone like ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setString(1, word+"%");
        statement.setString(2, word+"%");
        statement.setString(3, word+"%");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Contact contact = new Contact(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone"));
            results.add(contact);
        }
        return results;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

enum Statut {
    s1, s2
}
