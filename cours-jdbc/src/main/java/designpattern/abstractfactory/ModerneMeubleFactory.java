package designpattern.abstractfactory;

public class ModerneMeubleFactory implements  MeubleFactory{
    @Override
    public Chaise creerChaise() {
        return new ChaiseModerne();
    }
}
