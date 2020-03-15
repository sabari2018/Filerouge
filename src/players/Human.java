package players;

import games.AbstractGame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Une classe qui represente un joueur Humain implementant GamePlayer
 */
public class Human implements GamePlayer{

    /**
     * Le nom du joueur
     */
    private String name;
    private String icon;

    /**
     * Initialise une instance d'un joueur Humain
     * @param name Nom du joueur
     */
    public Human(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    @Override
    public int chooseMove(AbstractGame game) {

        int move = 0;

        //Ce booleen permet de controler si le coup saisie est autre q'un entier
        boolean continueIfException = false;

        System.out.print("Vos coups valides => ");
        for (Integer coup : game.validMoves()) {
            System.out.print(game.moveToString(coup));
        }

            do{
                System.out.println("");
                System.out.println("Entrer votre coup :  ");


                    Scanner scanner = new Scanner(System.in);
                    continueIfException = false;

                    try {
                        move = scanner.nextInt();
                    }catch (InputMismatchException e){
                        System.err.println("Le coup doit etre un entier");
                        continueIfException = true;
                    }


            }while(continueIfException || !game.isValid(move));


        return move;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Methode qui renvoie le nom du joueur
     * @return Le nom du joueur
     */
    public String toString(){
        return getName();
    }

    public String getIcon(){
        return this.icon;
    }
}
