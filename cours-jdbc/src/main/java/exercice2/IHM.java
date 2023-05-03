package exercice2;

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
                    addContactAction();
                    break;
                case "2":
                    editContactAction();
                    break;
                case "3":
                    deleteContactAction();
                    break;
                case "4":
                    searchContactsAction();
                    break;
            }
        }while (!choix.equals("0"));
    }
    private void menu() {
        System.out.println("1 - Ajouter un contact");
        System.out.println("2 - Modifier un contact ");
        System.out.println("3 - Supprimer contact ");
        System.out.println("4 - Rechercher contacts ");
    }

    private void addContactAction() {
        System.out.print("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Merci de saisir le téléphone : ");
        String phone = scanner.nextLine();
        Contact contact = new Contact(firstName, lastName, phone);
        try {
            if(contact.save()) {
                System.out.println("Contact ajouté "+ contact.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editContactAction() {
        Contact contact = getContactAction();
        if(contact != null) {
            System.out.print("Merci de saisir le prénom : ");
            contact.setFirstName(scanner.nextLine());
            System.out.print("Merci de saisir le nom : ");
            contact.setLastName(scanner.nextLine());
            System.out.print("Merci de saisir le téléphone : ");
            contact.setPhone(scanner.nextLine());
            try {
                if(contact.update()) {
                    System.out.println("Mise à jour effectuée");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void deleteContactAction() {
        Contact contact = getContactAction();
        try {
            if(contact != null && contact.delete()) {
                System.out.println("Contact supprimé");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void searchContactsAction() {
        System.out.print("Merci de saisir le mot de recherche : ");
        String word = scanner.nextLine();
        try {
            Contact.search(word).forEach(c-> {
                System.out.println(c);
            });
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Contact getContactAction() {
        System.out.print("Merci de saisir l'id : ");
        int id =  scanner.nextInt();
        scanner.nextLine();
        try {
            Contact contact = Contact.getById(id);
            if(contact == null) {
                System.out.println("Aucun contact avec cet id");
            }
            return contact;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
