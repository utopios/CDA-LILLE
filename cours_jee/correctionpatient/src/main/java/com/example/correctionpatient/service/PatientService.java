package com.example.correctionpatient.service;

import com.example.correctionpatient.entity.Patient;
import com.example.correctionpatient.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PatientService {

    private SessionFactory _sessionFactory;
    private PatientRepository patientRepository;
    private Session session;

    public PatientService (SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public boolean createPatient (String name, String phone){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepository = new PatientRepository(session);
        Patient patient = Patient.builder().phone(phone).name(name).build();
        try{
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        }catch (Exception e){
            try{
                session.getTransaction().rollback();
            }catch (Exception except){
                System.out.println(except.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }
    
}
