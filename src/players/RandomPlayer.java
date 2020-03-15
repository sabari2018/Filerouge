package players;

import games.AbstractGame;
import java.util.Random;

/**
 * Une classe qui represente un joueur Aleatoire implementant GamePlayer
 */
public class RandomPlayer implements GamePlayer {

    /**
     * Un objet de type Random, permettant de choisir un coup aleatoirement
     */
    private Random randomGenerator;

    /**
     * Icon du joueur
     */
    private String icon;

    /**
     * Initialise une instance du joueur aleatoire
     * @param icon Icon du joueur
     */
    public RandomPlayer(String icon){
        this.randomGenerator = new Random();
        this.icon = icon;
    }

    @Override
    public int chooseMove(AbstractGame game) {

        int n = game.validMoves().size();
        int index = this.randomGenerator.nextInt(n);

        return game.validMoves().get(index);
    }

    /**
     * Methode permettant d'afficher le nom du joueur aleatoire
     * @return Le nom du joueur aleatoire
     */
    public String toString(){

        return "random#" + this.hashCode();
    }

    @Override
    public String getName() {
        return this.icon;
    }
    public String getIcon(){
        return this.icon;
    }
}
