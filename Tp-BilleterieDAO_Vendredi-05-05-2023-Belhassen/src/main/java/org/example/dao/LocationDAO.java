package org.example.dao;

import org.example.entity.Location;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class LocationDAO extends BaseDAO<Location> {
    public LocationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Location element) throws SQLException {
        request  = "INSERT INTO location (name, address, capacity) VALUES (?, ?, ?)";
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getName());
            statement.setString(2, element.getAddress());
            statement.setInt(3, element.getCapacity());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
    }

    @Override
    public Location get(int idLocation) throws SQLException {
        Location location = null;
        request = "SELECT * FROM billeterie.location WHERE idLocation = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, idLocation);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                location = new Location(
                        resultSet.getInt("idLocation"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
            }
            return location;
        }

    @Override
    public boolean update(Location element) throws SQLException {
        request = "UPDATE billeterie.location SET name = ?, address = ?, capacity = ? WHERE idLocation= ?";
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getName());
            statement.setString(2, element.getAddress());
            statement.setInt(3, element.getCapacity());
            statement.setInt(4, element.getIdLocation());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
    }

    @Override
    public List<Location> get() throws SQLException {
            List<Location> result = new ArrayList<>();
            request = "SELECT * FROM billeterie.location";
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(
                        resultSet.getInt("idLocation"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity"));
                result.add(l);
            }
            return result;
    }

    @Override
    public boolean delete(Location element) throws SQLException {
        request = "DELETE FROM billeterie.location WHERE idLocation = ?";
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdLocation());
            int nbRows = statement.executeUpdate();
            return nbRows == 1;
        }

}
