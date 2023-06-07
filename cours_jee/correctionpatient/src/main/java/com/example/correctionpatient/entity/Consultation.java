package com.example.correctionpatient.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateConsultation;

    @ManyToOne
    private Patient patient;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private FicheSoins ficheSoins;
    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Prescription prescription;
}
