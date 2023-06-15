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
    void setUp() {
        pendu = new LePendu();
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
}
