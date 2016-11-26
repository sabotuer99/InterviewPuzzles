package spec.cracking.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter1.AreAnagrams;

public class AreAnagramsTests {

	@Test
	public void GivenRaceAndCare_ReturnTrue() {
		String word1 = "Race";
		String word2 = "Care";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertTrue(test);
	}
	
	@Test
	public void GivenRaceAndDare_ReturnFalse() {
		String word1 = "Race";
		String word2 = "Dare";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}
	
	@Test
	public void GivenRaceAndRRRR_ReturnFalse() {
		String word1 = "Race";
		String word2 = "RRRR";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}

	@Test
	public void GivenRaceAndNull_ReturnFalse() {
		String word1 = "Race";
		String word2 = null;
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}
	
	@Test
	public void GivenNullAndWord_ReturnFalse() {
		String word1 = null;
		String word2 = "Word";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}
	
	@Test
	public void GivenRaceAndEmptyString_ReturnFalse() {
		String word1 = "Race";
		String word2 = "";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}
	
	@Test
	public void GivenEmptyStringAndWord_ReturnFalse() {
		String word1 = "";
		String word2 = "Word";
		
		boolean test = AreAnagrams.areAnagrams(word1, word2);
		
		assertFalse(test);
	}
	
}
