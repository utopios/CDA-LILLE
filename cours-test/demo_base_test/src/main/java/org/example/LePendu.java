package org.example;

import jdk.jshell.spi.ExecutionControl;
import lombok.Data;

@Data
public class LePendu {
    private int nbEssai;
    private String masque;
    private String motATrouve;

    public  LePendu() {
        setNbEssai(7);
    }

    public void genererMasque(IGenerateur generateurMot) throws Exception {
        motATrouve = generateurMot.generer();
        if(motATrouve == null || motATrouve.equals("")) {
            throw new WordException();
        }
        masque = "";
        for (int i=0; i < motATrouve.length(); i++) {
            masque += "*";
        }
    }

    public boolean testChar(char c) throws Exception {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }

    public boolean testWin() throws Exception {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }
}