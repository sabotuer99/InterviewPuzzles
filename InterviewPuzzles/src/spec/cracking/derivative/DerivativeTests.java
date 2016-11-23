package spec.cracking.derivative;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import puzzles.cracking.derivative.Derivative;

public class DerivativeTests {

	@Test
	public void SimpleQuadratic_CorrectResult() {
		fail("Not Implemented");
	}

	@Test
	public void ParseSample_CorrectResult() {
		String formula = "3x^2 + 5x + 2";
		
		Map<Integer,Integer> parsed = Derivative.parse(formula);
		
		assertEquals("Incorrect Size", 3, parsed.size());

		assertEquals(3, (int)parsed.get(2));
		assertEquals(5, (int)parsed.get(1));
		assertEquals(2, (int)parsed.get(0));
	}
	
	@Test
	public void ParseSampleWithNeg_CorrectResult() {
		String formula = "-3x^2 - 5x - -2";
		
		Map<Integer,Integer> parsed = Derivative.parse(formula);
		
		assertEquals("Incorrect Size", 3, parsed.size());

		assertEquals(-3, (int)parsed.get(2));
		assertEquals(-5, (int)parsed.get(1));
		assertEquals(2, (int)parsed.get(0));
	}
	
	@Test
	public void ParseSuperSimple_CorrectResult() {
		String formula = "x";
		
		Map<Integer,Integer> parsed = Derivative.parse(formula);
		
		assertEquals("Incorrect Size", 1, parsed.size());
		assertEquals(1, (int)parsed.get(1));
	}
	
}
