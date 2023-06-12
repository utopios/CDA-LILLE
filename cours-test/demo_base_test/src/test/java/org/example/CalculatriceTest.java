package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    @Test
    void additionTest() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        int result = calculatrice.addition(-1, 1);

        //Assert
        Assertions.assertEquals(0, result);
    }

    @Test
    void divisionTest1() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Pour une exception
        //Act et Assert
        Assertions.assertThrowsExactly(Exception.class, ()-> {
           //Act
           calculatrice.division(10,0);
        });

    }

    @Test
    void divisionTest2() throws Exception {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        int result = calculatrice.division(10,2);

       //Assert
        Assertions.assertEquals(5,result);

    }
}
