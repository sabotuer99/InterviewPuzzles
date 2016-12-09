package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter10.RotatedBinarySearch;

public class RotatedBinarySearchTests {

	@Test
	public void BookTestCase(){
		int[] nums = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		int index = RotatedBinarySearch.search(5, nums);
		
		assertEquals(8, index);
	}
	
	@Test
	public void RotatedOneRight(){
		int[] nums = {25, 1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20};
		
		int index = RotatedBinarySearch.search(5, nums);
		
		assertEquals(4, index);
	}
	
	@Test
	public void RotatedOneLeft(){
		int[] nums = {3, 4, 5, 7, 10, 14, 15, 16, 19, 20,25, 1};
		
		int index = RotatedBinarySearch.search(5, nums);
		
		assertEquals(2, index);
	}
	
	@Test
	public void ValueNotInArray_ReturnsNegOne(){
		int[] nums = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		int index = RotatedBinarySearch.search(8, nums);
		
		assertEquals(-1, index);
	}
	
	@Test
	public void Null_returnsNegOne(){
		int[] nums = null;
		
		int index = RotatedBinarySearch.search(5, nums);
		
		assertEquals(-1, index);
	}
	
	@Test
	public void EmptyArray_returnsNegOne(){
		int[] nums = null;
		
		int index = RotatedBinarySearch.search(5, nums);
		
		assertEquals(-1, index);
	}
}
