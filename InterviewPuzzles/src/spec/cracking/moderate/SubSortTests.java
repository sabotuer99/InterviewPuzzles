package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.SubSort;

public class SubSortTests {

	@Test
	public void BookTestCase(){
		int[] input = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		
		int[] result = SubSort.subSort(input);
		
		assertEquals(3, result[0]);
		assertEquals(9, result[1]);
	}
	
	@Test
	public void SortBeginning(){
		int[] input = {9,1,2,4,7,10,11,7,12,6,7,16,18,19};
		
		int[] result = SubSort.subSort(input);
		
		assertEquals(0, result[0]);
		assertEquals(10, result[1]);
	}
	
	@Test
	public void SortEnd(){
		int[] input = {1,2,4,7,10,11,12,19,18,16};
		
		int[] result = SubSort.subSort(input);
		
		assertEquals(7, result[0]);
		assertEquals(9, result[1]);
	}
	
	
	@Test
	public void EmptyOrNullInput(){
		int[] empty = {};
		
		int[] resultEmpty = SubSort.subSort(empty);
		int[] resultNull = SubSort.subSort(null);
		
		assertNull(resultEmpty);
		assertNull(resultNull);
	}
	
	@Test
	public void SortedInput(){
		int[] input = {1,2,4,7,10,11,12};
		
		int[] result = SubSort.subSort(input);
		
		assertNull(result);
	}
}
