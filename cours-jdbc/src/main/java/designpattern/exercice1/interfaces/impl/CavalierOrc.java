package designpattern.exercice1.interfaces.impl;

import designpattern.exercice1.interfaces.Cavalier;

public class CavalierOrc implements Cavalier {
    @Override
    public void charger() {
        System.out.println("Cavalier orc");
    }
}
