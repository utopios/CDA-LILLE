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
       boolean result = false;
       if(getNbEssai()> 0 && motATrouve.contains(String.valueOf(c))) {
           String tmpMasque = "";
           for(int i=0; i < motATrouve.length(); i++) {
               if(motATrouve.charAt(i) == c) {
                   tmpMasque += c;
               }else {
                   tmpMasque += masque.charAt(i);
               }
           }
           masque = tmpMasque;
           result = true;
       }
       else {
           nbEssai--;
       }
       return result;
    }

    public boolean testWin() throws Exception {
        return getNbEssai() > 0 && getMasque().equals(motATrouve);
    }
}