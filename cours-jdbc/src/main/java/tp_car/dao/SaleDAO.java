package tp_car.dao;

import tp_car.entity.Sale;

import java.sql.Connection;
import java.util.List;

public class SaleDAO extends BaseDAO<Sale>{
    protected SaleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Sale element) {
        return false;
    }

    @Override
    public boolean update(Sale element) {
        return false;
    }

    @Override
    public boolean delete(Sale element) {
        return false;
    }

    @Override
    public Sale get(int id) {
        return null;
    }

    @Override
    public List<Sale> get() {
        return null;
    }
}
