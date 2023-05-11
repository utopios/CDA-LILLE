package org.example.dao;

import org.example.entity.Ticket;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends BaseDAO<Ticket> {

    public TicketDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ticket element) throws SQLException {
        request = "INSERT INTO billeterie.ticket (idClient, idEvenement, nbTickets) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, element.getIdClient());
        statement.setInt(2, element.getIdEvenement());
        statement.setInt(3, element.getNbTickets());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public Ticket get(int id) throws SQLException {
        Ticket ticket = null;
        request = "SELECT * FROM billeterie.ticket WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            ticket = new Ticket(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("idEvenement"),
                    resultSet.getInt("nbTickets")
            );
        }
        return ticket;
    }


    @Override
    public boolean update(Ticket element) throws SQLException {
        request = "UPDATE billeterie.ticket SET idClient = ?,  idEvenement = ?, nbTickets = ?  WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getIdClient());
        statement.setInt(2, element.getIdEvenement());
        statement.setInt(3, element.getNbTickets());
        statement.setInt(4, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public List<Ticket> get() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        request = "SELECT * FROM billeterie.ticket";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            tickets.add(new Ticket(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("idEvenement"),
                    resultSet.getInt("nbTickets")
            ));
        }
        return tickets;
    }

    @Override
    public boolean delete(Ticket element) throws SQLException {
        request = "DELETE FROM billeterie.ticket WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }
//    public List<Ticket> getAllByUserId(int id) throws SQLException {
//        List<Ticket> tickets = new ArrayList<>();
//        request = "SELECT * FROM ticket WHERE idClient = ?";
//        statement = _connection.prepareStatement(request);
//        statement.setInt(1, id);
//        resultSet = statement.executeQuery();
//        if (resultSet.next()) {
//            Ticket ticket = new Ticket(
//                    resultSet.getInt("id"),
//                    resultSet.getInt("idClient"),
//                    resultSet.getInt("idEvenement"),
//                    resultSet.getInt("nbTickets")
//            );
//            tickets.add(ticket);
//        }
//        return tickets;
//    }
}



//    public String getEventById(int id) {
//        request = "SELECT * FROM evenement WHERE id = ?";
//        try {
//            statement = _connection.prepareStatement(request);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getString("nom");
//            }
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public String getNbTicketsById(int id) {
//        request = "SELECT * FROM ticket WHERE id = ?";
//        try {
//            statement = _connection.prepareStatement(request);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getString("nbTickets");
//            }
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }



