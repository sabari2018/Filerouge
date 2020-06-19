package players;

import games.AbstractGame;

/**
 * Une interface qui factorise tout les types de joueurs Humain, Aleatoire, MinMax...
 * @author SADOU BARRY
 */
public interface GamePlayer {

    /**
     * Une methode permettant a tout type de joueurs de choisir un coup
     * @param game Le jeu dans lequel le joueur choisi son coup
     * @return Le coup choisi
     * @author SADOU BARRY
     */
    public int chooseMove(AbstractGame game);

    /**
     * Une methode qui permet de retourner le nom du joueur
     * @return Le nom du joueur
     * @author SADOU BARRY
     */
    public String getName();

    /**
     * Une methode qui retourne l'icon du joueur
     * @return L'icon du joueur
     * @author SADOU BARRY
     */
    public String getIcon();
}
