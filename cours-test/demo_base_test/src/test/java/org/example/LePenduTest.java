package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LePenduTest {


    private LePendu pendu;

    @Mock
    private IGenerateur generateur;

    @BeforeEach
    void setUp() throws Exception {
        pendu = new LePendu();
        Mockito.when(generateur.generer()).thenReturn("voiture");
        pendu.genererMasque(generateur);
    }

    @Test
    void testGenererMasqueShouldBeCorrect() throws Exception {
        //Arrange
        Mockito.when(generateur.generer()).thenReturn("voiture");

        pendu.genererMasque(generateur);

        Assertions.assertEquals("*******", pendu.getMasque());

    }

    @Test
    void testGenererMasqueShouldRaiseExceptionIfNotCorrectString() throws Exception {
        //Arrange
        Mockito.when(generateur.generer()).thenReturn("");

        Assertions.assertThrowsExactly(WordException.class, () -> {
            pendu.genererMasque(generateur);
        });
    }

    @Test
    void testGenererMasqueShouldRaiseExceptionIfStringIsNull() throws Exception {
        //Arrange
        Mockito.when(generateur.generer()).thenReturn(null);

        Assertions.assertThrowsExactly(WordException.class, () -> {
            pendu.genererMasque(generateur);
        });
    }

    @Test
    void testTestChaShouldBeTrueIfCorrectChar() throws Exception {

        boolean res = pendu.testChar('v');

        Assertions.assertTrue(res);
    }

    @Test
    void testTestChaShouldBeFalseIfNotCorrectChar() throws Exception {

        boolean res = pendu.testChar('g');

        Assertions.assertFalse(res);
    }

    @Test
    void testTestChaShouldNotUpdateNbEssaiIfCorrectChar() throws Exception {
        int oldNbEssai = pendu.getNbEssai();
        boolean res = pendu.testChar('v');

        Assertions.assertEquals(oldNbEssai, pendu.getNbEssai());
    }

    @Test
    void testTestChaShouldUpdateNbEssaiIfNotCorrectChar() throws Exception {
        int oldNbEssai = pendu.getNbEssai();
        boolean res = pendu.testChar('g');

        Assertions.assertEquals(oldNbEssai-1, pendu.getNbEssai());
    }

    @Test
    void testTestChaShouldBeFalseIfCorrectCharAndNbEssai0() throws Exception {
        pendu.setNbEssai(0);
        boolean res = pendu.testChar('v');

        Assertions.assertFalse(res);
    }

    @Test
    void testTestChaShouldUpdateMasqueIfCorrectChar() throws Exception {

        //Act
        pendu.testChar('v');
        pendu.testChar('o');

        Assertions.assertEquals("vo*****", pendu.getMasque());
    }

    @Test
    void testTestChaShouldNotUpdateMasqueIfNotCorrectChar() throws Exception {

        //Act
        pendu.testChar('v');
        pendu.testChar('g');

        Assertions.assertEquals("v******", pendu.getMasque());
    }

    @Test
    void testWinShouldBeTrueIfCorrectWord() throws Exception {
        pendu.setMasque("voitur*");
        pendu.testChar('e');

        boolean res = pendu.testWin();

        Assertions.assertTrue(res);
    }

    @Test
    void testWinShouldBeFalseIfWrongWord() throws Exception {
        pendu.testChar('e');

        boolean res = pendu.testWin();

        Assertions.assertFalse(res);
    }

    @Test
    void testWinShouldBeFalseIfNbEsssai() throws Exception {
        pendu.setMasque("voitur*");
        pendu.setNbEssai(0);
        pendu.testChar('e');

        boolean res = pendu.testWin();

        Assertions.assertFalse(res);
    }
}
