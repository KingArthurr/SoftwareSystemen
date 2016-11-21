package ss.project;

import java.awt.Point;
import java.util.Map;
import java.util.Set;

import ss.project.Board;

public interface Strategy {
	
	public String getName();
	
	public Map<Point, Tile> determineMove(Board board);
	
	public Set<Tile> determineExchange();
}