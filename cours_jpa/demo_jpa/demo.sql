CREATE DATABASE jpa_demo;

CREATE TABLE Person (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
prenom VARCHAR(255) NOT NULL
);