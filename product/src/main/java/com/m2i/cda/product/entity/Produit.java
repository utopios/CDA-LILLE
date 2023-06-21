package com.m2i.cda.product.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String marque;

    private String reference;

    @Temporal(TemporalType.DATE)
    @Column(name="date_achat")
    private Date dateAchat;

    private double prix;

    private int stock;


}
