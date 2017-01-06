package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.ReverseString;

public class ReverseStringTests {

	@Test
	public void ReverseString(){
		String input = "abcde";
		String rev = ReverseString.reverse(input);
		
		assertEquals("edcba", rev);
	}
	
	@Test
	public void ReverseString_Null(){
		String input = null;
		String rev = ReverseString.reverse(input);
		
		assertNull(rev);
	}

	@Test
	public void ReverseString_Empty(){
		String input = "";
		String rev = ReverseString.reverse(input);
		
		assertEquals("", rev);
	}
	
}
