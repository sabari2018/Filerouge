package players;

import games.AbstractGame;


/**
 * Une classe qui represente un joueur dote d'une intelligence artificielle
 */
public class MinMaxPlayer implements GamePlayer{

    /**
     * Icon du joueur
     */
    private String icon;

    /**
     * Initialise une nouvelle instance de MinMaxPlayer
     * @param icon Icon du joueur
     */
    public MinMaxPlayer(String icon) {
        this.icon = icon;
    }

    @Override
    public int chooseMove(AbstractGame game) {
        return negamax(game, game.currentPlayer);
    }

    @Override
    public String getName() {
        return this.icon;
    }

    /**
     * Methode qui renvoie le nom du joueur
     * @return Le nom du joueur
     */
    public String toString(){

        return "MinMax@" + this.hashCode();
    }

    /**
     * Methode qui permet d'evaluer une situation de jeu
     * @param game La situation courante du jeu
     * @param player Le joueur courant
     * @return Returne le resualtat de l'evaluation en entier
     */
    protected int evaluate(AbstractGame game, GamePlayer player){

            int v;
            if(game.isOver() && player == game.getWinner()){

                return +1;
            }

            else if(game.isOver() && game.getWinner() == null){

                return 0;
            }

            else if(game.isOver() && player != game.getWinner()){

                return -1;
            }

            else{

                float res = Float.NEGATIVE_INFINITY;
                for (int coup : game.validMoves()) {
                    game = game.getCopy();
                    game.play(coup);
                    player = game.getCurrentPlayer();
                    v = -evaluate(game, player);
                    res = Math.max(res, v);
                }

                return Math.round(res);
            }

    }

    /**
     * Methode qui permet de choisir un meilleur coup dans une situation de jeu
     * @param game La situation courante du jeu
     * @param player Le joueur courant
     * @return Le coup en entier
     */
    private int negamax(AbstractGame game, GamePlayer player){

        float meilleureValeur = Float.NEGATIVE_INFINITY;
        int meilleureCoup = 0;
        int v =0;

        for (int coup : game.validMoves()) {

            game = game.getCopy();
            game.play(coup);
            player = game.getCurrentPlayer();
            v = -evaluate(game, player);
            if(v > meilleureValeur){
                meilleureValeur = (float)v;
                meilleureCoup = coup;
            }
        }
        return meilleureCoup;
    }

    public String getIcon(){
        return this.icon;
    }
}
