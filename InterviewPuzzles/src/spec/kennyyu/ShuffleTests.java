package spec.kennyyu;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import puzzles.kennyyu.Shuffle;

public class ShuffleTests {

	@Test
	public void Shuffle_10RandomDistributions() {
		
		for(int i = 0; i < 10; i++){
			int[] arr = {0,1,2,3,4,5,6,7,8,9};
			Shuffle.shuffle(arr);
			System.out.println(Arrays.toString(arr));
		}
		
		assertTrue(true);
	}
	
	@Test
	public void Shuffle_1000000RandomDistributions() {
		int[][] histogram = new int[10][10];
		
		for(int i = 0; i < 1000000; i++){
			int[] arr = {0,1,2,3,4,5,6,7,8,9};
			Shuffle.shuffle(arr);
			
			for(int j=0; j < 10; j++){
				histogram[arr[j]][j]++;
			}
		}
		
		for(int j=0; j < 10; j++){
			System.out.println(j + ": " + Arrays.toString(histogram[j]));
		}
		
		assertTrue(true);
	}
	
	
	@Test
	@Ignore
	public void Randbetween_EvenDistribution() {
		int[] histogram = new int[10];
		
		for(int i = 0; i < 1000000; i++){
			int k = Shuffle.randbetween(0,10);
			histogram[k]++;
		}
		
		System.out.println(Arrays.toString(histogram));
		
		assertTrue(true);
	}

}
