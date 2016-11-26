package spec.cracking.chapter1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter1.ReverseCString;

public class ReverseCStringTests {

	@Test
	public void GivenCString_CorrectReverse() {
		String word = "CString\0";
		
		String rev = ReverseCString.reverse(word);
		
		assertEquals("gnirtSC\0", rev);
	}
	
	@Test
	public void GivenRegularString_CorrectReverse() {
		String word = "String";
		
		String rev = ReverseCString.reverse(word);
		
		assertEquals("gnirtS", rev);
	}

}
