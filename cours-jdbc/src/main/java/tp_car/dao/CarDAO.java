package tp_car.dao;

import tp_car.entity.Car;

import java.sql.Connection;
import java.util.List;

public class CarDAO extends BaseDAO<Car>{
    protected CarDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Car element) {
        return false;
    }

    @Override
    public boolean update(Car element) {
        return false;
    }

    @Override
    public boolean delete(Car element) {
        return false;
    }

    @Override
    public Car get(int id) {
        return null;
    }

    @Override
    public List<Car> get() {
        return null;
    }
}
