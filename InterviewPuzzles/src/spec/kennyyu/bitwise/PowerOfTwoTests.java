package spec.kennyyu.bitwise;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.kennyyu.bitwise.PowerOfTwo;

public class PowerOfTwoTests {

	@Test
	public void PowersOfTwo(){
		boolean two = PowerOfTwo.isPowerOfTwo(2);
		boolean four = PowerOfTwo.isPowerOfTwo(4);
		boolean thirtytwo = PowerOfTwo.isPowerOfTwo(32);
		boolean sixtyfour = PowerOfTwo.isPowerOfTwo(64);
		
		assertTrue(two);
		assertTrue(four);
		assertTrue(thirtytwo);
		assertTrue(sixtyfour);
	}
	
	@Test
	public void NotPowersOfTwo(){
		boolean v3 = PowerOfTwo.isPowerOfTwo(3);
		boolean v7 = PowerOfTwo.isPowerOfTwo(7);
		boolean v88 = PowerOfTwo.isPowerOfTwo(88);
		boolean v120 = PowerOfTwo.isPowerOfTwo(120);
		
		assertFalse(v3);
		assertFalse(v7);
		assertFalse(v88);
		assertFalse(v120);
	}
}
