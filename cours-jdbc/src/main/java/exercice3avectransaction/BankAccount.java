package exercice3avectransaction;

import org.example.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BankAccount extends BaseJDBC {
    private int id;
    private int customerId;

    private Customer customer;

    private List<Operation> operations;

    private double totalAmount;
    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public BankAccount(int customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public BankAccount(int id, int customerId, double totalAmount) {
        this(customerId, totalAmount);
        this.id = id;
    }

    public boolean save() throws SQLException {
        request = "INSERT INTO bank_account (total_amount, customer_id) values (?,?)";
        _connection = new DataBaseManager().getConnection();
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, getTotalAmount());
        statement.setInt(2, getCustomerId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }
    public boolean update(Connection connection) throws SQLException {
        request = "UPDATE bank_account set total_amount = ? where id = ?";
        _connection = connection;
        statement = _connection.prepareStatement(request);
        statement.setDouble(1, getTotalAmount());
        statement.setInt(2, getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
    public boolean makeDeposit(Operation operation) throws SQLException {
        Connection connection = new DataBaseManager().getConnection();
        connection.setAutoCommit(false);
        if(operation.getAmount() > 0 && operation.save(connection)) {
            operations.add(operation);
            totalAmount += operation.getAmount();
            boolean res = update(connection);
            connection.commit();
            return res;
        }
        return false;
    }
    public boolean makeWithDrawl(Operation operation) throws SQLException {
        Connection connection = new DataBaseManager().getConnection();
        connection.setAutoCommit(false);
        if(operation.getAmount() < 0 && getTotalAmount() >= operation.getAmount()*-1 && operation.save(connection)) {
            operations.add(operation);
            totalAmount += operation.getAmount();
            boolean res = update(connection);
            connection.commit();
            return  res;
        }
        return false;
    }
    public static BankAccount getById(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM bank_account where id = ?";
        _connection = new DataBaseManager().getConnection();
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            bankAccount = new BankAccount(resultSet.getInt("id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getDouble("total_amount")
            );
        }
        bankAccount.customer = Customer.getById(bankAccount.getId());
        bankAccount.operations = Operation.getAllByAccountId(bankAccount.getId());
        return bankAccount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customer=" + customer +
                ", operations=" + operations +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
