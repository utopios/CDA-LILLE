package exercice2;

import org.example.util.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Email {
    private int id;
    private String mail;
    private int contactId;

    private static String request;
    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public Email(String mail, int contactId) {
        this.mail = mail;
        this.contactId = contactId;
    }

    public Email(int id, String mail, int contactId) {
        this(mail, contactId);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO email (mail, contact_id) values (?, ?)";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getMail());
        statement.setInt(2, getContactId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

    public static List<Email> getEmailsByContactId(int contactId) throws SQLException {
        List<Email> results = new ArrayList<>();
        request = "SELECT * FROM email where contact_id = ?";
        connection = new DataBaseManager().getConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, contactId);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Email email = new Email(resultSet.getInt("id"),
                    resultSet.getString("mail"),
                    resultSet.getInt("contact_id"));
            results.add(email);
        }
        return results;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", contactId=" + contactId +
                '}';
    }
}
