package games;

import players.GamePlayer;

import java.util.List;

/**
 * Une classe abstraite qui fatorise les fonctionalites communes aux jeux
 * @author groupe cc 26
 */
public abstract class AbstractGame {

    /**
     * Le premier joueur 
     * @author groupe cc 26*/
    protected GamePlayer firstPlayer;

    /**
     * Le second joueur 
     * @author groupe cc 26*/
    protected GamePlayer secondPlayer;

    /**
     *  Le joueur courant
     * @author groupe cc 26*/
    public GamePlayer currentPlayer;


    /**
     * Initialise une instance du jeu
     * @param firstPlayer Le premier joueur
     * @param secondPlayer Le second joueur
     * @author groupe cc 26
     */
    public AbstractGame(GamePlayer firstPlayer, GamePlayer secondPlayer){

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = firstPlayer;
    }

    /**
     * Une méthode abstraite permettant de verifier si le jeu est finis
     * @return Retourne True si le jeu est finis ou False si le jeu n'es pas finis
     * @author groupe cc 26
     */
    public abstract boolean isOver();

    /**
     *  Une méthode abstraite permettant d'exécuter un coup (représenté par un entier), sans changer le joueur
     * @param coup Le coup choisi par le joueur courant
     * @author groupe cc 26
     */
    public abstract void playWithoutChangePlayer(int coup);

    /**
     * Une méthode abstraite retournant une représentation de la situation courante comme une chaîne de caractères
     * @return La situation du jeu en chaine de caratere
     * @author groupe cc 26
     */
    public abstract String situationToString();

    /**
     * Une méthode abstraite retournant la liste des coups valides pour le joueur courant
     * @return Liste des coups valides
     * @author groupe cc 26
     */
    public abstract List<Integer> validMoves();

    /**
     * Une méthode abstraite retournant une chaîne de caractères représentant le coup codé par un entier donné
     * @param move L'entier a modifier en chaine de caratere
     * @return Le coup en chaine de caractere
     * @author groupe cc 26
     */
    public abstract String moveToString(int move);

    /**
     * Une méthode abstraite retournant le vainceur. Elle retournera null si la partie n'est pas terminée ou si c'est une partie nulle (grille pleine sans qu'il n'y ait de gagnant)
     * @return Le GamePlayer vainqueur ou null si y a pas de vainqueur
     * @author groupe cc 26
     */
    public abstract GamePlayer getWinner();

    /**
     * Une méthode abstraite verifiant si un coup est valide
     * @param move Le coup choisi par le joueur courant
     * @return True si le coup est valide ou False dans le cas contraire
     * @author groupe cc 26
     */
    public abstract boolean isValid(int move);

    /**
     * Une méthode abstraite permettra de retourner une copie de l'objet sur lequel elle sera appelée, sous la forme d'une nouvelle instance
     * @return Une copie de la situation de jeu
     * @author groupe cc 26
     */
    public abstract AbstractGame getCopy();

    /**
     * Une méthode concrète qui change le joueur courant
     * @author groupe cc 26
     */
    public void changePlayer(){


        if (this.currentPlayer == this.firstPlayer) {

            this.currentPlayer = this.secondPlayer;
        }
        else{
            this.currentPlayer = this.firstPlayer;
        }
    }

    /**
     * Une thode concrète qui retourne le joueur courant
     * @return Le joueur courant
     * @author groupe cc 26
     */
    public GamePlayer getCurrentPlayer(){

        return this.currentPlayer;
    }

    /**
     * Une méthode concrète qui execute un coup
     * @param coup Le coup entrer par le joueur
     * @author groupe cc 26
     */
    public void play(int coup){
        this.playWithoutChangePlayer(coup);
        this.changePlayer();
    }
}
