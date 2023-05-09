package tp_product.dao;

import exercice3dao.model.Customer;
import tp_product.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection _connection;
    private PreparedStatement statement;
    private String request;
    private ResultSet resultSet;

    public ProductDAO(Connection connection) {
        this._connection = connection;
    }

    public boolean save(Product product) throws SQLException {
        request = "INSERT INTO product (name, description, price, qty) values (?,?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product.getQty());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            product.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    public List<Product> get() throws SQLException {
        List<Product> products = new ArrayList<>();
        request = "SELECT * FROM product";
        statement = _connection.prepareStatement(request);

        resultSet = statement.executeQuery();
        while(resultSet.next()) {
            Product product = new Product(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("qty"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price")
            );
            products.add(product);
        }
        return products;
    }

    public Product get(int id) throws SQLException {
        Product product = null;
        request = "SELECT * FROM product where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            product = new Product(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("qty"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price")
            );
        }
        return product;
    }

    public boolean update(Product product) throws SQLException {
        request = "UPDATE product set name = ?, description = ?, price = ?, qty = ? where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product.getQty());
        statement.setInt(5, product.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    public boolean delete(Product product) throws SQLException {
        request = "DELETE FROM product where id = ?";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, product.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }
}
