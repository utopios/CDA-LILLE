package tp_car.service;

import org.example.util.DataBaseManager;
import tp_car.dao.CarDAO;
import tp_car.dao.PersonDAO;
import tp_car.dao.SaleDAO;
import tp_car.entity.Car;
import tp_car.entity.Person;
import tp_car.entity.Sale;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SaleService {
    private Connection connection;
    private SaleDAO saleDAO;
    private CarDAO carDAO;
    private PersonDAO personDAO;

    public SaleService() {
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            personDAO = new PersonDAO(connection);
            carDAO = new CarDAO(connection);
            saleDAO = new SaleDAO(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createSale(int carId, int personId) {
        try {
            Person person = personDAO.get(personId);
            Car car = carDAO.get(carId);
            if(person != null && car != null) {
                Sale sale = new Sale(new Date(),car, person);
                if(saleDAO.save(sale)) {
                    connection.commit();
                    return true;
                }
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return  false;
    }

    public Sale getSale(int id) {
        try {
            return saleDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sale> getSales() {
        try {
            return saleDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
