package org.example;

public class Jeu {

    private IDe _de;

    public Jeu(IDe de) {
        this._de = de;
    }

    public boolean jouer() {
        if(_de.getValue() == 6) {
            return true;
        }
        return false;
    }
}
