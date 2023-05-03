package exercice3;

import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    String choix;
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
            if(customer.save()) {
                System.out.println("Client ajouté "+ customer.getId());
            }else {
                customer = null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            customer = null;
        }
        return customer;
    }
    private void createAccountAction() {
        Customer customer = createCustomerAction();
        if(customer != null) {
            BankAccount bankAccount = new BankAccount(customer.getId(), 0);
            try {
                if(bankAccount.save()) {
                    System.out.println("Compté créé avec l'id "+ bankAccount.getId());
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
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
            if(bankAccount.makeDeposit(operation)) {
                System.out.println("Dépôt Ok");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withDrawlAction() {
        BankAccount bankAccount = getAccountAction();
        System.out.print("Merci de saisir le montant du dépôt : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        Operation operation = new Operation(montant*-1, bankAccount.getId());
        try {
            if(bankAccount.makeWithDrawl(operation)) {
                System.out.println("Retrait Ok");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private BankAccount getAccountAction() {
        BankAccount bankAccount = null;
        System.out.print("Merci de saisir l'id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            bankAccount = BankAccount.getById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(bankAccount != null) {
            System.out.println(bankAccount);
        }
        return bankAccount;
    }
}
