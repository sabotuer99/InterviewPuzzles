package spec.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.misc.SubPermutations;

public class SubPermutationsTests {

	@Test
	public void updateHash(){
		int a1 = SubPermutations.alphaHash("a");
		int a2 = SubPermutations.alphaHash("a");
		
		int b1 = SubPermutations.updateHash(a1, 'a', 'b');
		int b2 = SubPermutations.alphaHash("b");
		
		assertEquals(a1, a2);
		assertEquals(b1, b2);
	}
	
	@Test
	public void BasicTest(){
		String pattern = "abba";
		String text = "bbaacccccababcccccabababa";
		
		int count = SubPermutations.subPermutations(pattern, text);
		
		assertEquals(6, count);
	}
	
	@Test
	public void falsePositives(){
		String pattern = "abba";
		String text = "bbbacccccaaabcccccabababa";
		
		int count = SubPermutations.subPermutations(pattern, text);
		
		assertEquals(4, count);
	}
	
	
	@Test
	public void DoubleTest(){
		double hash = Long.MAX_VALUE;
		hash *= 4;
		System.out.println(hash);
	}
}
