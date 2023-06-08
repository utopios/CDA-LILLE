package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.FicheSoins;
import org.hibernate.Session;

import java.util.List;

public class SoinsRepository extends Repository<FicheSoins> {
    public SoinsRepository(Session session) {
        super(session);
    }

    @Override
    public boolean update(FicheSoins o) {
        return false;
    }

    @Override
    public boolean delete(FicheSoins o) {
        return false;
    }

    @Override
    public FicheSoins findById(int id) {
        return null;
    }

    @Override
    public List<FicheSoins> findAll() {
        return null;
    }
}
