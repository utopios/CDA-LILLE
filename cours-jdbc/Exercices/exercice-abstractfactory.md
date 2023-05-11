#Abstract Factory

Supposons que vous développiez un jeu de guerre. Dans ce jeu, il y a deux factions : les Humains et les Orcs. Chaque faction a différentes unités de combat : un Archer, un Cavalier et un Infanterie.

1. Définissez des interfaces pour chaque type d'unité : Archer, Cavalier et Infanterie.

2. Créez des classes concrètes pour chaque type d'unité pour chaque faction. Par exemple, ArcherHumain, CavalierHumain, InfanterieHumain, ArcherOrc, CavalierOrc et InfanterieOrc.

3. Créez une interface de factory abstraite FactionFactory qui a des méthodes pour créer chaque type d'unité.

4. Créez deux factories concrètes : HumainFactory et OrcFactory qui implémentent FactionFactory et créent les unités appropriées.

5. Écrivez une classe Jeu qui utilise FactionFactory pour créer des unités. Elle ne devrait pas se soucier de savoir si elle crée des unités humaines ou des unités orc.