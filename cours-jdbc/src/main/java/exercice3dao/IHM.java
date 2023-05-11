package exercice3dao;



import exercice3dao.dao.AccountDAO;
import exercice3dao.dao.CustomerDAO;
import exercice3dao.dao.OperationDAO;
import exercice3dao.model.BankAccount;
import exercice3dao.model.Customer;
import exercice3dao.model.Operation;
import jdk.jshell.spi.ExecutionControl;
import org.example.util.DataBaseManager;
import org.example.util.DataBaseManagerSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    String choix;

    private CustomerDAO customerDAO;
    private OperationDAO operationDAO;
    private AccountDAO accountDAO;

    private Connection connection;
    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createAccountAction();
                    break;
                case "2":
                    depositAction();
                    break;
                case "3":
                    withDrawlAction();
                    break;
                case "4":
                    getAccountAction();
                    break;
            }
        }while (!choix.equals("0"));
    }
    private void menu() {
        System.out.println("1 - Création de compte ");
        System.out.println("2 - Dépôt ");
        System.out.println("3 - Retrait ");
        System.out.println("4 - Affichage compte ");
    }

    private Customer createCustomerAction() {
        Customer customer = null;
        System.out.print("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Merci de saisir le téléphone : ");
        String phone = scanner.nextLine();
        customer = new Customer(firstName, lastName, phone);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            customerDAO = new CustomerDAO(connection);
            if(customerDAO.save(customer)) {
                System.out.println("Client ajouté "+ customer.getId());
            }else {
                customer = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            customer = null;
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }

        return customer;
    }
    private void createAccountAction() {
        Customer customer = createCustomerAction();
        accountDAO = new AccountDAO(connection);
        if(customer != null) {
            BankAccount bankAccount = new BankAccount(customer.getId(), 0);
            try {
                if(accountDAO.save(bankAccount)) {
                    System.out.println("Compté créé avec l'id "+ bankAccount.getId());
                }
                connection.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
    private void depositAction() {
        BankAccount bankAccount = getAccountAction();
        System.out.print("Merci de saisir le montant du dépôt : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        Operation operation = new Operation(montant, bankAccount.getId());
        try {
            connection = new DataBaseManager().getConnection();
            accountDAO = new AccountDAO(connection);
            operationDAO = new OperationDAO(connection);
            connection.setAutoCommit(false);
            if(bankAccount.makeDeposit(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount)) {
                System.out.println("Dépôt Ok");
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }

    private void withDrawlAction() {
        BankAccount bankAccount = getAccountAction();
        System.out.print("Merci de saisir le montant du dépôt : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        Operation operation = new Operation(montant*-1, bankAccount.getId());
        try {
            //connection = new DataBaseManager().getConnection();
            connection = DataBaseManagerSingleton.getInstance().getConnection();
            accountDAO = new AccountDAO(connection);
            operationDAO = new OperationDAO(connection);
            connection.setAutoCommit(false);
            if(bankAccount.makeWithDrawl(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount)) {
                System.out.println("Retrait Ok");
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
    private BankAccount getAccountAction() {
        BankAccount bankAccount = null;
        System.out.print("Merci de saisir l'id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            accountDAO = new AccountDAO(connection);
            bankAccount = accountDAO.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(bankAccount != null) {
            System.out.println(bankAccount);
        }
        return bankAccount;
    }
}
