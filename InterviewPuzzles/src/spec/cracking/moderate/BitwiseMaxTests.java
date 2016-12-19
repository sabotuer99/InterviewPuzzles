package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.BitwiseMax;

public class BitwiseMaxTests {

	@Test
	public void SimpleTest_ReturnsMax(){
		
		int a = 10;
		int b = 5;
		
		int max = BitwiseMax.max(a, b);
		
		assertEquals(10, max);
		
	}
	
	@Test
	public void EqualValues_ReturnsEither(){
		int a = 10;
		int b = 10;
		
		int max = BitwiseMax.max(a, b);
		
		assertEquals(10, max);
	}
	
	
}
