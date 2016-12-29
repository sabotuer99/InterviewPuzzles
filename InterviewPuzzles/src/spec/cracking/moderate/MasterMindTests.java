package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.MasterMind;

public class MasterMindTests {

	@Test
	public void BookTestCase(){
		String guess = "GGRR";
		String solution = "RGBY";
		
		int[] result = MasterMind.guessResult(guess, solution);
		
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
	}
	

	@Test
	public void AllMisses(){
		String guess = "AAAA";
		String solution = "RGBY";
		
		int[] result = MasterMind.guessResult(guess, solution);
		
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
	}
	
	@Test
	public void AllPHits(){
		String guess = "YBGR";
		String solution = "RGBY";
		
		int[] result = MasterMind.guessResult(guess, solution);
		
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
	}
	
	
	@Test
	public void AllHits(){
		String guess = "RGBY";
		String solution = "RGBY";
		
		int[] result = MasterMind.guessResult(guess, solution);
		
		assertEquals(4, result[0]);
		assertEquals(0, result[1]);
	}
}
