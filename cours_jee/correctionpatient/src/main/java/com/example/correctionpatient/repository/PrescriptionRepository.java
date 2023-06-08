package com.example.correctionpatient.repository;

import com.example.correctionpatient.entity.Consultation;
import com.example.correctionpatient.entity.Prescription;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class PrescriptionRepository extends Repository<Prescription> {
    public PrescriptionRepository(Session session) {
        super(session);
    }


    @Override
    public Prescription findById(int id) {
        return _session.get(Prescription.class, id);
    }

    @Override
    public List<Prescription> findAll() {
        return _session.createQuery("from Prescription ").list();
    }

    public List<Prescription> findAllByConsultationId(int consultationId) {
        Query<Prescription> query = _session.createQuery("from Prescription  where consultation.id = :id");
        query.setParameter("id", consultationId);
        return query.list();
    }
}
