package designpattern.exercice1;

import designpattern.exercice1.interfaces.Archer;
import designpattern.exercice1.interfaces.Cavalier;
import designpattern.exercice1.interfaces.FactionFactory;
import designpattern.exercice1.interfaces.Infanterie;
import designpattern.exercice1.interfaces.impl.ArcherOrc;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

    FactionFactory _factionFactory;
    List<Cavalier> cavaliers;
    List<Archer> archers;
    List<Infanterie> infanteries;

    public Jeu(FactionFactory factionFactory) {
        _factionFactory = factionFactory;
        cavaliers = new ArrayList<>();
        archers = new ArrayList<>();
        infanteries = new ArrayList<>();
        for(int i=1; i < 11; i++) {
            cavaliers.add(_factionFactory.creerCavalier());
            infanteries.add(_factionFactory.creerInfanterie());
            archers.add(_factionFactory.creerArcher());
        }
    }

}
