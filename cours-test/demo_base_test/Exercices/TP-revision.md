TP : Bataille navale

Objectif : Utiliser le développement piloté par les tests (TDD) pour créer un jeu de bataille navale simple en utilisant les servlets et les JSP.

Outils : Java, Java Enterprise Edition (JEE), JUnit, Mockito, Servlets, JSP

Instructions :

1. Création de la grille
   - Développez une servlet qui crée une grille de jeu. La grille doit être de taille 10x10. Utilisez une JSP pour afficher la grille.

2. Placement des navires

   - Ajoutez une fonctionnalité à votre servlet pour placer les navires sur la grille. Chaque joueur doit pouvoir placer 15 navires sur sa grille. Chaque navire occupe une seule cellule. Créez une JSP pour permettre au joueur de placer ses navires.

3. Tirer sur un navire

   - Ajoutez une fonctionnalité à votre servlet qui permet à un joueur de choisir une coordonnée (x, y) et de "tirer" sur cette coordonnée. Si un navire se trouve à cette coordonnée, c'est un "touché". Sinon, c'est un "manqué". Créez une JSP pour permettre au joueur de choisir une coordonnée et afficher le résultat du tir.

4. Couler les navires

   - Si un navire est touché, il est considéré comme coulé. Le joueur doit être informé qu'un navire a été coulé. Mettez à jour votre JSP pour afficher cette information.

5. Gagner la partie

   - Lorsqu'un joueur coule tous les navires de l'autre joueur, il gagne la partie. Le joueur doit être informé qu'il a gagné la partie. Mettez à jour votre JSP pour afficher cette information.

6. Tests unitaires

    - Pour chaque fonctionnalité, écrivez d'abord un test unitaire qui échoue, puis écrivez le code pour faire passer le test, et enfin refactorisez votre code. Utilisez JUnit pour vos tests unitaires et Mockito pour les simulations.