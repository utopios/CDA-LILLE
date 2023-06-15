package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Frame {
    private int score;
    private boolean _lastFrame;
    private IFrameGenerateur _generateur;
    private List<Roll> rolls;

    public int getScore() {
        int score = 0;
        for(Roll r : rolls) {
            score += r.getPins();
        }
        return score;
    }

    public Frame(IFrameGenerateur generateur, boolean lastFrame) {
        _lastFrame = lastFrame;
        _generateur = generateur;
        rolls = new ArrayList<>();
    }

    public boolean makeRoll() throws Exception {
        int max = 10;
        if(!_lastFrame) {
//            if(rolls.size() >= 2) {
//                return false;
//            }
//            if(rolls.size() > 0) {
//                int firstRollPins = rolls.get(0).getPins();
//                if(firstRollPins == 10) {
//                    return false;
//                }
//                max = 10 - firstRollPins;
//            }
//            int s = _generateur.randomPin(max);
//            Roll roll = new Roll(s);
//            rolls.add(roll);
//            return true;
            if (rolls.size() == 0 || (rolls.size() < 2 && rolls.get(0).getPins() < 10)) {
                max = rolls.size() == 0 ? 10 : 10 - rolls.get(0).getPins();
                int s = _generateur.randomPin(max);
                Roll roll = new Roll(s);
                rolls.add(roll);
                return true;
            }
            return false;
        }
        else {
            if(rolls.size() <= 2 && (rolls.get(0).getPins() == 10 || (rolls.get(0).getPins() + rolls.get(1).getPins() == 10))) {
                int firstRollPins = rolls.get(0).getPins();
                if(rolls.size() <= 1) {
                    max = (firstRollPins == 10) ? 10 : 10 - firstRollPins;
                }
                else {
                    max = (rolls.get(1).getPins() == 10 || (rolls.get(0).getPins() + rolls.get(1).getPins() == 10)) ? 10 : 10 - rolls.get(1).getPins();
                }
                int s = _generateur.randomPin(max);
                Roll roll = new Roll(s);
                rolls.add(roll);
                return true;
            }
            return false;
        }
    }
}
