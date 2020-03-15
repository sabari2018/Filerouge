 I - DESCRIPTON DU PROJET
  ------------------------
 Ce projet consistait à réaliser une application qui permet de faire jouer trois types
 de joueurs (Humain, IA, Random) à un jeu au choix (Nim, Morpions,Puissance4).

 Acquis du projet : classe abstraites, d'interfaces et implémentation d'algorithme d'intelligence artificielle
 
 II - COMPILATION
 ---------------------------
 1 - Se placer dans le repertoire filerouge
 2 - Tapez la commande: javac -d build/ src/*/*.java

III - EXECUTION
----------------------------
    1 -> java -jar executable.jar argument_1 argument_2 argument_3 [argument_4] [argument_5]
        - argument_1 : le jeu Nim ou Tictactoe
        - argument_2 : le type du premier joueur (humain, random, minmax, mincache)
        - argument_3 : le type du second joueur (humain, random, minmax, mincache)
        - argument_4 : le nom du premier joueur s'il est humain
        - argument_5 : le nom du second joueur s'il est humain

Exemple:

    JEU DE NIM :
    ----------

   1 -> Pour lancer une partie de Nim avec deux joueurs humains
        - java -jar executable.jar nim humain humain Paul Pierre

   2 -> Pour lancer une partie de Nim avec un joueur humain et autre type de joueurs(Random, Minmax, Mincache)
        - java -jar executable.jar nim random humain Pierre
        - java -jar executable.jar nim humain minmax Pierre

   3 -> Pour lancer une partie de Nim avec deux joueurs non humain
        - java -jar executable.jar nim random minmax
        - java -jar executable.jar nim mincache random
        - java -jar executable.jar nim mincache minmax

    Avant de lancer le jeu, le programme demande d'entrer au clavier le nombre d'allumettes et le nombre maximal
    qu'un joueur peut prendre.

    Une fois le jeu lance, le programme demande a chaque joueur d'entrer au clavier son coup jusqu'a ce qu'il y ait
    plus d'allumettes, apres donne le nom du vainqueur.


    JEU DE TICTACTOE :
    ----------------

   1 -> Pour lancer une partie de Tictactoe avec deux joueurs humains
        - java -jar executable.jar Tictactoe humain humain Paul Pierre

   2 -> Pour lancer une partie de Tictactoe avec un joueur humain et autre type de joueurs(Random, Minmax,Mincache)
        - java -jar executable.jar Tictactoe random humain Pierre
        - java -jar executable.jar Tictactoe humain minmax Pierre

   3 -> Pour lancer une partie de Tictactoe avec deux joueurs non humain
        - java -jar executable.jar Tictactoe random minmax
        - java -jar executable.jar Tictactoe mincache random
        - java -jar executable.jar Tictactoe mincache minmax

    Apres validation par la touche ENTER, le programme lance une partie et demande a chaque joueur de joueur
    dans une case non occupee.

    Si l'un des joueurs occupe trois cases successifs en ligne, colonne ou diagonale, le jeu prend fin et
    le programme declare ce joueur vainqueur de la partie.

    Si toutes les cases sont occupees et qu'il ait pas un joueur qui trois cases successifs, le jeu prend fin
    et le programme annonce macth null.

  JEU DE PUISSANCE 4 :
  ------------------

   1 -> Pour lancer une partie de Puissance 4 avec deux joueurs humains
        - java -jar executable.jar power4game humain humain Paul Pierre

   2 -> Pour lancer une partie de Puissance 4 avec un joueur humain et autre type de joueurs(Random)
        - java -jar executable.jar power4game random humain Pierre
        - java -jar executable.jar power4game humain random Pierre

   3 -> Pour lancer une partie de Puissance 4 avec deux joueurs non humain
        - java -jar executable.jar power4game random random

    Apres validation par la touche ENTER, le programme lance une partie et demande tour à tour les deux
    joueurs de placer un pion dans la colonne de leur choix.

    Lorqu'un joueur alligne quatre pions (horizontal, verticale, diagonale), il gagne le jeu et si toutes
    les cases sont remplies et qu'aucun joueur n'alligne quatre pions il y a match null.


 IV FONCTIONNALITES NON IMPLEMENTEES
 -----------------------------------

    - Les joueurs Minmax et MinmaxCache ne sont pas geres dans le jeu de Puissance 4.