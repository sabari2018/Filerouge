package games;

import players.GamePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Une classe qui represente le jeu de Tictactoe
 * @author SADOU BARRY
 */
public class TicTacToe extends AbstractGame {

    /**
     * La grille qui represente les cases du jeu Tictactoe
     * @author SADOU BARRY
     */
    private GamePlayer[][] grid;

    /**
     * @param firstPlayer  Le premier joueur
     * @param secondPlayer Le second joueur
     * @author SADOU BARRY
     */
    public TicTacToe(GamePlayer firstPlayer, GamePlayer secondPlayer) {
        super(firstPlayer, secondPlayer);
        this.grid = new GamePlayer[3][3];
    }

    @Override
    public boolean isOver() {
        return
                (
                        this.grid[0][0] != null &&
                                this.grid[0][1] != null &&
                                this.grid[0][2] != null &&
                                this.grid[1][0] != null &&
                                this.grid[1][1] != null &&
                                this.grid[1][2] != null &&
                                this.grid[2][0] != null &&
                                this.grid[2][1] != null &&
                                this.grid[2][2] != null ||

                                getWinner() != null
                );
    }

    @Override
    public void playWithoutChangePlayer(int coup) {

        coup -=1;
        int i = coup / 3;
        int j = coup % 3;
        this.grid[i][j] = this.getCurrentPlayer();
    }

    @Override
    public String situationToString() {
        System.out.println("");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {

             //On test si la case n'est pas occupee, on affiche un espace et si non on affiche le nom du joueur
                if(this.grid[i][j] == null){
                    System.out.print(" " + " | ");

                }
                else{
                    System.out.print(this.grid[i][j].getIcon() + " | ");
                }


            }
            System.out.println();
            System.out.println("-------------");

        }
        return "";
    }

    @Override
    public List<Integer> validMoves() {
        List<Integer> coup = new ArrayList<Integer>();

        for(int i = 0; i< 3; i++){
            for(int j=0; j< 3; j++){

                if(this.grid[i][j] == null){
                    coup.add(3*i + j + 1);
                }
            }
        }
        return coup;
    }

    @Override
    public String moveToString(int move) {

        /*System.out.println("Les mouve");
        System.out.println(move);*/
        move -=1;
        int i = move/3;
        int j = move % 3;
        System.out.println(move+1+" -> "+"(" + i + "," + j +")");
        return "";
    }

    @Override
    public GamePlayer getWinner() {
        GamePlayer p = null;
        if(testLine() != null){ p = testLine();}
        else if (testCol() != null){ p = testCol();}
        else if (testDiagonale1() != null){ p = testDiagonale1();}
        else if (testDiagonale2() != null){ p = testDiagonale2();}

        return p;
    }

    @Override
    public boolean isValid(int move) {
        return validMoves().contains(move);
    }

    @Override
    public AbstractGame getCopy() {
        TicTacToe copy = new TicTacToe(super.firstPlayer, super.secondPlayer);
        for(int i = 0; i< 3; i++){
            for(int j = 0; j< 3; j++){

                copy.grid[i][j] = this.grid[i][j];
            }
        }

        copy.currentPlayer = this.currentPlayer;

        return copy;
    }

    /**
     * Une methode concrete specifique a la classe Tictactoe qui Test la presence d'un joueur sur une ligne
     * @return Retourne Le GamePlayer qui est present sur toute les cases d'une ligne ou Null dans le cas contraire
     * @author SADOU BARRY
     */
    private GamePlayer testLine(){
        GamePlayer p = null;

        if (
                (this.grid[0][0] != null && this.grid[0][1]!= null && this.grid[0][2]!= null)
                        &&
                        (this.grid[0][0] == this.grid[0][1] && this.grid[0][1] == this.grid[0][2])

        ){ p = this.grid[0][0];}

        else if
        (
                (this.grid[1][0] != null && this.grid[1][1]!= null && this.grid[1][2]!= null)
                        &&
                        (this.grid[1][0] == this.grid[1][1] && this.grid[1][1] == this.grid[1][2])
        ){ return p = this.grid[1][0]; }

        else if
        (
                (this.grid[2][0] != null && this.grid[2][1]!= null && this.grid[2][2]!= null)
                        &&
                        (this.grid[2][0] == this.grid[2][1] && this.grid[2][1] == this.grid[2][2])

        ){ p = this.grid[2][0];}

        return p;

    }

    /**
     * Une methode concrete specifique a la classe Tictactoe qui Test la presence d'un joueur sur une colonne
     * @return Retourne Le GamePlayer qui est present sur toute les cases d'une colonne ou Null dans le cas contraire
     * @author SADOU BARRY
     */
    private GamePlayer testCol(){

        GamePlayer p = null;

        if (
                (this.grid[0][0] != null && this.grid[1][0]!= null && this.grid[2][0]!= null)
                        &&
                        (this.grid[0][0] == this.grid[1][0] && this.grid[1][0] == this.grid[2][0])
        ){ p = this.grid[0][0];}

        else if
        (
                (this.grid[0][1] != null && this.grid[1][1]!= null && this.grid[2][1]!= null)
                        &&
                        (this.grid[0][1] == this.grid[1][1] && this.grid[1][1] == this.grid[2][1])
        ){ p = this.grid[0][1]; }

        else if
        (
                (this.grid[0][2] != null && this.grid[1][2]!= null && this.grid[2][2]!= null)
                        &&
                        (this.grid[0][2] == this.grid[1][2] && this.grid[1][2] == this.grid[2][2])

        ){ p =  this.grid[0][2]; }

        return p;

    }

    /**
     * Une methode concrete specifique a la classe Tictactoe qui Test la presence d'un joueur sur la premiere diagonale
     * @return Retourne Le GamePlayer qui est present sur toute les cases de la seconde diagonale ou Null dans le cas contraire
     * @author SADOU BARRY
     */
    private GamePlayer testDiagonale1(){

        if( (this.grid[0][0] != null && this.grid[1][1]!= null && this.grid[2][2]!= null)
                &&
                (this.grid[0][0] == this.grid[1][1] && this.grid[1][1] == this.grid[2][2])
        ){
            return this.grid[0][0];
        }
        else
            return null;
    }

    /**
     * Une methode concrete specifique a la classe Tictactoe qui Test la presence d'un joueur sur la premiere diagonale
     *@return Retourne Le GamePlayer qui est present sur toute les cases de la seconde diagonale ou Null dans le cas contraire
     */
    private GamePlayer testDiagonale2(){

        if(
                (this.grid[2][0] != null && this.grid[1][1]!= null && this.grid[0][2]!= null)

                        &&

                        (this.grid[2][0] == this.grid[1][1] && this.grid[1][1] == this.grid[0][2])
        ){
            return this.grid[2][0];
        }
        else
            return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Nim)){
            return false;
        }
        else {
            TicTacToe other = (TicTacToe)obj;
            return this.currentPlayer.equals(other.currentPlayer) &&
                    this.grid[0][0] == other.grid[0][0] &&
                    this.grid[0][1] == other.grid[0][1] &&
                    this.grid[0][2] == other.grid[0][2] &&
                    this.grid[1][0] == other.grid[1][0] &&
                    this.grid[1][1] == other.grid[1][1] &&
                    this.grid[1][2] == other.grid[1][2] &&
                    this.grid[2][0] == other.grid[2][0] &&
                    this.grid[2][1] == other.grid[2][1] &&
                    this.grid[2][2] == other.grid[2][2];
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.currentPlayer, Arrays.hashCode(this.grid));
    }
}
