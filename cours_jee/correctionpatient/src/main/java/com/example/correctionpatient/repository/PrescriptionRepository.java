package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.Prescription;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionRepository extends Repository<Prescription> {
    public PrescriptionRepository(Session session) {
        super(session);
    }


    @Override
    public Prescription findById(int id) {
        return null;
    }

    @Override
    public List<Prescription> findAll() {
        return null;
    }
}
