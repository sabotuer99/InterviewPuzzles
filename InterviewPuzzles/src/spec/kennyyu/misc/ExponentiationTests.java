package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.Exponentiation;

public class ExponentiationTests {

	@Test
	public void BigTest(){
		long n = 3;
		long m = 35;
		
		long result = Exponentiation.exp(n, m);
		long expect = Exponentiation.expNaive(n, m);
		
		assertEquals(expect, result);
	}
	
	@Test
	public void SpeedTest(){
		long n = 3;
		long m = 1000000; //this will overflow and produce nonsense, but the point is the speed...
		int runs = 100;
		
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < runs; i++){
			Exponentiation.exp(n, m);
		}
		System.out.printf("D&C took %dms\n", System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		for(int i = 0; i < runs; i++){
			Exponentiation.expNaive(n, m);
		}
		System.out.printf("Naive took %dms\n", System.currentTimeMillis() - start);

	}
	
}
