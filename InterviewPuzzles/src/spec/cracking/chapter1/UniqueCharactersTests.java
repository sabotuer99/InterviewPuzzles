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

}
