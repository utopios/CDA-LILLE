package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @BeforeEach
    void setUp() {
        rechercheVille = new RechercheVille();
        rechercheVille.setVilles(Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul"));
    }

    //Q1
    @Test
    void rechercheVilleShouldRaiseExceptionWhenIsLessThan2chars() {
        Assertions.assertThrowsExactly(NotFoundException.class, ()-> {
           rechercheVille.rechercher("a");
        });
    }

    //Q2
    @Test
    void rechercheVilleShouldBeListWhenIsGT2chars() throws ExecutionControl.NotImplementedException, NotFoundException {
        List<String> result = rechercheVille.rechercher("Va");

        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), result);
    }

    //Q3
    @Test
    void rechercheVilleShouldNotBeCaseSensitive() throws ExecutionControl.NotImplementedException, NotFoundException {
        List<String> result = rechercheVille.rechercher("vA");

        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), result);
    }

    //Q4
    @Test
    void rechercheVilleShouldBeListWhenIsContains2chars() throws ExecutionControl.NotImplementedException, NotFoundException {
        List<String> result = rechercheVille.rechercher("ap");

        Assertions.assertEquals(Arrays.asList("Budapest"), result);
    }

    //Q5
    @Test
    void rechercheVilleShouldReturnAllCitiesWhenMotContainsAsterisk() throws ExecutionControl.NotImplementedException, NotFoundException {
        List<String> result = rechercheVille.rechercher("*");

        Assertions.assertEquals(Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul"), result);
    }
}
