package org.example.dao;

import org.example.entity.Evenement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.*;

public class EvenementDAO extends BaseDAO<Evenement> {
    public EvenementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Evenement evenement) throws SQLException {
        request = "INSERT INTO evenement (nameEvent, date, time, idLocation, price, ticketsSold) VALUES (?, ?, ?, ?, ?, ?)";
        statement = _connection.prepareStatement(request, RETURN_GENERATED_KEYS);
        statement.setString(1, evenement.getNameEvent());
        statement.setString(2, evenement.getDate());
        statement.setString(3, evenement.getTime());
        statement.setInt(4, evenement.getIdLocation());
        statement.setDouble(5, evenement.getPrice());
        statement.setInt(6, evenement.getTicketsSold());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Evenement get(int id) throws SQLException {
        Evenement evenement = null;
        request = "SELECT * FROM billeterie.evenement WHERE idEvent = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            evenement = new Evenement(
                    resultSet.getInt("idEvent"),
                    resultSet.getString("nameEvent"),
                    resultSet.getString("date"),
                    resultSet.getString("time"),
                    resultSet.getInt("idLocation"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("ticketsSold")
            );
        }
        return evenement;
    }

    @Override
    public boolean update(Evenement element) throws SQLException {
        request = "UPDATE billeterie.evenement SET nameEvent = ?, date = ?, time = ?, idLocation = ?, price = ?, ticketsSold = ? WHERE idEvent = ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, element.getNameEvent());
        statement.setString(2, element.getDate());
        statement.setString(3, element.getTime());
        statement.setInt(4, element.getIdLocation());
        statement.setDouble(5, element.getPrice());
        statement.setInt(6, element.getTicketsSold());
        statement.setInt(7, element.getIdEvent());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;

    }

    @Override
    public List<Evenement> get() throws SQLException {
        List<Evenement> evenement = new ArrayList<>();
        request = "SELECT * FROM billeterie.evenement";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            evenement.add(new Evenement(
                    resultSet.getInt("idEvent"),
                    resultSet.getString("nameEvent"),
                    resultSet.getString("date"),
                    resultSet.getString("time"),
                    resultSet.getInt("idLocation"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("ticketsSold")
            ));
        }
        return evenement;

    }

    @Override
    public boolean delete(Evenement element) throws SQLException {
        request = "DELETE FROM billeterie.evenement WHERE idEvent = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getIdEvent());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }
}