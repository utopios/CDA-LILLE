package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.Consultation;
import org.hibernate.Session;

import java.util.List;

public class ConsultationRepository extends Repository<Consultation> {
    public ConsultationRepository(Session session) {
        super(session);
    }



    @Override
    public boolean update(Consultation o) {
        return false;
    }

    @Override
    public boolean delete(Consultation o) {
        return false;
    }

    @Override
    public Consultation findById(int id) {
        return null;
    }

    @Override
    public List<Consultation> findAll() {
        return null;
    }
}
