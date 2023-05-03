package exercice3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseJDBC {
    protected static Connection connection;
    protected static String request;
    protected static PreparedStatement statement;

    protected static ResultSet resultSet;
}
