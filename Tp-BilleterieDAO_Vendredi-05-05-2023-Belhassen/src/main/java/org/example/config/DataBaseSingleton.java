package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseSingleton {

        private static DataBaseSingleton instance;
        private Connection connection;
        private String url = "jdbc:mysql://localhost:3306/billeterie";
        private String username = "test";
        private String password = "password";

        private DataBaseSingleton() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public static DataBaseSingleton getInstance() throws SQLException {
            if (instance == null) {
                instance = new DataBaseSingleton();
            } else if (instance.getConnection().isClosed()) {
                instance = new DataBaseSingleton();
            }

            return instance;
        }
    }

