package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.Sqrt;

public class SqrtTests {

	@Test
	public void Test10(){
		
		double n = 10.0;
		double epsilon = 0.00001;
		
		double sqrt = Sqrt.sqrt(n, epsilon);
		
		assertEquals(3.16228, sqrt, epsilon);
	}
	
	@Test
	public void Test9ToConvergence(){
		
		double n = 9.0;
		double epsilon = 0.0;
		
		double sqrt = Sqrt.sqrt(n, epsilon);
		
		assertEquals(3.0, sqrt, epsilon);
	}
	
	@Test
	public void Test0(){
		
		double n = 0.0;
		double epsilon = 0.000001;
		
		double sqrt = Sqrt.sqrt(n, epsilon);
		
		assertEquals(0.0, sqrt, epsilon);
	}
	
	@Test
	public void Test1(){
		
		double n = 1.0;
		double epsilon = 0.0;
		
		double sqrt = Sqrt.sqrt(n, epsilon);
		
		assertEquals(1.0, sqrt, epsilon);
	}
	
}
