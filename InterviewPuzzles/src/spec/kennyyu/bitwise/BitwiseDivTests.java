package spec.kennyyu.bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.bitwise.BitwiseDiv;

public class BitwiseDivTests {

	@Test
	public void multiTest1(){
		int a = 7;
		int b = 2;
		
		int result = BitwiseDiv.mult(a, b);
		
		assertEquals(14, result);
	}
	
	@Test
	public void multiTest2(){
		int a = 5;
		int b = 10;
		
		int result = BitwiseDiv.mult(a, b);
		
		assertEquals(50, result);
	}
	
	@Test
	public void multiTest3(){
		int a = 8;
		int b = 16;
		
		int result = BitwiseDiv.mult(a, b);
		
		assertEquals(128, result);
	}
	
	@Test
	public void divTest1(){
		int a = 7;
		int b = 2;
		
		int result = BitwiseDiv.div(a, b);
		
		assertEquals(3, result);
	}
	
	@Test
	public void divTest2(){
		int a = 50;
		int b = 10;
		
		int result = BitwiseDiv.div(a, b);
		
		assertEquals(5, result);
	}
	
	@Test
	public void divTest3(){
		int a = 256;
		int b = 2;
		
		int result = BitwiseDiv.div(a, b);
		
		assertEquals(128, result);
	}
	
	@Test
	public void divTest4(){
		int a = 138956;
		int b = 2568;
		
		int result = BitwiseDiv.div(a, b);
		
		assertEquals(54, result);
	}
	
	/*
	@Test
	public void hst(){
		int r1 = BitwiseDiv.hsb(1 << 31);
		int r2 = BitwiseDiv.hsb(1 << 15);
		//int r3 = BitwiseDiv.hsb(-1);
		
		assertEquals(31, r1);
		assertEquals(15, r2);
		//assertEquals(32, r3);
	}

	
	@Test
	public void hstRace(){
		
		runHsb();
		runHsbSimp();
		runHsb();
		runHsbSimp();
		runHsb();
		runHsbSimp();
	}
	
	private void runHsb(){
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++){
			BitwiseDiv.hsb(1 << 31);
		}
		System.out.printf("Binary Search hsb finished in %dms\n", System.currentTimeMillis() - start);
	}
	
	private void runHsbSimp(){
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++){
			BitwiseDiv.hsbSimp(1 << 31);
		}
		System.out.printf("Simple loop hsb finished in %dms\n", System.currentTimeMillis() - start);
	}
	*/
	
}
