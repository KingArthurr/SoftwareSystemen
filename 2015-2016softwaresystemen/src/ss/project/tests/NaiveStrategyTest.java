package ss.project.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.project.NaiveStrategy;

public class NaiveStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("Naive", (new NaiveStrategy()).getName());
	}
	
	@Test
	public void testDetermineMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDetermineExchange() {
		fail("Not yet implemented");
	}

}
