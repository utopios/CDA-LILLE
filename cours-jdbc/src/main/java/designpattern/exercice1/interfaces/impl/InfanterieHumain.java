package designpattern.exercice1.interfaces.impl;

import designpattern.exercice1.interfaces.Infanterie;

public class InfanterieHumain implements Infanterie {
    @Override
    public void combattre() {
        System.out.println("Infanterie humain");
    }
}
