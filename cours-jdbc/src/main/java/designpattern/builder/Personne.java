package designpattern.builder;

import lombok.Builder;

@Builder
public class Personne {
    private String nom;
    private String prenom;
    private String telephone;
}
