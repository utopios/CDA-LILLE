package tp_product.dao;

import tp_product.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductDAO {
    private Connection _connection;
    private PreparedStatement statement;
    private String request;
    private ResultSet resultSet;

    public ProductDAO(Connection connection) {
        this._connection = connection;
    }

    public boolean save(Product product) {
        return false;
    }

    public List<Product> get() {
        return null;
    }

    public Product get(int id){
        return null;
    }

    public boolean update(Product product) {
        return false;
    }

    public boolean delete(Product product) {
        return false;
    }
}
