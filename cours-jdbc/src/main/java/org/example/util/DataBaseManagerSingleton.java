package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManagerSingleton {

    private static DataBaseManagerSingleton instance;
    private static final String URI = "jdbc:mysql://localhost:3306/cours_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "test";

    private DataBaseManagerSingleton() {

    }

    public static DataBaseManagerSingleton getInstance() {
        if(instance == null)
            instance = new DataBaseManagerSingleton();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
