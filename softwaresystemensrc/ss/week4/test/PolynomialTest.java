package ss.week4.test;

import static org.junit.Assert.*;

import ss.week4.math.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {
	private Polynomial poly;
	private Function deriv;
	private double[] values = {4.0,3.0,2.0};
	private Function[] value = {new Constant(4.0),new Constant(3.0),new Constant(2.0)};	
			
	@Before
	public void setUp(){
		poly = new Polynomial(values);
		deriv = new Polynomial(value);
	}

	@Test
	public void testApply() {
		assertTrue(poly.apply(35.0) == 5007.0);
	}
	
	@Test
	public void testDerivative() {
		assertTrue(deriv.derivative().apply(35.0) == 283.0);
	}
	
	@Test
	public void testIntegrad() {
		System.out.print(poly.Integrad().apply(35.0));
		assertTrue(poly.Integrad().apply(35.0) == 4953.166666666667);
	}
}
