package spec.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.misc.FindSum;

public class FindSumTests {

	@Test
	public void Example1_CorrectAnswer() {
		int[] nums = {1, 2, 3, 9};
		int sum = 8;
		
		boolean result = FindSum.hasSum(nums, sum);
		
		assertFalse(result);
	}
	
	@Test
	public void Example2_CorrectAnswer() {
		int[] nums = {1, 2, 4, 4};
		int sum = 8;
		
		boolean result = FindSum.hasSum(nums, sum);
		
		assertTrue(result);
	}
	
	@Test
	public void Example1_Unsorted_CorrectAnswer() {
		int[] nums = {9, 1, 2, 3};
		int sum = 8;
		
		boolean result = FindSum.hasSumUnsorted(nums, sum);
		
		assertFalse(result);
	}
	
	@Test
	public void Example2_Unsorted_CorrectAnswer() {
		int[] nums = {4, 1, 2, 4};
		int sum = 8;
		
		boolean result = FindSum.hasSumUnsorted(nums, sum);
		
		assertTrue(result);
	}
	
	@Test
	public void GivenNullArray_ReturnFalse() {
		int[] nums = null;
		int sum = 8;
		
		boolean result = FindSum.hasSum(nums, sum);
		
		assertFalse(result);
	}
	
	@Test
	public void GivenEmptyArray_ReturnFalse() {
		int[] nums = {};
		int sum = 8;
		
		boolean result = FindSum.hasSum(nums, sum);
		
		assertFalse(result);
	}
	
	@Test
	public void GivenSingleElementArray_ReturnFalse() {
		int[] nums = {1};
		int sum = 8;
		
		boolean result = FindSum.hasSum(nums, sum);
		
		assertFalse(result);
	}

}
