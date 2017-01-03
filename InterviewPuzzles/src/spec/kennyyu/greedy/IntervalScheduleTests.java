package spec.kennyyu.greedy;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.kennyyu.greedy.IntervalSchedule;

public class IntervalScheduleTests {

	@Test
	public void BasicTest(){
		int[] s = {1,2,3};
		int[] f = {2,3,4};
		
		Set<Integer> result = IntervalSchedule.largestSchedule(s, f);
		
		assertEquals(3, result.size());
	}
	
	@Test
	public void AllOverlap(){
		int[] s = {1,2,3};
		int[] f = {4,4,4};
		
		Set<Integer> result = IntervalSchedule.largestSchedule(s, f);
		
		assertEquals(1, result.size());
	}
	
	@Test
	public void PaperExample(){
		int[] s = {1,2,6,3,8,4,5,6};
		int[] f = {3,5,8,7,10,9,10,10};
		
		Set<Integer> result = IntervalSchedule.largestSchedule(s, f);
		
		assertEquals(3, result.size());
		assertTrue(result.contains(0));
		assertTrue(result.contains(3));
		assertTrue(result.contains(4));
	}
	
}
