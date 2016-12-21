package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.cracking.moderate.DivingBoard;

public class DivingBoardTests {

	@Test
	public void SimpleTest1(){
		double lb = 10.0;
		double sb = 5.0;
		int k = 3;
		
		Set<Double> result = DivingBoard.calculateLengths(lb, sb, k);
		
		assertEquals(4, result.size());
	}
	
	@Test
	public void SimpleTest2(){
		double lb = 13.0;
		double sb = 23.0;
		int k = 12;
		
		Set<Double> result = DivingBoard.calculateLengths(lb, sb, k);
		
		assertEquals(13, result.size());
	}
	
	
}
