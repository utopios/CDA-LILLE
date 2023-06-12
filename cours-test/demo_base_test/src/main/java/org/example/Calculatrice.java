package org.example;

public class Calculatrice {

    public int addition(int a, int b) {
        return a + b;
    }

    public int division(int a, int b) throws Exception {
        if(b != 0)
            return a / b;
        throw new Exception();
    }
}
