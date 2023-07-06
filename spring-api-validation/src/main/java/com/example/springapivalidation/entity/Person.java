package com.example.springapivalidation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=4, message ="Le username est trop court et il doit comporter au moins {min} caractères")
    @Column(name="user_name")
    private String userName;

    @Size(max= 10, message ="le lastName est trop long")
    @Column(name="last_name")
    private String lastName;

    @Email(message = "Ce n'est pas une adresse mail")
    @Column(name="email")
    private String email;

    @Min(value = 18, message = "La personne doit être majeur")
    @Column(name="age")
    private Integer age;


    @Pattern(regexp = "[0-9\\s]{10}")
    @Column(name="phone")
    private String phone;





}
