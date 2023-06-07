package com.example.correctionpatient.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FicheSoins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @OneToOne()
    private Consultation consultation;
}
