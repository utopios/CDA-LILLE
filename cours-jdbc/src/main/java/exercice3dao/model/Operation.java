package exercice3dao.model;

import org.example.util.DataBaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Operation {

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

    public void setId(int id) {
        this.id = id;
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
