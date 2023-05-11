package designpattern.exercice1.interfaces.impl;

import designpattern.exercice1.interfaces.Archer;

public class ArcherOrc implements Archer {
    @Override
    public void tirer() {
        System.out.println("Archer orc");
    }
}
