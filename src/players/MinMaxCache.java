package players;

import games.AbstractGame;

import java.util.HashMap;
import java.util.Map;

/**
 * Une classe qui represente un joueur dote d'une intelligence artificielle qui met en cache les positions déjà évaluées.
 */
public class MinMaxCache extends MinMaxPlayer{


    /**
     *  Une variable destiné à stocker les positions déjà évaluées
     */
    private Map<AbstractGame, Integer> map;

    /**
     * Initialise une nouvelle instance de MinMaxCache
     * @param icon Icon du joueur
     */
    public MinMaxCache(String icon) {
        super(icon);
        this.map = new HashMap<AbstractGame, Integer>();
    }


    @Override
    protected int evaluate(AbstractGame game, GamePlayer player) {

        if (map.containsKey(game)){
            return map.get(game);
        }
        int move =super.evaluate(game, player);
        map.put(game, move);
        return move;
    }

    /**
     * Methode qui renvoie le nom du joueur
     * @return Le nom du joueur
     */
    public String toString(){

        return "cache$" + this.hashCode();
    }

    @Override
    public String getIcon() {
        return super.getIcon();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
