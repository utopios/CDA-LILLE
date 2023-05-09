package tp_product;

import org.example.util.DataBaseManager;
import tp_product.dao.ProductDAO;
import tp_product.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private Connection connection;
    private ProductDAO produitDAO;
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
                    creationProduitAction();
                    break;
                case "2":
                    getProduitsAction();
                    break;
                case "3":
                    getProduitAction();
                    break;
                case "4":
                    updateProduitAction();
                    break;
                case "5":
                    deleteProduitAction();
                    break;
            }
        } while (!choix.equals("0"));
    }

    private void menu() {
        System.out.println("1. Enregistrer un produit");
        System.out.println("2. Afficher la liste des produits ");
        System.out.println("3. Afficher un produit");
        System.out.println("4. Mise à jour d'un produit");
        System.out.println("5. Supprimer un produit");
        System.out.println("6. Exit");

    }

    private Product creationProduitAction() {
        Product produit = null;
        System.out.println("Création d'un produit");
        System.out.print("Merci de saisir le nom du produit : ");
        String nom = scanner.nextLine();
        System.out.print("Merci de saisir le prix du produit : ");
        int prix = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Merci de saisir la quantité des produits : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Merci de saisir la description du produit : ");
        String description = scanner.nextLine();
        produit = new Product(nom, quantite, description, prix);
        try {
            connection = new DataBaseManager().getConnection();
            produitDAO = new ProductDAO(connection);
            if (produitDAO.save(produit)) {
                System.out.println("Produit ajouté avec l'id " + produit.getId());
            } else {
                produit = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            produit = null;
        }
        return produit;
    }

    private Product getProduitAction() {
        Product produit = null;
        System.out.println("Merci de saisir l'id du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            produitDAO = new ProductDAO(connection);
            produit = produitDAO.get(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (produit != null) {
            System.out.println(produit);
        }
        return produit;
    }

    private void deleteProduitAction() {
        System.out.println("Merci de saisir l'id du produit à supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            produitDAO = new ProductDAO(connection);
            produitDAO.delete(produitDAO.get(id));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        System.out.println("Votre produit a bien été supprimé ");
    }

    private List<Product> getProduitsAction() {
        List<Product> produit = null;
        System.out.println("Liste des produits");
        try {
            connection = new DataBaseManager().getConnection();
            produitDAO = new ProductDAO(connection);
            produit = produitDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (produit != null) {
            System.out.println(produit);
        }
        return produit;
    }

    private Product updateProduitAction() {
        System.out.println("Merci de saisir l'id du produit à modifier");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product produit = getProduitAction();
        System.out.print("Merci de saisir le nom du produit : ");
        produit.setName(scanner.nextLine());
        System.out.print("Merci de saisir le prix du produit : ");
        produit.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Merci de saisir la quantité des produits : ");
        produit.setQty(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Merci de saisir la description du produit : ");
        produit.setDescription(scanner.nextLine());
        try {
            connection = new DataBaseManager().getConnection();
            produitDAO = new ProductDAO(connection);
            produitDAO.update(produit);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Produit mise à jour");
        return produit;
    }
}
