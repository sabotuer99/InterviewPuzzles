package spec.kennyyu;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.MaxSub;

public class MaxSubTests {

	@Test
	public void Test1_CorrectAnswer() {
		int[] nums = {2,1,-3,-2,-4,-1,0,3};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(3, max);
	}
	
	@Test
	public void Test2_CorrectAnswer() {
		int[] nums = {1,-1,-4,3,-2,0,-3,2};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(3, max);
	}
	
	@Test
	public void Test3_CorrectAnswer() {
		int[] nums = {3,4,-3,-5,1,0,-1,2,-4,-2};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(7, max);
	}
	
	@Test
	public void Test4_CorrectAnswer() {
		int[] nums = {-5,0,-4,1,4,3,-2,-1,2,-3};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(8, max);
	}
	
	@Test
	public void GivenNull_Return0() {
		int[] nums = null;
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(0, max);
	}
	
	
	@Test
	public void GivenEmptyArray_Return0() {
		int[] nums = {};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(0, max);
	}

	@Test
	public void GivenAllNeg_Return0() {
		int[] nums = {-5,-1,-4,-1,-4,-3,-2,-1,-2,-3};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(0, max);
	}
	
	@Test
	public void GivenAllPos_ReturnArraySum() {
		int[] nums = {1,1,1,1,1,1,1,1,1,1};
		
		int max = MaxSub.maxsubarray(nums);
		
		assertEquals(10, max);
	}
	
}
