package spec.mithack;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.mithack.Substring;

public class SubstringTests {

	@Test
	public void KMP_StokesExample_Prefix(){
		String pattern = "cocacola";
		
		int[] result = Substring.kmpPrefix(pattern);
		
		//System.out.println();
		assertEquals("[0, 0, 1, 0, 1, 2, 0, 0]", Arrays.toString(result));
	}
	
	@Test
	public void KMP_TusharExample_Prefix(){
		String pattern = "acacabacacabacacac";
		
		int[] result = Substring.kmpPrefix(pattern);
		
		assertEquals("[0, 0, 1, 2, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 4]", 
				Arrays.toString(result));
	}
	
	@Test
	public void KMP_StokesExample_Match(){
		String text = "cozacocacolacocococacola";
		String pattern = "cocacola";
		
		int result = Substring.findMatchesKMP(pattern, text);
		
		assertEquals(2, result);
	}
	
	@Test
	public void KMP_TusharExample(){
		String text = "abcxabcdabxabcdabcdabcy";
		String pattern = "abcdabcy";
		
		int result = Substring.findMatchesKMP(pattern, text);
		
		assertEquals(1, result);
	}

	@Test
	public void Naive_TusharExample(){
		String text = "abcxabcdabxabcdabcdabcy";
		String pattern = "abcdabcy";
		
		int result = Substring.findMatchesNaive(pattern, text);
		
		assertEquals(1, result);
	}
}
