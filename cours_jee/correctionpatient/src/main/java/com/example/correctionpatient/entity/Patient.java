package com.example.correctionpatient.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    List<Consultation> consultations;
}
