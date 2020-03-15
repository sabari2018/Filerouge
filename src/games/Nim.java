package games;

import players.GamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Une classe qui represente le jeu de Nim
 * @author groupe cc 26
 */
public class Nim extends AbstractGame {

    /**
     * Le nombre initial d'allumettes
     * @author groupe cc 26
     */
    private int n;

    /**
     * Le nombre courant d'allumettes
     * @author groupe cc 26
     */
    private int current_n;

    /**
     *  Le nombre maximal d'allumettes qu'un joueur peut retirer
     * @author groupe cc 26
     */
    private int k;

    /**
     * @param firstPlayer  Le premier joueur
     * @param secondPlayer Le second joueur
     * @param n Le nombre initial d'allumettes
     * @param k Le nombre maximal d'allumettes qu'un joueur peut retirer
     * @author groupe cc 26
     */
    public Nim(GamePlayer firstPlayer, GamePlayer secondPlayer, int n, int k) {
        super(firstPlayer, secondPlayer);
        this.n = n;
        this.current_n = n;
        this.k = k;
    }

    /**
     * Une methode concrete retournant le nombre initial d'allumettes
     * @return Le nombre initial d'allumettes
     * @author groupe cc 26
     */
    public int getInitialNbMatches(){
        return this.n;
    }

    /**
     * Une methode concrete retournant le nombre courant d'allumettes
     * @return Le nombre courant d'allumettes
     * @author groupe cc 26
     */
    public int getNbMatches(){
        return this.current_n;
    }

    @Override
    public boolean isOver() {
        return this.current_n == 0;
    }

    @Override
    public void playWithoutChangePlayer(int coup) {
        this.current_n -= (coup);
    }

    @Override
    public String situationToString() {
        return "Il reste " + this.getNbMatches() + " allumettes";
    }

    @Override
    public List<Integer> validMoves() {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i<= Math.min(this.k, this.getNbMatches()); i++){

            list.add(i);
        }

        return list;
    }

    @Override
    public String moveToString(int move) {
        System.out.print(move +" ");
        return "";
    }

    @Override
    public GamePlayer getWinner() {
        return this.getCurrentPlayer();
    }

    @Override
    public boolean isValid(int move) {
        return move > 0 && move <= this.k && move <= this.current_n;
    }

    @Override
    public AbstractGame getCopy() {
        Nim copy = new Nim(this.firstPlayer, this.secondPlayer, this.getInitialNbMatches(), this.getNbMatches());
        copy.current_n = this.current_n;
        copy.currentPlayer = this.currentPlayer;
        return copy;
    }

    @Override
    public boolean equals(Object obj) {

        if ((obj == null) || !(obj instanceof Nim)){
            return false;
        }
         else {
             Nim otherAsNim = (Nim)obj;
             return this.currentPlayer.equals(otherAsNim.currentPlayer) &&
                     this.getNbMatches() == otherAsNim.getNbMatches() &&
                     this.getInitialNbMatches() == otherAsNim.getInitialNbMatches() &&
                     this.k == otherAsNim.k;
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.currentPlayer, this.getNbMatches(), this.getInitialNbMatches(), this.k);
    }
}
