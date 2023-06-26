package com.m2i.cda.lille.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private Long id;
    private String nom;
    private Double salaire;
    private Boolean disponible;

}
