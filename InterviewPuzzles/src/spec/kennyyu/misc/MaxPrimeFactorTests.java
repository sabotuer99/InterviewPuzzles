package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.MaxPrimeFactor;

public class MaxPrimeFactorTests {

	@Test
	public void SqrtIsLargestPrime_ReturnsCorrectValue(){
		
		int n = 9;
		
		int fac = MaxPrimeFactor.maxPrimeFactor(n);
		
		assertEquals(3, fac);
	}
			
	@Test
	public void ValueIs125_Returns5(){
		
		int n = 125;
		
		int fac = MaxPrimeFactor.maxPrimeFactor(n);
		
		assertEquals(5, fac);
	}
	
	@Test
	public void ValueIsPrime_ReturnsValue(){
		
		int n = 97;
		
		int fac = MaxPrimeFactor.maxPrimeFactor(n);
		
		assertEquals(97, fac);
	}
	
	
	@Test
	public void ValueIsLargish_ReturnsCorrect(){
		
		int n = 97*23*5*7*7*3*2;
		
		int fac = MaxPrimeFactor.maxPrimeFactor(n);
		
		assertEquals(97, fac);
	}
	
}
