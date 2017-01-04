package spec.kennyyu.greedy;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.kennyyu.greedy.WeightedIntervalSchedule;

public class WeightedIntervalScheduleTests {

	@Test
	public void BasicTest1(){
		int[] s = {1 ,9 ,6 ,3 ,12};
		int[] f = {4 ,13,10,7 ,15};
		int[] w = {2 ,11,3 ,10,4 };
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(2, best.size());
		assertTrue(best.contains(1));
		assertTrue(best.contains(3));
	}
	
	@Test
	public void BasicTest2(){
		int[] s = {1 ,9};
		int[] f = {4 ,13};
		int[] w = {2 ,11};
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(2, best.size());
		assertTrue(best.contains(1));
		assertTrue(best.contains(0));
	}
	
	@Test
	public void ManySmallOneBig_BigBetter(){
		int[] s = {1 ,2 ,3 ,4 ,1};
		int[] f = {2 ,3 ,4 ,5 ,5};
		int[] w = {1, 1, 1, 1, 5};
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(1, best.size());
		assertTrue(best.contains(4));
	}
	
	@Test
	public void ManySmallOneBig_SmallBetter(){
		int[] s = {1 ,2 ,3 ,4 ,1};
		int[] f = {2 ,3 ,4 ,5 ,5};
		int[] w = {1, 1, 1, 1, 3};
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(4, best.size());
		assertTrue(best.contains(0));
		assertTrue(best.contains(1));
		assertTrue(best.contains(2));
		assertTrue(best.contains(3));
	}
	
	@Test
	public void MisMatchedInput_EmptySetResult(){
		int[] s = {1 ,9 ,6 ,3 ,12, 1};
		int[] f = {4 ,13,10,7 ,15, 2};
		int[] w = {2 ,11,3 ,10,4 };
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(0, best.size());
	}
	
	@Test
	public void NullInput_EmptySetResult(){
		int[] s = null;
		int[] f = null;
		int[] w = null;
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(0, best.size());
	}
	
	@Test
	public void EmptyInput_EmptySetResult(){
		int[] s = {};
		int[] f = {};
		int[] w = {};
		
		Set<Integer> best = WeightedIntervalSchedule.maxValueSchedule(s, f, w);
		
		assertEquals(0, best.size());
	}
}
