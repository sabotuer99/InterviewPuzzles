package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.ThreeSum;

public class ThreeSumTests {

	@Test
	public void BasicTest_PositiveCase(){
		int[] arr = {1,2,5,9,6,4,8,3};
		int k = 19; //several ways of doing this
		
		boolean result = ThreeSum.threeSum(arr, k);
		
		assertTrue(result);
	}
	
	@Test
	public void BasicTest_NegativeCase(){
		int[] arr = {1,2,5,9,6,4,8,3};
		int k = 24; //Out of possible range
		
		boolean result = ThreeSum.threeSum(arr, k);
		
		assertFalse(result);
	}
}
