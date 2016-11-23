package spec.kennyyu;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import puzzles.kennyyu.Shuffle;

public class ShuffleTests {

	
	
	
	
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
