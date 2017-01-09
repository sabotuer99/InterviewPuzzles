package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.moderate.SumSwap;

public class SumSwapTests {

	@Test
	public void BookTestCase(){
		int[] a = {4,1,2,1,1,2};
		int[] b = {3,6,3,3};
		
		int[] result = SumSwap.sumSwap(a, b);
		
		int sumA = sum(a);
		int sumB = sum(b);
		
		sumA += b[result[1]] - a[result[0]];
		sumB += a[result[0]] - b[result[1]];
			
		assertEquals(2, result.length);
		assertEquals(sumA, sumB);
	}
	
	@Test
	public void BigTestCase(){
		int[] a = {3,6,54,67,9,8,23,12,11,4,10,9,13,12,15,19,7}; 
		int[] b = {6,7,43,5,6,7,22,23,26,45,78};  
		
		int[] result = SumSwap.sumSwap(a, b);
		
		int sumA = sum(a); //282
		int sumB = sum(b); //268
		
		sumA += b[result[1]] - a[result[0]];
		sumB += a[result[0]] - b[result[1]];
			
		assertEquals(2, result.length);
		assertEquals(sumA, sumB);
	}
	
	private int sum(int[] arr){
		int sum = 0;
		for(int n : arr){
			sum += n;
		}
		return sum;
	}
}
