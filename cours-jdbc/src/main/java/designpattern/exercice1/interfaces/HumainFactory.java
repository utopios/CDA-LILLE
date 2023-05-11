package designpattern.exercice1.interfaces;

import designpattern.exercice1.interfaces.impl.ArcherHumain;
import designpattern.exercice1.interfaces.impl.CavalierHumain;
import designpattern.exercice1.interfaces.impl.InfanterieHumain;

public class HumainFactory extends FactionFactory{
    @Override
    public Cavalier creerCavalier() {
        return new CavalierHumain();
    }

    @Override
    public Archer creerArcher() {
        return  new ArcherHumain();
    }

    @Override
    public Infanterie creerInfanterie() {
        return new InfanterieHumain();
    }


}
