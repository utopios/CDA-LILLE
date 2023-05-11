package org.example;

import designpattern.abstractfactory.Client;
import designpattern.abstractfactory.ModerneMeubleFactory;
import designpattern.abstractfactory.VictorienMeubleFactory;
import org.example.util.DataBaseManager;
import tp_car.util.IHM;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        DataBaseManager dataBaseManager = new DataBaseManager();
//        Scanner scanner = new Scanner(System.in);
//        try {
//            Connection connection = dataBaseManager.getConnection();
//            System.out.println("Connection Ok");
////            System.out.println("Merci de saisir le prénom : ");
////            String firstName = scanner.nextLine();
////            System.out.println("Merci de saisir le nom : ");
////            String lastName = scanner.nextLine();
//            //Une requete pour l'insertion des données.
//            //String request = "INSERT INTO personne (first_name, last_name) values ('"+firstName+"', '"+lastName+"')";
//           // String request = "INSERT INTO personne (first_name, last_name) values (?, ?)";
//            //Un objet qui respecte l'interface statement est un objet qui permet l'exécution des requêtes sql
//
//            //Façon 1 => execution de requête sans retour
////            Statement statement = connection.createStatement();
////            boolean res = statement.execute(request);
////            System.out.println("Requête executée");
////            if(res) {
////                System.out.println("Des données renvoyées par la requête");
////            }
////            else {
////                System.out.println("Aucune données renvoyées par la requête");
////            }
//            //Façon 2 => avec une requête préparée
////            PreparedStatement preparedStatement = connection.prepareStatement(request);
////            preparedStatement.setString(1,firstName);
////            preparedStatement.setString(2, lastName);
////            //preparedStatement.execute();
////            int nbRows = preparedStatement.executeUpdate();
////            System.out.println("Nombre ligne "+nbRows);
//
//            //Façon 3 => avec une requête de lecture
//            String request = "SELECT * FROM personne";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(request);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("id") + "," + resultSet.getString("first_name") +","+ resultSet.getString("last_name"));
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }

        //Correction exercice 1
        //new IHM().start();
        //Correction exercice 2
        //new IHM().start();
        //Correction exercice 3
        //new IHM().start();
        //new IHM().start();
        //new IHM().start();
        //new IHM().start();
        Client client1 = new Client(new ModerneMeubleFactory());
        client1.asseoir();
        Client client2 = new Client(new VictorienMeubleFactory());
        client2.asseoir();
    }
}