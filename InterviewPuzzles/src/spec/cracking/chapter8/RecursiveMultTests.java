package spec.cracking.chapter8;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import puzzles.cracking.chapter8.RecursiveMult;

public class RecursiveMultTests {

	@Test
	public void bitMult_correctAnswers(){
		int result1 = RecursiveMult.multiply(250, 4);
		
		assertEquals(1000, result1);
	}
	
	@Test
	public void naive_correctAnswers(){
		int result1 = RecursiveMult.naive(250, 4);
		
		assertEquals(1000, result1);
	}
	
	@Ignore
	@Test
	public void naive_breakIt(){
		
		int sqrt = (int) Math.sqrt(Integer.MAX_VALUE);
		int i = 0;
		try{
			for(; i <= sqrt; i++){
				RecursiveMult.naive(i, i);
			}
		} catch(StackOverflowError ex){  //Dies after about 41000 iterations on my machine...
			System.out.printf("Died after %d iterations of %d.", i, sqrt);
		}

	}
	
	@Test
	public void race(){
		long time = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			RecursiveMult.multiply(10000, 10000);
		}
		System.out.printf("Bit multiply took %dms.\n", System.currentTimeMillis() - time);
		
		time = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			RecursiveMult.naive(10000, 10000);
		}
		System.out.printf("Naive took %dms.\n", System.currentTimeMillis() - time);
	}
}
