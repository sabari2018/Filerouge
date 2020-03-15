package games;

import players.GamePlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Une classe qui represente le jeu de Puissance 4
 * @author groupe cc 26
 */
public class Power4Game extends AbstractGame {

    private GamePlayer[][] grid;

    /**
     * Initialise une instance du jeu de Puissance4
     * @param firstPlayer  Le premier joueur
     * @param secondPlayer Le second joueur
     * @author groupe cc 26
     */
    public Power4Game(GamePlayer firstPlayer, GamePlayer secondPlayer) {
        super(firstPlayer, secondPlayer);
        this.grid = new GamePlayer[6][7];
    }


    @Override
    public boolean isOver() {

        return isFull() || getWinner() !=null;
    }

    @Override
    public void playWithoutChangePlayer(int coup) {

        coup -=1;

        for (int i = 5 ; i >= 0; i--){
            if (grid[i][coup] == null){
                this.grid[i][coup] = this.getCurrentPlayer();
                return;
            }
        }

    }

    @Override
    public String situationToString() {
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("| "+"1"+ " | " +"2"+ " | "+"3"+ " | "+"4"+ " | "+"5"+ " | "+"6"+ " | "+"7"+ " | ");
        System.out.println("-----------------------------");
        //System.out.println("| "+"1"+ " | ");
        for (int i = 0; i < 6; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {

                if(this.grid[i][j] == null){
                    System.out.print(" " +" | ");

                }
                else{
                    System.out.print(this.grid[i][j].getIcon() + " | ");
                }


            }
            System.out.println();
            System.out.println("-----------------------------");

        }
        return "" + this.grid.length;
    }

    @Override
    public List<Integer> validMoves() {

        boolean b = false;
        List<Integer> coup = new ArrayList<Integer>();

        for(int j = 0; j< 7; j++){

            if (isColEmpty(j)){
                coup.add(j+1);
            }

        }

        System.out.println(coup);
        return coup;
    }

    /**
     * Une methode interne qui verifie si une colonne n'est pas remplie
     * @param col La colonne
     * @return True si la colonne n'est pas remplie et False si nom
     * @author groupe cc 26
     */
    private boolean isColEmpty(int col){
        for (int i=0; i<6; i++){
            if (this.grid[i][col] == null){
                return true;
            }
        }
        return false;
    }

    @Override
    public String moveToString(int move) {
        return "";
    }

    @Override
    public GamePlayer getWinner() {
        GamePlayer player;


        // Teste l'alligment sur 4 cases horizontalement
        for (int row = 0; row < 6; row++){
            player = find4Alligment(0, row,1,0);
            if (player != null){
                return player;
            }
        }

        // Teste l'alligment sur 4 cases verticalement
        for (int col = 0; col < 7; col++){
            player = find4Alligment(col,0,0,1);
            if (player != null){
                return player;
            }
        }

        // Test Diagonale depuis la premiere colonne
        for (int col=0; col<7; col++){
            // diagonale ('\')
            player = find4Alligment(col,0,1,1);
            if (player != null){
                return player;
            }

            //diagonale ('/')
            player = find4Alligment(col,5,1,-1);
            if (player != null){
                return player;
            }


        }

        //Diagonale depuis la colonne gauche
         for (int row=0; row<6; row++){
            //('\') Ok
            player = find4Alligment(0, row,1,1);
            if (player != null){
                return player;
            }


        }
            // diagonale ('/')
         for (int row=5; row>=0;row--){
             player = find4Alligment(0,row,1,-1);
             if (player != null){
                 return player;
             }
         }


        return null;
    }

    @Override
    public boolean isValid(int move) {

       // move -=1;
        return validMoves().contains(move);
    }

    @Override
    public AbstractGame getCopy() {
        Power4Game copy = new Power4Game(this.firstPlayer, this.secondPlayer);
        for(int i = 0; i< 6; i++){
            for(int j = 0; j< 7; j++){

                copy.grid[i][j] = this.grid[i][j];
            }
        }
        copy.currentPlayer = this.currentPlayer;

        return copy;
    }


    /**
     * @author groupe cc 26
     * Une methode qui recherche quatre allignements
     * @param col Colonne de depart
     * @param row Ligne de depart
     * @param dCol Pas d'avancement sur la colonne
     * @param dRow Pas d'avancement sur la ligne
     * @return Retourne le joueur qui occupe quatre cases alignees ou Null s'il y a pas quatre alignements.
     */
    private GamePlayer find4Alligment(int col, int row, int dCol, int dRow){
        GamePlayer player = this.grid[row][col];
        int counter = 0;

        while ((col >= 0) && (col < 7) && (row >=0) && (row < 6)){

            if (this.grid[row][col] != player){
                player = this.grid[row][col];
                counter =1;
            }
            else {
                counter++;
            }

            if (player != null && counter == 4){
                return player;
            }

            col += dCol;
            row += dRow;
        }

        return null;
    }


    /**
     * Une methode qui verifie que la grille est pleine
     * @return Retourne True si la grille est remplie ou False si elle n'est pas remplie
     * @author groupe cc 26
     */
    private boolean isFull(){

        return  this.grid[0][0] != null &&
                this.grid[0][1] != null &&
                this.grid[0][3] != null &&
                this.grid[0][4] != null &&
                this.grid[0][5] != null &&
                this.grid[0][6] != null &&

                this.grid[1][0] != null &&
                this.grid[1][1] != null &&
                this.grid[1][3] != null &&
                this.grid[1][4] != null &&
                this.grid[1][5] != null &&
                this.grid[1][6] != null &&

                this.grid[2][0] != null &&
                this.grid[2][1] != null &&
                this.grid[2][3] != null &&
                this.grid[2][4] != null &&
                this.grid[2][5] != null &&
                this.grid[2][6] != null &&

                this.grid[3][0] != null &&
                this.grid[3][1] != null &&
                this.grid[3][3] != null &&
                this.grid[3][4] != null &&
                this.grid[3][5] != null &&
                this.grid[3][6] != null &&

                this.grid[4][0] != null &&
                this.grid[4][1] != null &&
                this.grid[4][3] != null &&
                this.grid[4][4] != null &&
                this.grid[4][5] != null &&
                this.grid[4][6] != null &&

                this.grid[5][0] != null &&
                this.grid[5][1] != null &&
                this.grid[5][3] != null &&
                this.grid[5][4] != null &&
                this.grid[5][5] != null &&
                this.grid[5][6] != null;

    }

}
