package exercice3dao.dao;


import jdk.jshell.spi.ExecutionControl;
import org.example.util.DataBaseManager;
import exercice3dao.model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {
    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws ExecutionControl.NotImplementedException, SQLException {
        request = "INSERT INTO customer (first_name, last_name, phone) values (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public Customer getById(int id) throws ExecutionControl.NotImplementedException, SQLException {
        Customer customer = null;
        request = "SELECT * FROM customer where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            customer = new Customer(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone")
            );
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws ExecutionControl.NotImplementedException, SQLException {
        throw new ExecutionControl.NotImplementedException("customer dao");
    }

    @Override
    public boolean update(Customer element) throws ExecutionControl.NotImplementedException, SQLException {
        throw new ExecutionControl.NotImplementedException("customer dao");
    }
}
