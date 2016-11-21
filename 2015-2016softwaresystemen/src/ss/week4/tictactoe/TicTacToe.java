package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        Player Reinier = new HumanPlayer("Reinier", Mark.OO);
        Player Maarten = new HumanPlayer("Maarten", Mark.XX);
    	Game tictac = new Game(Reinier , Maarten);
    	tictac.start();
    }
}