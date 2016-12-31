package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.kennyyu.datastructures.MergeSortedLists;

public class MergeSortedListsTests {

	@Test
	public void BasicTest(){
		int[] list1 = {1,5,9,11,56,99};
		int[] list2 = {2,7,89,101};
		int[] list3 = {4,5,6,7,8,9,12,13};
		
		Integer[] merged = MergeSortedLists.merge(list1, list2, list3);
		
		String result = Arrays.toString(merged);
		
		assertEquals(18, merged.length);
		assertEquals("[1, 2, 4, 5, 5, 6, 7, 7, 8, 9, 9, 11, 12, 13, 56, 89, 99, 101]", result);
	}
	
	@Test
	public void OneEmptyInputArray(){
		int[] list1 = {1,5};
		int[] list2 = {};
		int[] list3 = {2, 3, 4};
		
		Integer[] merged = MergeSortedLists.merge(list1, list2, list3);
		
		String result = Arrays.toString(merged);
		
		assertEquals(5, merged.length);
		assertEquals("[1, 2, 3, 4, 5]", result);
	}
	
	@Test
	public void OneNullInputArray(){
		int[] list1 = {1,5};
		int[] list2 = null;
		int[] list3 = {2, 3, 4};
		
		Integer[] merged = MergeSortedLists.merge(list1, list2, list3);
		
		String result = Arrays.toString(merged);
		
		assertEquals(5, merged.length);
		assertEquals("[1, 2, 3, 4, 5]", result);
	}
	
	@Test
	public void SingleElementInputArrays(){
		int[] list1 = {1};
		int[] list2 = {2};
		int[] list3 = {3};
		int[] list4 = {4};
		int[] list5 = {5};
		
		Integer[] merged = MergeSortedLists.merge(list1, list2, list3, list4, list5);
		
		String result = Arrays.toString(merged);
		
		assertEquals(5, merged.length);
		assertEquals("[1, 2, 3, 4, 5]", result);
	}
	
}
