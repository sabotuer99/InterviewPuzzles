package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter10.SparseSearch;

public class SparseSearchTests {

	@Test
	public void basicTests(){
		String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		int result = SparseSearch.sparseSearch(input, "ball");
		
		assertEquals(4, result);
	}
	
	@Test
	public void wordNotInArray_ReturnsNegOne(){
		String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		int result = SparseSearch.sparseSearch(input, "bait");
		
		assertEquals(-1, result);
	}
	
	@Test
	public void denseArray_findCorrectAnswer(){
		String[] input = {"at", "attack", "azzz", "baaa", "ball", 
				"buns", "bzzzz", "car", "cat", "cazzz", "dad", "dead", "zombie"};
		
		int result = SparseSearch.sparseSearch(input, "cazzz");
		
		assertEquals(9, result);
	}
	
	@Test
	public void nullArray_returnsNegOne(){
		
		int result = SparseSearch.sparseSearch(null, "cazzz");
		
		assertEquals(-1, result);
	}
}
