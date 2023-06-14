package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    private Jeu jeu;

    @Mock
    private IDe de;
    @Test
    void testWin() {
        jeu = new Jeu(de);

        Mockito.when(de.getValue()).thenReturn(6);

        Assertions.assertTrue(jeu.jouer());
    }
}
