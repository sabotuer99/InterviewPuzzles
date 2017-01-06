package spec.kennyyu.misc;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.kennyyu.misc.FindRepeats;

public class FindRepeatsTests {

	@Test
	public void BasicTest(){
		int[] arr = {0,1,2,2,5,5,7,7,7,6};
		Set<Integer> result = FindRepeats.findRepeats(arr);
		
		assertEquals(3, result.size());
		assertTrue(result.contains(2));
		assertTrue(result.contains(5));
		assertTrue(result.contains(7));
		
	}
	
}
