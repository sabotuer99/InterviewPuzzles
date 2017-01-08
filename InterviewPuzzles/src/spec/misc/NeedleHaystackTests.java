package spec.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.NeedleHaystack;

public class NeedleHaystackTests {

	@Test
	public void NeedleIsInHaystack_ReturnsTrue(){
		String needle = "test";
		String haystack = "This is a test!";
		
		boolean result = NeedleHaystack.findNeedle(needle, haystack);
		
		assertTrue(result);
	}
	
	@Test
	public void NeedleIsNotInHaystack_ReturnsFalse(){
		String needle = "test";
		String haystack = "This is a text!";
		
		boolean result = NeedleHaystack.findNeedle(needle, haystack);
		
		assertFalse(result);
	}
}
