package spec.kennyyu.bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.bitwise.BitMask;

public class BitMaskTests {

	@Test
	public void NoMissingLetters_EmptyString(){
		
		String input = "abcdefghijklmnopqrstuvwxyz";
		
		String unused = BitMask.missingLetters(input);
		
		assertEquals("", unused);
	}
	
	@Test
	public void InvalidLetters_Null(){
		
		String input = "##abcdefghijklmnopqrstuvwxyz";
		
		String unused = BitMask.missingLetters(input);
		
		assertNull(unused);
	}
	
	@Test
	public void GivenNull_GetNull(){
		
		String input = null;
		
		String unused = BitMask.missingLetters(input);
		
		assertNull(unused);
	}
	
	@Test
	public void NoVowels_Getaeiou(){
		
		String input = "bcdfghjklmnpqrstvwxyz";
		
		String unused = BitMask.missingLetters(input);
		
		assertEquals("aeiou", unused);
	}
	
}
