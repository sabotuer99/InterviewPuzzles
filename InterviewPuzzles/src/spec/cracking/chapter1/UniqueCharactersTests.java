package spec.cracking.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import puzzles.cracking.chapter1.UniqueCharacters;

public class UniqueCharactersTests {

	@Test
	public void GivenWORD_ReturnTrue() {
		String word = "WORD";
		
		boolean result = UniqueCharacters.uniqueChars(word);
		
		assertTrue(result);
	}
	
	@Test
	public void GivenBLAAAAH_ReturnFalse() {
		String word = "BLAAAAH";
		
		boolean result = UniqueCharacters.uniqueChars(word);
		
		assertFalse(result);
	}
	
	@Test
	public void GivenNull_ReturnFalse() {
		String word = null;
		
		boolean result = UniqueCharacters.uniqueChars(word);
		
		assertFalse(result);
	}
	
	@Test
	public void GivenEmptyString_ReturnFalse() {
		String word = "";
		
		boolean result = UniqueCharacters.uniqueChars(word);
		
		assertFalse(result);
	}
	
	@Test
	public void NoSet_GivenWORD_ReturnTrue() {
		String word = "WORD";
		
		boolean result = UniqueCharacters.uniqueCharsNoSet(word);
		
		assertTrue(result);
	}
	
	@Test
	public void NoSet_GivenBLAAAAH_ReturnFalse() {
		String word = "BLAAAAH";
		
		boolean result = UniqueCharacters.uniqueCharsNoSet(word);
		
		assertFalse(result);
	}
	
	@Test
	public void NoSet_GivenNull_ReturnFalse() {
		String word = null;
		
		boolean result = UniqueCharacters.uniqueCharsNoSet(word);
		
		assertFalse(result);
	}
	
	@Test
	public void NoSet_GivenEmptyString_ReturnFalse() {
		String word = "";
		
		boolean result = UniqueCharacters.uniqueCharsNoSet(word);
		
		assertFalse(result);
	}

}
