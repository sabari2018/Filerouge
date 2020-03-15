package orchestration;

import games.AbstractGame;
import games.Nim;
import games.Power4Game;
import games.TicTacToe;
import players.*;

import java.util.Scanner;

/**
 * Une classe executable pour demontrer l'utilisation des differentes classes de l'application et lancer une partie de jeu
 * @author groupe cc 26
 */
public class Test {

    /**
     * Methode qui permet d'executer l'application
     * @param arguments Parametres pour lancer une partie
     * @author groupe cc 26
     */
    public static void main(String[] arguments){

        Orchestrator orchestrator = new Orchestrator();
        AbstractGame game;

        if (!validArgs(arguments)) {
            System.out.println("Arguements invalides");

        }
        else {

            if (arguments[0].equalsIgnoreCase("nim")){

                try {
                    game = nimGame(arguments);
                    orchestrator.playGame(game);
                }catch (IllegalArgumentException e){
                    System.err.println("Veillez entrer les bons parametres du jeu. Merci!!!");
                }

            }
            else if(arguments[0].equalsIgnoreCase("tictactoe")){

                try {

                    game = ticTacToeGame(arguments);
                    orchestrator.playGame(game);

                }catch (IllegalArgumentException e){
                    System.err.println("Veillez entrer les bons parametres du jeu. Merci!!!");
                }
            }
            else if (arguments[0].equalsIgnoreCase("power4game")){
               game = powerFoGame(arguments);
                orchestrator.playGame(game);
          }


        }
    }


    /**
     * Metode interne a la classe Test, permettant de verifier que les arguments passes sont bien valides
     * @param arg Arguments fournis par l'utilisateur
     * @return Retourne True si le test est bon, False si nom
     * @author groupe cc 26
     */
    private static boolean validArgs(String[] arg){

        return (parmObligatoire(arg) && testHumanName(arg));
    }

    /**
     * Metode interne a la classe Test, verifiant que les parametres obligatoires (Type du jeu, Type du premier joueur, Type du second joueur) ont etes fournis
     * @param arg Arguments saisis par l'utilisateur
     * @return Retourne True si le Test est bon, False si non
     * @author groupe cc 26
     * 
     */
    private static boolean parmObligatoire(String[] arg){
        if (arg.length < 3){
            return false;
        }
        else {

            return   (arg[0].equalsIgnoreCase("nim") || arg[0].equalsIgnoreCase("tictactoe") || arg[0].equalsIgnoreCase("power4game")) &&
                    (arg[1].equalsIgnoreCase("random") || arg[1].equalsIgnoreCase("humain") || arg[1].equalsIgnoreCase("minmax") || arg[1].equalsIgnoreCase("mincache")) &&
                    (arg[2].equalsIgnoreCase("random") || arg[2].equalsIgnoreCase("humain") || arg[2].equalsIgnoreCase("minmax") || arg[2].equalsIgnoreCase("mincache"));
        }
    }

    /**
     * Une methode interne a la classe Test, qui verifie que s'il y'a un ou deux jours humain, leur nom a ete fournis
     * @param arg Parametre du jeu saisis par l'utilisateur
     * @return Retourne True si le Test est bon, False si non
     * @author groupe cc 26
     */
    private static boolean testHumanName(String[] arg){
        boolean b = true;
        if ((arg[1].equalsIgnoreCase("humain") && arg[2].equalsIgnoreCase("humain"))){

            b = (arg.length == 5 && !arg[3].equalsIgnoreCase(arg[4]));
        }
        else if (arg[1].equalsIgnoreCase("humain") && !arg[2].equalsIgnoreCase("humain")){
            b = (arg.length == 4);
        }

        else if (!(arg[1].equalsIgnoreCase("humain")) && arg[2].equalsIgnoreCase("humain")){
            b = (arg.length == 4);
        }

        else if (!arg[1].equalsIgnoreCase("humain") && !arg[2].equalsIgnoreCase("humain")){
            b = (arg.length == 3);
        }

        return b;
    }

    /**
     * Methode interne a la classe Test qui permet de creer une instance du jeu de Nim
     * @param args Parametres du jeu fournis par l'utilisateur
     * @return Retourne une instance de Nim
     * @author groupe cc 26
     */
    private static Nim nimGame(String[] args){

        GamePlayer player1, player2;
        int n = 0, k = 0;
        boolean continueIfException = false;
        System.out.println(" JEU DE NIM ");


        System.out.println(" Entrer le nombre d'allumettes: ");

        do {
            Scanner scanner = new Scanner(System.in);
            continueIfException = false;
            try {
                n = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Le nombre d'allumettes doit etre un entier");
                continueIfException = true;
            }
        }while (continueIfException);

        System.out.println(" Entrer le nombre maximal qu'un joueur peut prendre : ");

        do {
            Scanner scanner = new Scanner(System.in);
                    continueIfException = false;

                    try {
                        k = scanner.nextInt();
                        if (k >= n){
                            System.err.println("Ce nombre ne doit etre inferieur au nombre d'allumettes");
                            continueIfException = true;
                        }
                    } catch (Exception e) {
                        System.err.println("Le nombre maximal d'allumettes doit etre un entier");
                        continueIfException = true;
                    }
                }while (continueIfException);

        player1 = setFirstPlayer(args);
        player2 = setSecondPlayer(args);

        return new Nim(player1, player2, n, k);
    }

    /**
     * Methode interne a la classe Test qui permet de creer une instance du jeu de Tictactoe
     * @param args Parametres du jeu fournis par l'utilisateur
     * @return Retourne une instance de Tictactoe
     * @author groupe cc 26
     */
    private static TicTacToe ticTacToeGame(String[] args){

        GamePlayer player1, player2;

        System.out.println("********** JEU DE TICTACTAOE **********");

        player1 = setFirstPlayer(args);
        player2 = setSecondPlayer(args);

        return  new TicTacToe(player1, player2);
    }

    private static Power4Game powerFoGame(String[] args){

        GamePlayer player1, player2;

        System.out.println("********** JEU DE PUISSANCE 4 **********");

        player1 = setFirstPlayer(args);
        player2 = setSecondPlayer(args);

        return  new Power4Game(player1, player2);
    }

    /**
     * Methode de la classe Test qui permet parametrer le premier joueur selon qu'il soit Humain, Joueur aleatoire ou Joueur IA
     * @param arg Parametres fournis par l'utilisateur
     * @return Une instance de Human ou RandomPlayer ou MinMaxPlayer ou null (s'il y'a aucun des types de joueur precedent)
     * @author groupe cc 26
     */
    private static GamePlayer setFirstPlayer(String[] arg){
        if (arg[1].equalsIgnoreCase("humain")){
            return new Human(arg[3],"X");
        }

        else if(arg[1].equalsIgnoreCase("random")){
            return new RandomPlayer("X");
        }
        else if(arg[1].equalsIgnoreCase("minmax")){
            return new MinMaxPlayer("X");
        }
        else if(arg[1].equalsIgnoreCase("mincache")){
            return new MinMaxCache("X");
        }

        return null;
    }

    /**
     * Methode de la classe Test qui permet parametrer le second joueur selon qu'il soit Humain, Joueur aleatoire ou Joueur IA
     * @param arg Parametres fournis par l'utilisateur
     * @return Une instance de Human ou RandomPlayer ou MinMaxPlayer ou null (s'il y'a aucun des types de joueur precedent)
     * @author groupe cc 26
     */
    private static GamePlayer setSecondPlayer(String[] arg){
        if (arg[2].equalsIgnoreCase("humain")){
            if (arg[1].equalsIgnoreCase("humain")){
                return  new Human(arg[4],"O");
            }
            return new Human(arg[3],"O");
        }

        else if(arg[2].equalsIgnoreCase("random")){
            return new RandomPlayer("O");
        }
        else if(arg[2].equalsIgnoreCase("minmax")){
            return new MinMaxPlayer("O");
        }
        else if(arg[2].equalsIgnoreCase("mincache")){
            return new MinMaxCache("O");
        }

        return null;
    }
}
