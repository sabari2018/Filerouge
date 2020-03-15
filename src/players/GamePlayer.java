package players;

import games.AbstractGame;

/**
 * Une interface qui factorise tout les types de joueurs Humain, Aleatoire, MinMax...
 * @author groupe cc 26
 */
public interface GamePlayer {

    /**
     * Une methode permettant a tout type de joueurs de choisir un coup
     * @param game Le jeu dans lequel le joueur choisi son coup
     * @return Le coup choisi
     * @author groupe cc 26
     */
    public int chooseMove(AbstractGame game);

    /**
     * Une methode qui permet de retourner le nom du joueur
     * @return Le nom du joueur
     * @author groupe cc 26
     */
    public String getName();

    /**
     * Une methode qui retourne l'icon du joueur
     * @return L'icon du joueur
     * @author groupe cc 26
     */
    public String getIcon();
}
