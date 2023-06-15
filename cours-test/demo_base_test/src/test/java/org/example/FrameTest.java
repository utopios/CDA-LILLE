package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    private Frame frame;

    @Mock
    private IFrameGenerateur frameGenerateur;

    @BeforeEach
    void setUp() {
        frame = new Frame(frameGenerateur, false);
    }

    @Test
    void Roll_SimpleFrame_FirstRoll_CheckScore() throws Exception {
        Mockito.when(frameGenerateur.randomPin(10)).thenReturn(7);

        frame.makeRoll();

        Assertions.assertEquals(7, frame.getScore());
    }

    @Test
    void Roll_SimpleFrame_SecondRoll_CheckScore() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(6));
        frame.setRolls(rolls);
        Mockito.when(frameGenerateur.randomPin(4)).thenReturn(2);

        frame.makeRoll();

        Assertions.assertEquals(8, frame.getScore());
    }

    @Test
    void Roll_SimpleFrame_SecondRoll_FirstRollStrike_ReturnFalse() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        frame.setRolls(rolls);
        boolean res = frame.makeRoll();
        Assertions.assertFalse(res);
    }

    @Test
    void Roll_SimpleFrame_MoreRolls_ReturnFalse() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(6));
        rolls.add(new Roll(3));
        frame.setRolls(rolls);

        boolean res = frame.makeRoll();
        Assertions.assertFalse(res);
    }
    @Test
    void Roll_LastFrame_SecondRoll_FirstRollStrike_ReturnTrue() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        frame.setRolls(rolls);


        boolean res = frame.makeRoll();
        Assertions.assertTrue(res);
    }

    @Test
    void Roll_LastFrame_SecondRoll_FirstRollStrike_CheckScore() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        frame.setRolls(rolls);

        Mockito.when(frameGenerateur.randomPin(10)).thenReturn(2);
        frame.makeRoll();
        Assertions.assertEquals(12, frame.getScore());
    }

    @Test
    void Roll_LastFrame_ThirdRoll_FirstRollStrike_ReturnTrue() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        rolls.add(new Roll(6));
        frame.setRolls(rolls);

        boolean res = frame.makeRoll();
        Assertions.assertTrue(res);
    }

    @Test
    void Roll_LastFrame_ThirdRoll_FirstRollStrike_CheckScore() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        rolls.add(new Roll(6));
        frame.setRolls(rolls);
        Mockito.when(frameGenerateur.randomPin(4)).thenReturn(2);
        frame.makeRoll();
        Assertions.assertEquals(18, frame.getScore());
    }
    @Test
    void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(4));
        rolls.add(new Roll(6));
        frame.setRolls(rolls);
        boolean res = frame.makeRoll();
        Assertions.assertTrue(res);
    }

    @Test
    void Roll_LastFrame_ThirdRoll_Spare_CheckScore() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(4));
        rolls.add(new Roll(6));
        frame.setRolls(rolls);
        Mockito.when(frameGenerateur.randomPin(10)).thenReturn(8);
        frame.makeRoll();
        Assertions.assertEquals(18, frame.getScore());
    }

    @Test
    void Roll_LastFrame_FourthRoll_ReturnFalse() throws Exception {
        frame = new Frame(frameGenerateur, true);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(4));
        rolls.add(new Roll(6));
        rolls.add(new Roll(6));
        frame.setRolls(rolls);
        boolean res = frame.makeRoll();
        Assertions.assertFalse(res);
    }
}
