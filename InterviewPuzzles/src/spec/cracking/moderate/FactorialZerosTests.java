package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Ignore;
import org.junit.Test;

import puzzles.cracking.moderate.FactorialZeros;

public class FactorialZerosTests {

	private int countTrailingZeros(String num){
		int count = 0; 
		for(int i = num.length() - 1; num.charAt(i) == '0'; i--){
			count++;
		}
		return count;
	}
	
	private BigInteger factorial(int n){
		BigInteger result = BigInteger.valueOf(1);
		int zeros = 0;
		for(int i = 2; i <= n; i++){
			result = result.multiply(BigInteger.valueOf(i));
			int newzeros = countTrailingZeros(result.toString());
			if(newzeros > zeros){
				System.out.println(i + ": " + newzeros + " zeros");
			}
			zeros = newzeros;
		}
		
		return result;
	}
	
	@Test
	public void Factorials(){
//		for(int i = 10; i <= 100; i += 10){
//			BigInteger n = factorial(i);
//			System.out.println(i + ": " + n.toString());
//		}
		factorial(125);
	}
	
	@Test
	public void CountZeros_0fact(){
		int n = 0; 
		
		int zeros = FactorialZeros.factorialTailZeros(n);
		
		assertEquals(0, zeros);
				
	}
	
	
	@Test
	public void CountZeros_9fact(){
		int n = 9; 
		
		int zeros = FactorialZeros.factorialTailZeros(n);
		
		assertEquals(1, zeros);
				
	}
	
	@Test
	public void CountZeros_100fact(){
		int n = 100; 
		
		int zeros = FactorialZeros.factorialTailZeros(n);
		
		assertEquals(24, zeros);
				
	}
	
	@Test
	public void CountZeros_125fact(){
		int n = 125; 
		
		int zeros = FactorialZeros.factorialTailZeros(n);
		
		assertEquals(31, zeros);
				
	}
	
	
}
