package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.PatternMatching;

public class PatternMatchingTests {

	@Test
	public void BookTestCase(){
		String value = "catcatgocatgo";
		boolean test1 = PatternMatching.matchesPattern("aabab", value);
		boolean test2 = PatternMatching.matchesPattern("a", value);
		boolean test3 = PatternMatching.matchesPattern("ab", value);
		boolean test4 = PatternMatching.matchesPattern("b", value);
		
		assertTrue(test1);
		assertTrue(test2);
		assertTrue(test3);
		assertTrue(test4);
	}
	
	@Test
	public void FailingTest(){
		String value = "catcatgocatgodog";
		boolean test1 = PatternMatching.matchesPattern("aabab", value);
		assertFalse(test1);
	}
	
	@Test
	public void InvalidPattern_ReturnsFalse(){
		String value = "catcatgocatgodog";
		boolean test1 = PatternMatching.matchesPattern("aababc", value);
		assertFalse(test1);
	}
	
}
