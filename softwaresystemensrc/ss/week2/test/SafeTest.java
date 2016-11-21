package ss.week2.test;

import static org.junit.Assert.*;
import ss.week2.hotel.Safe;
import ss.week2.hotel.Password;

import org.junit.Before;
import org.junit.Test;

public class SafeTest {
	public Safe safe;
	public Password password;
	
	@Before
	public void setUp() {
		password = new Password();
		safe = new Safe(password);
	}

	@Test
	public void testActivateWrong() {
		safe.activate("wrong");
		assertFalse (safe.isActive());
	}
	
	@Test
	public void testActivateCorrect() {
		safe.activate(password.password);
		assertTrue (safe.isActive());
	}
	
	@Test
	public void testDeactivate() {
		safe.deactivate();
		assertFalse (safe.isOpen());
		assertFalse (safe.isActive());
	}
	
	@Test
	public void testOpenWrong() {
		safe.activate(password.password);	
		safe.open("wrong");
		assertFalse (safe.isOpen());
	}
	@Test
	public void testOpenCorrect() {
		safe.activate(password.password);
		safe.open(password.password);
		assertTrue (safe.isOpen());
	}
	@Test
	public void testClose() {
		safe.close();
		assertFalse (safe.isOpen());
	}
}
