package designpattern.abstractfactory;

public class Client {
    MeubleFactory _meubleFactory;

    public Client(MeubleFactory meubleFactory) {
        _meubleFactory = meubleFactory;
    }

    public void asseoir() {
        Chaise chaise = _meubleFactory.creerChaise();
        chaise.asseoir();
    }
}
