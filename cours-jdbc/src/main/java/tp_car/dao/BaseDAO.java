package tp_car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection _connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    protected BaseDAO(Connection connection) {
        _connection = connection;
    }

    public abstract boolean save(T element);
    public abstract boolean update(T element);
    public abstract boolean delete(T element);
    public abstract T get(int id);
    public abstract List<T> get();
}
