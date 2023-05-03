package exercice3;

import java.util.List;

public class Operation extends BaseJDBC {

    private int id;
    private double amount;
    private OperationStatus status;

    private int accountId;

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

    public boolean save() {
        return false;
    }

    public static List<Operation> getAllByAccountId(int accountId) {
        return null;
    }
}
enum OperationStatus {
    DEPOSIT,
    WITHDRAWL
}