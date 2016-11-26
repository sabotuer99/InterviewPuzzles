package spec.cracking.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter1.DedupeString;

public class DedupeStringTests {

	@Test
	public void GivenMoon_ReturnMon() {
		String input = "Moon";
		
		String result = DedupeString.dedupe(input);
		
		assertEquals("Mon", result);
	}
	
	@Test
	public void GivenAaaaaaaaaaaaaahh_ReturnAah() {
		String input = "Aaaaaaaaaaaaaahh";
		
		String result = DedupeString.dedupe(input);
		
		assertEquals("Aah", result);
	}
	
	@Test
	public void GivenAaaaaaaaaaaaaa_ReturnAa() {
		String input = "Aaaaaaaaaaaaaa";
		
		String result = DedupeString.dedupe(input);
		
		assertEquals("Aa", result);
	}
	
	@Test
	public void GivenNull_ReturnNull() {
		String input = null;
		
		String result = DedupeString.dedupe(input);
		
		assertNull(result);
	}

}
