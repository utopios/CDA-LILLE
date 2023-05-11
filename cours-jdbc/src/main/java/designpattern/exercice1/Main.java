package designpattern.exercice1;

import designpattern.exercice1.interfaces.HumainFactory;
import designpattern.exercice1.interfaces.OrcFactory;

public class Main {
    public static void main(String[] args) {
        Jeu j1 = new Jeu(new HumainFactory());
        Jeu j2 = new Jeu(new OrcFactory());
        j1.archers.forEach(a -> a.tirer());
        j1.infanteries.forEach(i -> i.combattre());
        j1.cavaliers.forEach(c -> c.charger());
        j2.archers.forEach(a -> a.tirer());
        j2.infanteries.forEach(i -> i.combattre());
        j2.cavaliers.forEach(c -> c.charger());
    }
}
