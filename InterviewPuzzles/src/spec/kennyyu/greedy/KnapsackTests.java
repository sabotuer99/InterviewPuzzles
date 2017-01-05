package spec.kennyyu.greedy;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.kennyyu.greedy.Knapsack;

public class KnapsackTests {

	@Test
	public void SimpleTest(){
		int[] w = {7, 2, 5, 1};
		int[] v = {6, 3, 4, 2};
		int limit = 8;
		
		Set<Integer> result = Knapsack.bestItems(w, v, limit);
		
		assertEquals(3, result.size());
		assertTrue(result.contains(1));
		assertTrue(result.contains(2));
		assertTrue(result.contains(3));
	}
	
	@Test
	public void SameWeightItems(){
		int[] w = {2, 2, 2, 2};
		int[] v = {6, 3, 4, 2};
		int limit = 4;
		
		Set<Integer> result = Knapsack.bestItems(w, v, limit);
		
		assertEquals(2, result.size());
		assertTrue(result.contains(0));
		assertTrue(result.contains(2));
	}
}
