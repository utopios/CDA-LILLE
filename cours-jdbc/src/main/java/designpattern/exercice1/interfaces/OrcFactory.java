package designpattern.exercice1.interfaces;

import designpattern.exercice1.interfaces.impl.ArcherOrc;
import designpattern.exercice1.interfaces.impl.CavalierOrc;
import designpattern.exercice1.interfaces.impl.InfanterieOrc;

public class OrcFactory extends FactionFactory{
    @Override
    public Cavalier creerCavalier() {
        return new CavalierOrc();
    }

    @Override
    public Archer creerArcher() {
        return new ArcherOrc();
    }

    @Override
    public Infanterie creerInfanterie() {
        return new InfanterieOrc();
    }
}
