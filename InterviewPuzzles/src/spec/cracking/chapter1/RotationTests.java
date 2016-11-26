package spec.cracking.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter1.Rotation;

public class RotationTests {

	@Test
	public void TestCaseFromBook() {
		String word1 = "waterbottle";
		String word2 = "erbottlewat";
		
		boolean result = Rotation.isRotation(word1, word2);
		
		assertTrue(result);
	}
	
	@Test
	public void GivenFooAndBar_ReturnFalse() {
		String word1 = "foo";
		String word2 = "bar";
		
		boolean result = Rotation.isRotation(word1, word2);
		
		assertFalse(result);
	}

}
