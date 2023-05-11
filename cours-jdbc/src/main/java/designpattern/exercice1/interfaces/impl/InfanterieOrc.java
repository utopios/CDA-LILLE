package designpattern.exercice1.interfaces.impl;

import designpattern.exercice1.interfaces.Infanterie;

public class InfanterieOrc implements Infanterie {
    @Override
    public void combattre() {
        System.out.println("Infanterie orc");
    }
}
