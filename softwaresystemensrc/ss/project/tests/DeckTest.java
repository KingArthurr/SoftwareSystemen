package ss.project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ss.project.Deck;
import ss.project.Tile;
import ss.project.Tile.Color;
import ss.project.Tile.Shape;

public class DeckTest {
	
	Deck deck;
	int amount;

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
		amount = Shape.values().length * Color.values().length * 3;
	}
	
	@Test
	public void testTilesremaining() {
        assertEquals(deck.Tilesremaining(), amount);
        deck.drawTile();
        assertEquals(deck.Tilesremaining(), 107);
    }
	
	@Test
	public void testShuffle() {
		Tile tile1 = deck.drawTile();
		deck.Shuffle();
		Tile tile2 = deck.drawTile();
		assertTrue(tile1 != tile2);
		Tile tile3 = deck.drawTile();
		deck.Shuffle();
		Tile tile4 = deck.drawTile();
		assertTrue(tile3 != tile4);
		Tile tile5 = deck.drawTile();
		deck.Shuffle();
		Tile tile6 = deck.drawTile();
		assertTrue(tile5 != tile6);
		
		// test 4x aangezien er de mogelijkheid is 3 keer
		// hetzelfde blokje te krijgen, omdat elk blokje 3x bestaat
    }
	
	@Test
	public void testDrawHand() {
		List<Tile> tiles = new ArrayList<>();
		tiles.addAll(deck.drawHand());
		assertEquals(6, tiles.size());
		assertEquals(amount - 6, deck.Tilesremaining());
    }
	
	@Test
	public void testDrawTile() {
		List<Tile> tiles2 = new ArrayList<>();
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		assertEquals(5, tiles2.size());
		assertEquals(amount - 5, deck.Tilesremaining());
    }
	
	@Test
	public void testChangeTile() {
		Set<Tile> tiles2 = new HashSet<>();
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		tiles2.add(deck.drawTile());
		Set<Tile> tiles1 = tiles2;
		Set<Tile> tiles3 = deck.changeTile(tiles2);
		assertEquals(tiles3.size(), 5);
		assertNotEquals(tiles1, tiles3);
    }

}
