package spec.kennyyu.greedy;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.greedy.GenericCoins;

public class GenericCoinsTests {

	@Test
	public void GivenNullCurrency_Returns0(){
		int[] currency = null;
		int target = 80;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(0, result);
	}
	
	@Test
	public void GivenBadCoin_Returns0(){
		int[] currency = {1, -5, 10, 25};
		int target = 80;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(0, result);
	}
	
	@Test
	public void GivenBadTargetValue_Returns0(){
		int[] currency = {1, 5, 10, 25};
		int target = -80;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(0, result);
	}
	
	@Test
	public void USCurrency(){
		int[] currency = {1, 5, 10, 25};
		int target = 80;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(4, result);
	}
	
	@Test
	public void WeirdCurrency_HasSolution(){
		int[] currency = {3, 7, 15};
		int target = 25;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(3, result);
	}
	
	@Test
	public void WeirdCurrency_NoSolution(){
		int[] currency = {7, 23};
		int target = 19;
		
		int result = GenericCoins.minCoins(currency, target);
		
		assertEquals(0, result);
	}

}
