package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.AddOperations;

public class AddOperationsTests {

	@Test
	public void Subtract(){
		int a = 4;
		int b = 60;
		
		int result = AddOperations.subtract(a, b);
		
		assertEquals(56, result);
	}
	
	@Test
	public void Multiply(){
		int a = 4;
		int b = 60;
		
		int result = AddOperations.multiply(a, b);
		
		assertEquals(240, result);
	}
	
	@Test
	public void Divide(){
		int a = 4;
		int b = 60;
		
		int result = AddOperations.divide(a, b);
		
		assertEquals(15, result);
	}	
}
