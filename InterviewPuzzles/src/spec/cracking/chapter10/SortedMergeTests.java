package spec.cracking.chapter10;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter10.SortedMerge;

public class SortedMergeTests {

	@Test
	public void SimpleTestCase(){
		
		int[] A = {1, 2, 5, 8, 0, 0, 0, 0};
		int[] B = {3, 6, 7, 9};
		
		int[] result = SortedMerge.merge(A, B, 3);
		int[] expected = {1,2,3,5,6,7,8,9};
		
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
	}
	
	@Test
	public void BisEmpty_GetBackA(){
		
		int[] A = {1, 2, 5, 8};
		int[] B = {};
		
		int[] result = SortedMerge.merge(A, B, 3);
		int[] expected = {1,2,5,8};
		
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
	}

}
