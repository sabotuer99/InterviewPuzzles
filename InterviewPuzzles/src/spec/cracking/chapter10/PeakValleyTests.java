package spec.cracking.chapter10;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter10.PeakValley;

public class PeakValleyTests {

	@Test
	public void BookTestCase1(){
		int[] input = {5, 8, 6, 2, 3, 4, 6};
		
		int[] result = PeakValley.peakValley(input);
		
		System.out.println(Arrays.toString(result));
		assertPeakValley(result);
	}

	
	
	
	
	
	
	
	private void assertPeakValley(int[] result) {
		for(int i = 1; i < result.length - 1; i++){
			assertTrue(isPeakOrValley(result[i-1], result[i], result[i+1]));
		}
	}
	
	private boolean isPeakOrValley(int prev, int mid, int next) {
		System.out.printf("Checking %d, %d, %d\n", prev, mid, next);
		return (mid >= prev && mid >= next) || (mid <= prev && mid <= next);
	}
}
