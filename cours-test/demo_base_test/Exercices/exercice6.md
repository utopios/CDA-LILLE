## Exercice 6 ***TDD Avec Mock **Pendu*****

Le but de l'exercice est de développer un programme pour émuler le jeud du pendu.
Le jeu a une classe LePendu, cette classe possède:

- Une méthode pour générer un masque, cette méthode fait appelle à un objet qui permet de générer d'une façon aléatoire un mot à trouver à partir d'un tableau de mots.
- Une méthode pour tester si un char est dans le mot.
- Une méthode pour tester si le joueur a gagné.

## HELP

### Etape 1 ***Structure des classes***

1. LePendu

```
public class LePendu {
    private int nbEssai;
    private String masque;
    private String motATrouve;
    
    public void genererMasque(IGenerateur generateurMot) throws Exception {
        throw new Exception();
    }
    
    public boolean testChar(char c) throws Exception {
        throw new Exception();
    }
    
    public boolean testWin() throws Exception {
        throw new Exception();
    }
}
```
2. Interface IGenerateur

```
public interface IGenerateur {
    public String generer();
}
```

3. Création des tests pour les 3 méthodes de class LePendu