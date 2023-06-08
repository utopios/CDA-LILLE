package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.FicheSoins;
import com.example.correctionpatient.entity.Prescription;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SoinsRepository extends Repository<FicheSoins> {
    public SoinsRepository(Session session) {
        super(session);
    }



    @Override
    public FicheSoins findById(int id) {
        return _session.get(FicheSoins.class, id);
    }

    @Override
    public List<FicheSoins> findAll() {
       return _session.createQuery("from FicheSoins ").list();
    }

    public List<FicheSoins> findAllByConsultationId(int consultationId) {
        Query<FicheSoins> query = _session.createQuery("from FicheSoins  where consultation.id = :id");
        query.setParameter("id", consultationId);
        return query.list();
    }
}
