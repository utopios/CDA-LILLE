package org.example;

import java.util.List;

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
    }

    public boolean makeRoll() throws Exception {
        throw new Exception();
    }
}
