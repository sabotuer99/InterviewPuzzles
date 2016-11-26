package spec.cracking.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import puzzles.cracking.chapter1.ReplaceSpaces;

public class ReplaceSpacesTests {

	@Test
	public void GivenWordWithSpace_GetCorrectVersionBack() {
		String target = "This is a string with spaces";
		
		String result = ReplaceSpaces.replace(target);
		
		assertEquals("This%20is%20a%20string%20with%20spaces", result);
	}

}
