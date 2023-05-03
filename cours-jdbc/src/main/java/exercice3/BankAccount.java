package exercice3;

import java.util.List;

public class BankAccount extends BaseJDBC {
    private int id;
    private int customerId;

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

    public boolean save() {
        return false;
    }
    public boolean update() {
        return false;
    }
    public boolean makeDeposit(Operation operation) {
        return false;
    }
    public boolean makeWithDrawl(Operation operation) {
        return false;
    }
    public static BankAccount getById(int id) {
        return null;
    }


}
