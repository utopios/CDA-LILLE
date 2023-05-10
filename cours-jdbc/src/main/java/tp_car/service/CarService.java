package tp_car.service;

import org.example.util.DataBaseManager;
import tp_car.dao.CarDAO;
import tp_car.entity.Car;
import tp_car.entity.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarService {
    private Connection connection;
    private CarDAO carDAO;

    public CarService() {
        try {
            connection = new DataBaseManager().getConnection();
            carDAO = new CarDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCar(String model, double price, int power, String year) {
        Car car = new Car(model,power, price, year);
        try {
            if(carDAO.save(car)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateCar(int id, String model, double price, int power, String year) {
        try {
            Car car = getCar(id);
            car.setModel(model);
            car.setPrice(price);
            car.setPrice(power);
            car.setYear(year);
            if(carDAO.update(car)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Car getCar(int id) {
        try {
            return carDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCar(int id) {
        Car car = null;
        try {
            car = carDAO.get(id);
            if(car != null) {
                return carDAO.delete(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Car> getAllCars() {
        try {
            return carDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
