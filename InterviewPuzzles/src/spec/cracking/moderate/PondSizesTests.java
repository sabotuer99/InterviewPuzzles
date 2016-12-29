package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.moderate.PondSizes;

public class PondSizesTests {

	@Test
	public void BookTestCase(){
		int[][] grid = {{0,2,1,0},
				        {0,1,0,1},
				        {1,1,0,1},
				        {0,1,0,1}};
		
		List<Integer> ponds = PondSizes.findAllPonds(grid);
		
		assertEquals(3, ponds.size());
		assertTrue(ponds.contains(4));
		assertTrue(ponds.contains(1));
		assertTrue(ponds.contains(2));
	}
	
}
