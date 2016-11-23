package spec.cracking.annagrams;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.annagrams.Annagrams;

public class AnnagramsTests {

	@Test
	public void GivenABC_Computes6Permutations() {
		String word = "ABC";
		
		List<String> annagrams = Annagrams.compute(word);
		
		assertEquals(6, annagrams.size());
		assertTrue(annagrams.indexOf("ACB") > -1);
	}
	
	@Test
	public void GivenABCD_Computes24Permutations() {
		String word = "ABCD";
		
		List<String> annagrams = Annagrams.compute(word);
		
		assertEquals(24, annagrams.size());
		assertTrue(annagrams.indexOf("DACB") > -1);
	}
	
	@Test
	public void GivenNull_Computes0Permutations() {
		String word = null;
		
		List<String> annagrams = Annagrams.compute(word);
		
		assertEquals(0, annagrams.size());
	}
	
	@Test
	public void GivenEmptyString_Computes0Permutations() {
		String word = "";
		
		List<String> annagrams = Annagrams.compute(word);
		
		assertEquals(0, annagrams.size());
	}

}
