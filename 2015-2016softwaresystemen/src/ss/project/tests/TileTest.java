package ss.project.tests;

import static org.junit.Assert.*;

import ss.project.Tile;
import ss.project.Tile.Color;
import ss.project.Tile.Shape;

import org.junit.Before;
import org.junit.Test;

public class TileTest {
	
	Tile tile1;
	Tile tile2;
	
	@Before
	public void setUp() throws Exception {
        tile1 = new Tile(Shape.CIRCLE, Color.ORANGE);
        tile2 = new Tile(Shape.SQUARE, Color.YELLOW);
	}
	
	@Test
	public void testGetColor() {
        assertEquals(Color.ORANGE, tile1.getColor());
    }
	
	@Test
    public void testGetShape() {
        assertEquals(Shape.SQUARE, tile2.getShape());
    }
	
	@Test
    public void testEquals() {
        assertNotEquals(tile1, tile2);
    }
	
}
