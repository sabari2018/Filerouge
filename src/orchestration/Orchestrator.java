package orchestration;

import games.AbstractGame;
import players.GamePlayer;


/**
 * Une classe permettant de realiser une seul boucle de jeu pour tout les type de jeu
 */
public class Orchestrator {

    /**
     * Methode qui permet de faire jouer une partie quel que soit le jeu
     * @param game Le jeu
     */
    public void playGame(AbstractGame game){

        GamePlayer player;

        System.out.println(game.situationToString());
        while(!game.isOver()){

            player = game.getCurrentPlayer();

            System.out.println("A " + player +" ("+player.getIcon()+") de jouer");

            int coup = player.chooseMove(game);

            game.play(coup);

            System.out.println(game.situationToString());
        }

        System.out.println();
        System.out.println("***********************");
        System.out.println("|                     |");
        System.out.println("*****FIN DE PARTIE*****");
        System.out.println("|                     |");

        if(game.getWinner() != null){

            System.out.println("*******VITOIRE DE******");
            System.out.println("|                     |");
            System.out.println("  "+  game.getWinner() );
            System.out.println("|                     |");
            System.out.println("***********************");
            System.out.println("Feliciation " + game.getWinner());

        }
        else{
            System.out.println("*******EGALITE*********");
            System.out.println("|                     |");
            System.out.println("***********************");
            System.out.println("Desole !!! le match est fini mais personne n'a gagne @");
        }
    }
}
