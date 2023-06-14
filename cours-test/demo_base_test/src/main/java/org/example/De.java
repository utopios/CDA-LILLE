package org.example;

import java.util.Random;

public class De implements IDe {

    private Random random;

    public De() {
        random = new Random();
    }
    @Override
    public int getValue() {
        return random.nextInt(1,7);
    }
}
