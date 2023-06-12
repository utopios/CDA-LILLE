package com.example.correctionpatient.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
