package exercice3avectransaction;

import org.example.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Operation extends BaseJDBC {

    private int id;
    private double amount;
    private OperationStatus status;

    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public Operation(double amount, int accountId) {
        this.amount = amount;
        this.accountId = accountId;
        this.status = (this.amount >= 0) ? OperationStatus.DEPOSIT : OperationStatus.WITHDRAWL;
    }

    public Operation(int id, double amount, int accountId) {
        this(amount, accountId);
        this.id = id;
    }

    public boolean save(Connection connection) throws SQLException {
        request = "INSERT INTO operation (amount, account_id, status) values (?,?,?)";
        _connection = connection;
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, getAmount());
        statement.setInt(2, getAccountId());
        statement.setInt(3, getStatus().ordinal());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            this.id = resultSet.getInt(1);
        }
        return nbRow == 1;
    }

    public static List<Operation> getAllByAccountId(int accountId) throws SQLException {
       List<Operation> operations = new ArrayList<>();
       request = "SELECT * FROM operation where account_id = ?";
       _connection = new DataBaseManager().getConnection();
       statement = _connection.prepareStatement(request);
       statement.setInt(1, accountId);
       resultSet = statement.executeQuery();
       while (resultSet.next()) {
           Operation o = new Operation(resultSet.getInt("id"), resultSet.getDouble("amount"), accountId);
           operations.add(o);
       }
       return operations;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                ", accountId=" + accountId +
                '}';
    }
}
enum OperationStatus {
    DEPOSIT,
    WITHDRAWL
}