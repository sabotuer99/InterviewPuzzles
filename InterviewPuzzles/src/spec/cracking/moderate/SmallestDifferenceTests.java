package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.SmallestDifference;

public class SmallestDifferenceTests {

	@Test
	public void BookTestCase(){
		int[] a = {1,3,15,11,2};
		int[] b = {23,127,235,19,8};
		
		int diff = SmallestDifference.minDiff(a, b);
		
		assertEquals(3, diff);
	}
	
	@Test
	public void CommonElement_Returns0(){
		int[] a = {1,3,15,11,2};
		int[] b = {23,127,15,19,8};
		
		int diff = SmallestDifference.minDiff(a, b);
		
		assertEquals(0, diff);
	}
}
