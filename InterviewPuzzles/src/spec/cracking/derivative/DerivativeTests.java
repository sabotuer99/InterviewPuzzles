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
	public void Parse_CorrectResult() {
		String formula = "3x^2 + 5x + 2";
		
		Map<Integer,Integer> parsed = Derivative.parse(formula);
		
		assertEquals(3, parsed.size());
		assertTrue(parsed.containsKey(2));
		assertEquals(3, (int)parsed.get(2));
	}
	
}
