package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository(Session session) {
        super(session);
    }



    @Override
    public boolean update(Patient o) {
        return false;
    }

    @Override
    public boolean delete(Patient o) {
        return false;
    }

    @Override
    public Patient findById(int id) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }
}
