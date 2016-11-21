package ss.project;

import ss.project.Board;
import ss.project.Tile;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Player class for qwirkle

public abstract class Player {

    // -- Instance variables -----------------------------------------

    private String name;
    private int points;
    protected Set<Tile> hand = new HashSet<Tile>();

    // -- Constructors -----------------------------------------------

    /*@
       requires name != null;
       requires Tiles == Tiles.XX || Tiles== Tiles.OO;
       ensures this.getName() == name;
       ensures this.getDeck() == Tiles;
     */
    
    // create new player object
    
    public Player(String name, Set<Tile> hand) {
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    // -- Queries ----------------------------------------------------

    // return player name
    
    /*@ pure */ 
    public String getName() {
        return name;
    }

    // return tiles of player
    
    /*@ pure */ 
    public Set<Tile> getHand() {
        return hand;
    }
    
    
    // return points of player
    public int getPoints() {
		return points;
	}
    
    // add points to player
    public void addPoints(int p) {
		points += p;
	}
	
    // set point of player
	public void setPoints(int p) {
		points = p;
	}
	 
    public abstract Map<Point, Tile> determineMove(Board board);
    
    public abstract Set<Tile> determineExchange();
	
    public void makeMove(Board board) {
    	Map<Point, Tile> map = determineMove(board);
        board.setField(map);
        addPoints(board.getScore(map));
        map.clear();
    }

    public void getHint(Board board) {
    	String name;
    	Map<Point, Tile> move = getValidMoves(board);
    	List<Point> points = new ArrayList<Point>(move.keySet());
    	name = points.get(0).toString() + " " + move.get(0).toString();
		System.out.println(name);
    }
	
	public Map<Point, Tile> getValidMoves(Board board) {
		Map<Point, Tile> moves = new HashMap<Point, Tile>();
		for (Point point : board.getEmptyPoints()) {
			for (Tile tile : getHand()) {
				Map<Point, Tile> move = new HashMap<Point, Tile>();
				move.put(point, tile);
				if (board.validMove(move) == true) {
					moves.put(point, tile);
				}
				move.clear();
			}
		}
		return moves;
	}
	
	public boolean deckEmpty() {
		if (hand.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}