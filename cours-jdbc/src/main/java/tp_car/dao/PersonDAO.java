package tp_car.dao;

import tp_car.entity.Person;

import java.sql.Connection;
import java.util.List;

public class PersonDAO extends BaseDAO<Person> {
    protected PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Person element) {
        return false;
    }

    @Override
    public boolean update(Person element) {
        return false;
    }

    @Override
    public boolean delete(Person element) {
        return false;
    }

    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public List<Person> get() {
        return null;
    }
}
