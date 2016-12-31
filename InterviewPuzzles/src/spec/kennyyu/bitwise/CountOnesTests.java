package spec.kennyyu.bitwise;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.kennyyu.bitwise.CountOnes;

public class CountOnesTests {


	@Test
	public void countOnes_lowAndHighCount(){
		int c1 = CountOnes.countOnes(-1);
		int c2 = CountOnes.countOnes(0);
		
		assertEquals(32, c1);
		assertEquals(0, c2);
	}
	
	@Test
	public void countOnes_minAndMaxValueCount(){
		int c1 = CountOnes.countOnes(Integer.MAX_VALUE);
		int c2 = CountOnes.countOnes(Integer.MIN_VALUE);
		
		assertEquals(31, c1);
		assertEquals(1, c2);
	}
	
	@Test
	public void countOnes_PowersOf2(){
		int c1 = CountOnes.countOnes(2);
		int c2 = CountOnes.countOnes(1 << 12);
		int c3 = CountOnes.countOnes(1 << 22);
		int c4 = CountOnes.countOnes(1 << 29);
		
		assertEquals(1, c1);
		assertEquals(1, c2);
		assertEquals(1, c3);
		assertEquals(1, c4);
	}
	
	@Test
	public void countOnes_Race(){
		
		raceTable(-1);
		raceNaive(-1);
		
		raceTable(1 << 12);
		raceNaive(1 << 12);
		
		raceTable(4);
		raceNaive(4);
	}
	
	private void raceTable(int n){
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++){
			CountOnes.countOnes(n);
		}
		System.out.println("Table lookup      : " + (System.currentTimeMillis() - start) + "ms");
	}
	
	private void raceNaive(int n){
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++){
			CountOnes.countOnesNaive(n);
		}
		System.out.println("Naive Calculation : " + (System.currentTimeMillis() - start) + "ms");
	}
	
	
	
	@Test
	public void generateTable(){
		int[] table = new int[256];
		for(int i = 0; i < 256; i++ ){
			int count = 0; 
			int num = i;
			for(int j = 0; j < 8; j++){
				count += num & 1;
				num >>= 1;
			}
			table[i] = count;
		}
		
		System.out.println(Arrays.toString(table).replaceAll("\\[", "{").replaceAll("\\]", "}"));
	}

}
