package org.example.service;

import org.example.config.DataBaseSingleton;
import org.example.dao.TicketDAO;
import org.example.entity.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService {

    private Connection connection;

    private TicketDAO ticketDAO;

    public TicketService() {
        try {
            connection = DataBaseSingleton.getInstance().getConnection();
            ticketDAO = new TicketDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Ticket getTicket(int id) {
        try {
            return ticketDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean saveTicket(int idClient, int idEvenement, int nbTickets) {
        Ticket ticket = new Ticket(idClient, idEvenement, nbTickets);
        try {
            if (ticketDAO.save(ticket)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateTicket(int id, int idClient, int idEvenement, int nbTickets) throws SQLException {
        try {
            Ticket ticket = getTicket(id);
            ticket.setIdClient(idClient);
            ticket.setIdEvenement(idEvenement);
            ticket.setNbTickets(nbTickets);
            if (ticketDAO.update(ticket)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


        public boolean deleteTicket(int id) {
            Ticket ticket = null;
            try {
                ticket = ticketDAO.get(id);
                if (ticket != null) {
                    return ticketDAO.delete(ticket);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

    public List<Ticket> getAllTickets() {
        try {
            return ticketDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}