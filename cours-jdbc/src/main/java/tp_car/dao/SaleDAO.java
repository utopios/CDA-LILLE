package tp_car.dao;

import jdk.jshell.spi.ExecutionControl;
import tp_car.entity.Car;
import tp_car.entity.Person;
import tp_car.entity.Sale;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO extends BaseDAO<Sale>{
    public SaleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Sale element) throws SQLException {
        request = "INSERT INTO sale(car_id, person_id, sale_date) VALUE (?,?,?)";
        statement= _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getCar().getId());
        statement.setInt(2,element.getPerson().getId());
        statement.setDate(3, new Date(element.getSaleDate().getTime()));
        int rows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return rows ==1;
    }

    @Override
    public boolean update(Sale element) throws ExecutionControl.NotImplementedException {
       throw new ExecutionControl.NotImplementedException("Sale DAO");
    }

    @Override
    public boolean delete(Sale element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Sale DAO");
    }

    @Override
    public Sale get(int id) throws SQLException {
        Sale sale = null;
        request = "SELECT s.person_id , s.car_id, s.sale_date, p.first_name, p.last_name, p.age, c.model, c.price, c.year, c.power FROM sale as s inner join car as c on s.car_id = c.id inner join person as p on s.person_id = p.id where s.id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            sale = new Sale(id, resultSet.getDate("sale_date"));
            sale.setCar(new Car(resultSet.getInt("car_id"),
                    resultSet.getString("model"),
                    resultSet.getInt("power"),
                    resultSet.getDouble("price"),
                    resultSet.getString("year")));
            sale.setPerson(new Person(resultSet.getInt("person_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age")));
        }
        return sale;
    }

    @Override
    public List<Sale> get() throws SQLException {
        List<Sale> result = new ArrayList<>();
        request = "SELECT s.id, s.person_id , s.car_id, s.sale_date, p.first_name, p.last_name, p.age, c.model, c.price, c.year, c.power FROM sale as s inner join car as c on s.car_id = c.id inner join person as p on s.person_id = p.id";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Sale sale = new Sale(resultSet.getInt("id"), resultSet.getDate("sale_date"));
            sale.setCar(new Car(resultSet.getInt("car_id"),
                    resultSet.getString("model"),
                    resultSet.getInt("power"),
                    resultSet.getDouble("price"),
                    resultSet.getString("year")));
            sale.setPerson(new Person(resultSet.getInt("person_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age")));
            result.add(sale);
        }
        return result;
    }
}
