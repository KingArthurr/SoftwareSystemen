package ss.project;

import java.awt.Point;
import java.util.Map;
import java.util.Set;

public class ComputerPlayer extends Player {
	
	private Strategy strategy;
	
	public ComputerPlayer(Set<Tile> hand, Strategy strategy) {
		super(strategy.getName(), hand);
		this.strategy = strategy;
	}
	
	public Map<Point, Tile> determineMove(Board board) {
		return strategy.determineMove(board);
	}
	
	public Set<Tile> determineExchange() {
		return strategy.determineExchange();
	}

}
