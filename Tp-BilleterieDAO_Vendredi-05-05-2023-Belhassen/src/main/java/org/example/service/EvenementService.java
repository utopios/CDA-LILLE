package org.example.service;

import org.example.config.DataBaseSingleton;
import org.example.dao.EvenementDAO;
import org.example.entity.Evenement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvenementService {
    private Connection connection;
    private EvenementDAO evenementDAO;

    public EvenementService(){
        try{
            connection = DataBaseSingleton.getInstance().getConnection();
            evenementDAO = new EvenementDAO(connection);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Evenement get(int id){
        try{
            return evenementDAO.get(id);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean saveEvenement(String nameEvent, String date, String time, int location, double price, int ticketsSold){
        Evenement evenement = new Evenement(nameEvent, date, time, location, price, ticketsSold);
        try{
            if(evenementDAO.save(evenement)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateEvenement(int idEvent, String nameEvent, String date, String time, int location, double price, int ticketsSold) {
        try {
            Evenement evenement = get(idEvent);
            evenement.setNameEvent(nameEvent);
            evenement.setDate(date);
            evenement.setTime(time);
            evenement.setLocation(location);
            evenement.setPrice(price);
            evenement.setTicketsSold(ticketsSold);
            if (evenementDAO.update(evenement)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean deleteEvenement(int id){
        Evenement evenement = null;
        try{
            evenement =  evenementDAO.get(id);
            if(evenementDAO.delete(evenement)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

        public List<Evenement>getAllEvenement(){
            try{
                return evenementDAO.get();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

}
