# TP Révision JAVA

Titre du TP : Gestion d'un système de billetterie en Java POO

Objectif : Ce TP permet de réviser et de renforcer les compétences en programmation orientée objet en Java. 
But du TP : implémenter un système de billetterie pour des événements tels que des concerts, des pièces de théâtre ou des conférences.

Plan du TP :

    Création des classes de base
        Classe Lieu
            Attributs : nom, adresse, capacité
            Méthodes : constructeur, getters, setters et toString
        Classe Evénement
            Attributs : nom, date, heure, lieu (objet de type Lieu), prix, nombre de billets vendus
            Méthodes : constructeur, getters, setters, toString, vérifier la disponibilité d'un billet, vendre un billet et annuler une vente de billet
        Classe Client
            Attributs : nom, prénom, email, liste des billets achetés (ArrayList de Evénement)
            Méthodes : constructeur, getters, setters, toString, acheterBillet et annulerAchatBillet

Implémentation des fonctionnalités
- Créer un menu interactif pour permettre aux utilisateurs de :
            ->gérer les événements
            ->les lieux
            ->les clients
- Ajouter des fonctionnalités pour :
            ->Ajouter, modifier et supprimer des lieux
            ->Ajouter, modifier et supprimer des événements
            ->Ajouter, modifier et supprimer des clients
            ->Acheter des billets pour un événement
            ->Annuler un achat de billet
            ->Afficher la liste des événements disponibles
            ->Afficher la liste des billets achetés par un client

- Gestion des exceptions
        Gérer les exceptions liées aux entrées utilisateur incorrectes (par exemple, format de date invalide, capacité négative, etc.)
        Gérer les exceptions liées à la vente de billets (par exemple, billets épuisés, annulation d'un achat inexistant, etc.)

- Améliorations et extensions possibles
        Ajouter la possibilité de créer des événements récurrents (par exemple, un événement qui se produit chaque semaine)
        Implémenter des remises pour les groupes ou les achats anticipés
        Ajouter des catégories de billets (par exemple, VIP, standard, etc.) avec des prix différents
        Permettre la réservation de sièges spécifiques pour les événements
        Gérer l'authentification et les autorisations pour les différentes actions (par exemple, un administrateur peut ajouter des événements, un client ne peut acheter des billets que pour lui-même)
![img.png](img.png)
