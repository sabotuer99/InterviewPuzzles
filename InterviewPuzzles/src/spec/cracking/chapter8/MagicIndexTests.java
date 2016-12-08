package spec.cracking.chapter8;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter8.MagicIndex;

public class MagicIndexTests {

	@Test
	public void FindIndices_SingleMagicIndex(){
		int[] array = {-1,0,2,4,5,6};
		
		List<Integer> result = MagicIndex.findMagicIndices(array);
		
		assertEquals(1, result.size());
		assertEquals(2, (int)result.get(0));
	}
	
	@Test
	public void FindIndices_SequenceMagicIndex(){
		int[] array = {-1,0,2,3,4,6};
		
		List<Integer> result = MagicIndex.findMagicIndices(array);
		
		assertEquals(3, result.size());
		assertEquals(2, (int)result.get(0));
		assertEquals(4, (int)result.get(2));
	}
	
	@Test
	public void FindIndices_NoMagicIndex(){
		int[] array = {-1,0,1,2,3,4,6};
		
		List<Integer> result = MagicIndex.findMagicIndices(array);
		
		assertEquals(0, result.size());
	}
	
	
}
