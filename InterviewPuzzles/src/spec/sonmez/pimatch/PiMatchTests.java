package spec.sonmez.pimatch;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.sonmez.pimatch.PiMatch;

public class PiMatchTests {

	@Test
	public void Given_3149_GetCorrectCalc() {
		long num = 3149;
		
		double score = PiMatch.score(num);
		
		assertEquals(-82.5, score, 0.0000001);
	}
	
	@Test
	public void Given_neg3149_GetCorrectCalcForPositiveNumber() {
		long num = -3149;
		
		double score = PiMatch.score(num);
		
		assertEquals(-82.5, score, 0.0000001);
	}
	
	@Test
	public void Given_357878_GetCorrectCalc() {
		long num = 3149;
		
		double score = PiMatch.score(num);
		
		assertEquals(-82.5, score, 0.0000001);
	}
	
	@Test
	public void Given_123456789012_GetCorrectCalc() {
		long num = 123456789012L;
		
		double score = PiMatch.score(num);
		
		assertEquals(185.5, score, 0.0000001);
	}
	
	@Test
	public void Given_0_GetCorrectCalc() {
		long num = 0;
		
		double score = PiMatch.score(num);
		
		assertEquals(-314.0, score, 0.0000001);
	}
	

}
