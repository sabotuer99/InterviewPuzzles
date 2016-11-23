package spec.kennyyu;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.StockProfit;

public class StockProfitTests {

	@Test
	public void GivenTypicalData_ComputeCorrectValue() {
		int[] prices = {10,11,8,13};
		
		int maxprofit = StockProfit.maxProfit(prices);
		
		assertEquals(5, maxprofit);
	}
	
	@Test
	public void GivenNull_Return0() {
		int[] prices = null;
		
		int maxprofit = StockProfit.maxProfit(prices);
		
		assertEquals(0, maxprofit);
	}
	
	@Test
	public void GivenEmptyArray_Return0() {
		int[] prices = {};
		
		int maxprofit = StockProfit.maxProfit(prices);
		
		assertEquals(0, maxprofit);
	}
	
	@Test
	public void GivenSinglePrice_Return0() {
		int[] prices = {10};
		
		int maxprofit = StockProfit.maxProfit(prices);
		
		assertEquals(0, maxprofit);
	}

}
