package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    @Test
    void AdditionTest() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        int result = calculatrice.addition(-1, 1);

        //Assert
        Assertions.assertEquals(0, result);
    }
}
