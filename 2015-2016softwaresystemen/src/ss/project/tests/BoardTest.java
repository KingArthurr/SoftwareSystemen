package ss.project.tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ss.project.Board;
import ss.project.Tile;
import ss.project.Tile.Color;
import ss.project.Tile.Shape;

@SuppressWarnings("unused")
public class BoardTest {
	
	Point pt1, pt2, pt3, pt4;
	Tile t1, t2, t3;
	private Board board;
    ArrayList<Tile> tiles;
    Map<Point, Tile> moves;
    Map<Point, Tile> move1;
    Map<Point, Tile> move2;
    Map<Point, Tile> move3;

	@Before
	public void setUp() throws Exception {
		board = new Board();
		
		t1 = new Tile(Shape.CIRCLE, Color.BLUE);
		t2 = new Tile(Shape.CLUB, Color.BLUE);
		t3 = new Tile(Shape.SQUARE, Color.GREEN);
		pt1 = new Point(0, 0);
		pt2 = new Point(1, 0);
		pt3 = new Point(2, 0);
		pt4 = new Point(0, 4);
		
		move1 = new HashMap<Point, Tile>();
        move1.put(pt1, t1);
        move2 = new HashMap<Point, Tile>();
		move2.put(pt1, t1);
		move2.put(pt2, t2);
        move3 = new HashMap<Point, Tile>();
		move3.put(pt1, t1);
		move3.put(pt2, t2);
		move3.put(pt4, t3);
		
		tiles = new ArrayList<Tile>();
        tiles.add(new Tile(Shape.CIRCLE, Color.BLUE));
        tiles.add(new Tile(Shape.DIAMOND, Color.GREEN));
        tiles.add(new Tile(Shape.CLUB, Color.YELLOW));
        tiles.add(new Tile(Shape.STAR, Color.PURPLE));
		
        moves = new HashMap<Point, Tile>();
        moves.put(pt1, t1);
        moves.put(pt2, t2);
        moves.put(pt3, t3);
        //board.setField(moves);
	}
	
	@Test
	public void validMoveTest(){
        board.reset();
		//assertTrue(board.validMove(move1));
		//assertTrue(board.validMove(move2));
		assertFalse(board.validMove(move3));
	}
}
	
	/*@Test
	public void hasAdjacentTest(){
		Point point6 = new Point(0, 6);
		assertTrue(board.hasAdjacent(pt1));
		assertFalse(board.hasAdjacent(point6));
	}
	
	@Test
	public void isSameShapeorColorTest(){
		assertTrue(t1 == t2);
		assertFalse(t1 == t2);
	}
	
	@Test
	public void fitsRoworColorTest(){
		fail("Not yet implemented");
	}
	
	@Test
	public void getAdjacentTest() {
		List<Integer> adjacent = new ArrayList<Integer>(board.getAdjacent(pt1));
		assertTrue(adjacent.get(0) == 2);
		assertFalse(adjacent.get(0) == 3);
		assertFalse(adjacent.get(0) == 4);
		assertFalse(adjacent.get(0) == 1);
	}
	
	@Test
	public void makeRoworColom() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getEmptyPointsTest(){
		assertFalse(board.getEmptyPoints().contains(pt1));
		Point point4 = new Point(0, 4);
		assertTrue(board.getEmptyPoints().contains(point4));
	}
	
	@Test
	public void setFieldTest(){
		board.setField(moves);
		Point point1 = new Point(0, 0);
		assertTrue(board.getField(pt1) == board.getField(point1));
	}
	
	@Test
	public void getFieldTest(){
		assertTrue(board.getField(pt1) == t1);
		assertTrue(board.getField(pt2) == t2);
		assertFalse(board.getField(pt3) == t3);
	}
	
	@Test
	public void setLastSetFieldTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getLastSetFieldTest() {
		fail("Not yet implemented");	
	}
	
	@Test
	public void resetTest() {
		fail("Not yet implemented");	
	}
	
	@Test
	public void getMapTest() {
		fail("Not yet implemented");
	}
	
	@Test
    public void testGetScore() {
		Board board1 = new Board();
		Map<Point, Tile> moves1 = new HashMap<Point, Tile>();
		assertEquals(board.getScore(moves1), 0);
        moves1.put(pt1, t1);
        moves1.put(pt2, t2);
		assertEquals(board1.getScore(moves1), 2);
    }
	
}*/
