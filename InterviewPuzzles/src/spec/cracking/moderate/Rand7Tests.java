package spec.cracking.moderate;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.moderate.Rand7;

public class Rand7Tests {

	@Test
	public void coinFlipDistribution(){
		int[] results = new int[2];
		for(int i = 0; i < 100000; i++){
			int index = Rand7.coinFlip();
			results[index]++;
		}
		
		System.out.println(Arrays.toString(results));
	}
	
	@Test
	public void distributionTest(){
		int[] results = new int[7];
		for(int i = 0; i < 100000; i++){
			int index = Rand7.rand7();
			results[index]++;
		}
		
		System.out.println(Arrays.toString(results));
	}
	
	
	@Test
	public void distributionTest2(){
		int[] results = new int[7];
		for(int i = 0; i < 100000; i++){
			int index = Rand7.rand7T();
			results[index]++;
		}
		
		System.out.println(Arrays.toString(results));
	}
	
}
