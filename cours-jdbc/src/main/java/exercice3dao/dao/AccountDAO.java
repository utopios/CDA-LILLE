package exercice3dao.dao;

import exercice3dao.model.BankAccount;
import jdk.jshell.spi.ExecutionControl;
import org.example.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDAO extends BaseDAO<BankAccount> {

    public AccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO bank_account (total_amount, customer_id) values (?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getTotalAmount());
        statement.setInt(2, element.getCustomerId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1)) ;
        }
        return nbRow == 1;
    }

    @Override
    public BankAccount getById(int id) {
        return null;
    }

    @Override
    public List<BankAccount> getAll() throws ExecutionControl.NotImplementedException {
       throw new ExecutionControl.NotImplementedException("Account");
    }

    @Override
    public boolean update(BankAccount element) {
        return false;
    }
}
