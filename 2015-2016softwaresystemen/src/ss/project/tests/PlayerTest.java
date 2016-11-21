package ss.project.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ss.project.HumanPlayer;
import ss.project.Player;
import ss.project.Tile;
import ss.project.Tile.Color;
import ss.project.Tile.Shape;

public class PlayerTest {
	
	Player player;
	Set<Tile> tiles = new HashSet<Tile>();

	@Before
	public void setUp() throws Exception {		
        tiles.add(new Tile(Shape.CIRCLE, Color.BLUE));
        tiles.add(new Tile(Shape.DIAMOND, Color.GREEN));
        tiles.add(new Tile(Shape.CLUB, Color.YELLOW));
        tiles.add(new Tile(Shape.STAR, Color.PURPLE));
        tiles.add(new Tile(Shape.CLUB, Color.BLUE));
        tiles.add(new Tile(Shape.STAR, Color.GREEN));
        player = new HumanPlayer("Speler", tiles);
	}

	@Test
	public void testGetName() {
        assertEquals("Speler", player.getName());
    }
	
	@Test
    public void testGetHand() {
        assertEquals(6, player.getHand().size());
        assertTrue(tiles.equals(player.getHand()));
    }
	
	@Test
    public void testGetPoints() {
        assertEquals(0, player.getPoints());
		player.addPoints(3);
		assertEquals(3, player.getPoints());
    }
	
	@Test
    public void testAddPoints() {
		player.setPoints(2);
		player.addPoints(3);
		assertEquals(5, player.getPoints());
    }
	
	@Test
    public void testSetPoints() {
        player.setPoints(123);
        assertEquals(123, player.getPoints());	
    }
	
	@Test
    public void testMakeMove() {
		fail("Not yet implemented");
    }
	
	@Test
    public void testGetHint() {
		fail("Not yet implemented");
    }
	
	@Test
    public void testGetValidMoves() {
		fail("Not yet implemented");
    }
	
	@Test
    public void testDeckEmpty() {
		assertTrue(player.deckEmpty() == true);
    }

}
