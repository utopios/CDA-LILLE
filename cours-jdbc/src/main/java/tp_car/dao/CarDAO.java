package tp_car.dao;

import tp_car.entity.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends BaseDAO<Car>{
    public CarDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Car element) throws SQLException {
        request = "INSERT INTO car(model,year,power,price) VALUE (?,?,?,?)";
        statement= _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getModel());
        statement.setString(2,element.getYear());
        statement.setInt(3,element.getPower());
        statement.setDouble(4,element.getPrice());
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows ==1;
    }

    @Override
    public boolean update(Car element) throws SQLException {
        request = "UPDATE car SET model = ?, year = ?,power = ?,price = ? WHERE id =?";
        statement = _connection.prepareStatement(request);
        statement.setString(1,element.getModel());
        statement.setString(2,element.getYear());
        statement.setFloat(3,element.getPower());
        statement.setDouble(4,element.getPrice());
        statement.setInt(5,element.getId());
        int rows = statement.executeUpdate();
        return rows ==1;
    }

    @Override
    public boolean delete(Car element) throws SQLException {
        request = "DELETE FROM car WHERE id =?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int rows = statement.executeUpdate();
        return rows ==1;
    }

    @Override
    public Car get(int id) throws SQLException {
        Car car = null;
        request = "SELECT * FROM car WHERE id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            car = new Car(resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getInt("power"),
                    resultSet.getFloat("price"),
                    resultSet.getString("year"));
        }
        return car;
    }

    @Override
    public List<Car> get() throws SQLException {
        List<Car> cars = new ArrayList<>();
        request = "SELECT * FROM car";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            cars.add(new Car(resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getInt("power"),
                    resultSet.getFloat("price"),
                    resultSet.getString("year")));
        }
        return cars;
    }
}
