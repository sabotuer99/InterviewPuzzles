package spec.mithack;

import java.util.Arrays;

import org.junit.Test;

import puzzles.mithack.CoinDice;

public class CoinDiceTests {

	@Test
	public void DistributionTest(){
		int[] rolls = new int[7];
		
		for(int i = 0; i < 100000; i++){
			int roll = CoinDice.dieroll();
			rolls[roll]++;
		}
		
		System.out.println(Arrays.toString(rolls));
	}
	
	@Test
	public void CoinDistributionTest(){
		int[] flips = new int[2];
		
		for(int i = 0; i < 100000; i++){
			int flip = CoinDice.coinflip();
			flips[flip]++;
		}
		
		System.out.println(Arrays.toString(flips));
	}
	
	
}
