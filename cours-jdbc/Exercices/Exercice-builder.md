#Builder 
Supposons que vous développez une application pour une bibliothèque.
Dans cette application, il y a une classe Livre qui a plusieurs attributs
: titre, auteur, nombrePages, anneePublication, genre, et ISBN.

Cependant, tous les livres n'ont pas tous ces attributs.
Par exemple, certains livres peuvent ne pas avoir d'ISBN, et certains peuvent ne pas avoir de genre.
De plus, il y a tellement d'attributs que la création de livres avec un constructeur normal serait compliquée et sujette à des erreurs.

Votre tâche est de créer une classe Livre qui utilise le pattern Builder pour faciliter la création d'objets Livre.