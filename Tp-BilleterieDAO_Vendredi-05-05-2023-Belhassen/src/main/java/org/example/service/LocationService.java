package org.example.service;

import org.example.config.DataBaseSingleton;
import org.example.dao.LocationDAO;
import org.example.entity.Location;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LocationService {

    private Connection connection;
    private LocationDAO locationDAO;
    Scanner scanner = new Scanner(System.in);

    public LocationService(){
        try{
            connection = DataBaseSingleton.getInstance().getConnection();
            locationDAO = new LocationDAO(connection);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Location getLocation(int id){
        try{
            return locationDAO.get(id);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean saveLocationAction(String name, String address, int capacity){
        Location location = new Location(name, address, capacity);
        try{
            if(locationDAO.save(location)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateLocation(int idLocation, String name, String address, int capacity){
        try{
            Location location = getLocation(idLocation);
            location.setName(name);
            location.setAddress(address);
            location.setCapacity(capacity);
            if(locationDAO.update(location)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Location> getAllLocations(){
        try{
            return locationDAO.get();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteLocation(int idLocation){
        Location location = null;
        try{
            location = getLocation(idLocation);
            if(locationDAO.delete(location)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

}
