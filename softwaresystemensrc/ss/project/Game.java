package ss.project;

import java.util.Scanner;
import java.util.Set;

import ss.project.Board;
import ss.project.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Game {
    

    private Board board;
    private Deck deck;

    private Player[] players;

    private int currentPlayer;
    
    // create new game

    public Game(Player s0, Player s1) {
    	players = new Player[2];
        players[0] = s0;
        players[1] = s1;
        
        if (doubleNames() == true) {
        	System.out.println("Double names");
        	reset();
        } else {     
            board = new Board();
            deck = new Deck();
            currentPlayer = 0;
        } 
    } 
    public Game(Player s0, Player s1, Player s2) {
    	players = new Player[3];
        players[0] = s0;
        players[1] = s1;
        players[2] = s2;
        
        if (doubleNames() == true) {
        	System.out.println("Double names");
        	reset();
        } else {     
            board = new Board();
            deck = new Deck();
            currentPlayer = 0;
        } 
    }
    public Game(Player s0, Player s1, Player s2, Player s3) {
    	players = new Player[4];
        players[0] = s0;
        players[1] = s1;
        players[2] = s2;
        players[3] = s3;
        
        if (doubleNames() == true) {
        	System.out.println("Double names");
        	reset();
        } else {     
            board = new Board();
            deck = new Deck();
            currentPlayer = 0;
        } 
    }
    public Game(Player s0, Player s1, Player s2, Player s3, Player s4) {
    	players = new Player[5];
        players[0] = s0;
        players[1] = s1;
        players[2] = s2;
        players[3] = s3;
        players[4] = s4;
        
        if (doubleNames() == true) {
        	System.out.println("Double names");
        	reset();
        } else {     
            board = new Board();
            deck = new Deck();
            currentPlayer = 0;
        } 
    }
    
    public Game(Player s0, Player s1, Player s2, Player s3, Player s4, Player s5) {
    	players = new Player[6];
        players[0] = s0;
        players[1] = s1;
        players[2] = s2;
        players[3] = s3;
        players[4] = s4;
        players[5] = s5;
        
        if (doubleNames() == true) {
        	System.out.println("Double names");
        	reset();
        } else {     
            board = new Board();
            deck = new Deck();
            currentPlayer = 0;
        } 
    }

    // -- Commands ---------------------------------------------------
    
    // start qwirkle game, option to play again
    public void start() {
        boolean doorgaan = true;
        while (doorgaan) {
            reset();
            play();
            doorgaan = readBoolean("\n> Play another time? (y/n)?", "y", "n");
        }
    }

    /**
     * @parom prompt the question to print
     * @param yes
     *            the String corresponding to a yes answer
     * @param no
     *            the String corresponding to a no answer
     * @return true is the yes answer is typed, false if the no answer is typed
     */

    // read answer to question
    private boolean readBoolean(String prompt, String yes, String no) {
        String answer;
        do {
            System.out.print(prompt);
            Scanner in = new Scanner(System.in); 
                answer = in.hasNextLine() ? in.nextLine() : null;
            in.close();
        } while (answer == null || (!answer.equals(yes) && !answer.equals(no)));
        return answer.equals(yes);
    }

    // reset the game, changes the player and empties the board
    private void reset() {
        currentPlayer = 0;
        board.reset();
        deck.reset();
    }

    // play the qwirkle game, after each move the game situation is changed
    private void play() {  
    	String prompt = "Do you want to place tiles or exchange them? (place/exchange)";
    	while(!gameOver()){
       		update();
       			if (getCurrentPlayer().getName() != "Naive") {
           			System.out.println(getCurrentPlayer().getName() + ": " + getCurrentPlayer().getHand());
       			}
       		switch (readString(prompt)) {
       		case "exchange":
       			deck.changeTile(getCurrentPlayer().determineExchange());
       			break;
       		case "place":
       			board.setField(getCurrentPlayer().determineMove(board));
       			break;
       		default:
       			System.out.println("Please enter: place or exchange !");
       		}
       		next();
        }
        update();
        getLastPlayer().addPoints(6);
        printResult();
        System.out.println("\n");
        start();
    }
    
    public Player[] getPlayers() {
    	return players;
    }
    // next player
    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % (players.length);
    }
    
    // get the current player
    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }
    
    public Player getLastPlayer() {
    	return players[currentPlayer--];
    }

    // prints the game situation
    private void update() {
    	//TODO VIEW
    }

    private void next() {
    	fillHands();
    	nextPlayer();
    }
    
    public void fillHands() {
    	for (int i = 0; i < players.length; i++) {
    		while (players[i].getHand().size() != 6) {
    			players[i].getHand().add(deck.drawTile());
    		}
    	}
    }
    /*@
       requires this.board.gameOver();
     */
    
    // prints result of the last game
    public void printResult() {
    	Map<Player, Integer> results = new HashMap<Player, Integer>();
    	for (int i = 0; i < players.length; i++){
    		results.put(players[i], players[i].getPoints());
    	}
    	System.out.println(results);
    }
    
    //bepaald wie de eerste beurt krijgt
    // get deck   compare deck  wie meeste punten heeft anders random
    public int firstPlayer() {
		return currentPlayer;
    	
    }
    
    //TODO
    public boolean gameOver() {
        boolean gameover = false;
        Set<Tile> total = new HashSet<Tile>(getCurrentPlayer().getHand());
        for (int i = 0; i < deck.getDeck().size(); i++){
            total.add(deck.getDeck().get(i));
        }
        Player player1 = new ComputerPlayer(total, new NaiveStrategy());
        
    	if (players[currentPlayer--].deckEmpty() && (deck.Tilesremaining() == 0)) {
            gameover = true;
        }
        if (player1.getValidMoves(board) == null) {
            gameover = true;
        }
        return gameover;
    }
	
	
	private boolean doubleNames() {
		int i = 0;
		int j = 1;
		while (!(i == players.length)) {
			while (!(j == players.length)) {
				if (players[i].equals(players[j])) {
					return true;
				} else {
					j++;
				}
			}
			i++;
		}
		return false;
	}
	
    private String readString(String prompt) {
    	String string = "";
        boolean stringRead = false;
        @SuppressWarnings("resource")
        Scanner line = new Scanner(System.in);
        do {
            System.out.print(prompt);
            try (Scanner scannerLine = new Scanner(line.nextLine());) {
                if (scannerLine.hasNext()) {
                    stringRead = true;
                    string = scannerLine.next().toString();
                }
            }
        } while (!stringRead);
        return string;
    }
}
