package spec.kennyyu.misc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.kennyyu.misc.DutchFlag;

public class DutchFlagTests {

	@Test
	public void PaperTest(){
		int[] arr = {9,3,6,2,4,7,8,1};
		int low = 4;
		int high = 6;
		
		DutchFlag.dutchify(arr, low, high);
		
		assertEquals("[1, 3, 2, 6, 4, 9, 7, 8]", Arrays.toString(arr));
	}
	
	@Test
	public void MostlySorted(){
		int[] arr = {1,3,2,6,7,4,9,8};
		int low = 4;
		int high = 6;
		
		DutchFlag.dutchify(arr, low, high);
		
		assertEquals("[1, 3, 2, 6, 4, 7, 9, 8]", Arrays.toString(arr));
	}
}
