package designpattern.abstractfactory;

public class VictorienMeubleFactory implements MeubleFactory{
    @Override
    public Chaise creerChaise() {
        return new ChaiseVictorienne();
    }
}
