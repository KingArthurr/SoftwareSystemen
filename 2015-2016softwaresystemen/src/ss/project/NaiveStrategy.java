package ss.project;

import ss.project.Board;
import ss.project.Tile;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NaiveStrategy implements Strategy {
	
    private String name;
    private Player player;

    public NaiveStrategy() {
        name = "Naive";
    }

    public String getName() {
        return name;
    }
	
    public Map<Point, Tile> determineMove(Board board) {
    	Map<Point, Tile> map = new HashMap<>();
    	Map<Point, Tile> moves = player.getValidMoves(board);
    	List<Point> points = new ArrayList<Point>(moves.keySet());
    	if (moves.size() != 0) {
    		map.put(points.get(0), moves.get(0));
    	}
    	return map;
    }		
		// getValidMoves, makeMove (random) evt meerdere rijen;
    public Set<Tile> determineExchange() {
    	return player.getHand();
    }

}
