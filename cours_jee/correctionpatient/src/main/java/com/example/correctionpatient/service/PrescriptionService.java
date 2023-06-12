package com.example.correctionpatient.service;

import com.example.correctionpatient.entity.FicheSoins;
import com.example.correctionpatient.entity.Prescription;
import com.example.correctionpatient.repository.PrescriptionRepository;
import com.example.correctionpatient.repository.SoinsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PrescriptionService {


    private SessionFactory _sessionFactory;
    private ConsultationService consultationService;

    private PrescriptionRepository prescriptionRepository;
    private Session session;

    public PrescriptionService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
        consultationService = new ConsultationService(_sessionFactory);

    }

    public boolean createPrescription (int consultationId, String content){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        prescriptionRepository = new PrescriptionRepository(session);
       Prescription prescription = Prescription.builder().content(content).consultation(consultationService.getByIdConsultation(consultationId)).build();
        try{
            prescriptionRepository.create(prescription);
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

    public Prescription getByIdFicheSoins (int id){
        Prescription prescription = null ;
        session = _sessionFactory.openSession();
        prescriptionRepository = new PrescriptionRepository(session);
        try{
            prescription = prescriptionRepository.findById(id);
        }catch (Exception e){

        }finally {
           session.close();
        }
        return prescription;
    }
}
