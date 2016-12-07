package spec.cracking.chapter8;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter8.Stairs;

public class StairsTests {

	@Test
	public void Steps_Given0_Return1(){
		int result = Stairs.steps(0);
		assertEquals(1, result);
	}
	
	@Test
	public void Steps_GivenNeg_SameAsPos(){
		int result = Stairs.steps(-5);
		assertEquals(13, result);
	}
	
	@Test
	public void Steps_Given5_Return13(){
		int result = Stairs.steps(5);
		assertEquals(13, result);
	}
	
	@Test
	public void Steps_DetermineOverflow(){
		int result = 1;
		int i = 0;
		for(; result > 0; i++){
			result = Stairs.steps(i);
		}
		System.out.println(i-1);
		//best an int can do is 37
	}
}
