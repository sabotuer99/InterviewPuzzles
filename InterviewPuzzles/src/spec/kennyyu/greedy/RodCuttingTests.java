package spec.kennyyu.greedy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import puzzles.kennyyu.greedy.RodCutting;

public class RodCuttingTests {

	@Test
	public void simpleTest(){
		int[] prices = {1,4,9,10,11};
		int rodlength = 10;
		
		int max = RodCutting.maxProfit(rodlength, prices);
		
		assertEquals(28, max);
	}
	
	@Test
	public void simpleTestWithCuts(){
		int[] prices = {1,4,9,10,11};
		int rodlength = 10;
		List<Integer> cuts = new ArrayList<>();
		
		int max = RodCutting.maxProfit(rodlength, prices, cuts);
		
		assertEquals(28, max);
		assertEquals(4, cuts.size());
		assertEquals(3, (int)cuts.get(0));
		assertEquals(1, (int)cuts.get(3));
	}
}
