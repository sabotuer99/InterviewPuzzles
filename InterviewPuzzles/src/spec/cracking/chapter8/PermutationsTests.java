package spec.cracking.chapter8;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter8.Permutations;

public class PermutationsTests {

	@Test
	public void AAAAAAA_returns1permutations(){
		String test = "AAAAAAA";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(1, perms.size());
	}
	
	@Test
	public void ABAAAAAA_returns8permutations(){
		String test = "ABAAAAAA";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(8, perms.size());
	}
	
	@Test
	public void ABCA_returns12permutations(){
		String test = "abca";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(12, perms.size());
	}
	
	@Test
	public void ABC_returns6permutations(){
		String test = "abc";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(6, perms.size());
	}
	
	@Test
	public void Longish_returnsLotspermutations(){
		String test = "abcdefgh";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(40320, perms.size()); // 8 chars = 8! permutations
	}
	
	@Test
	public void Null_returnsEmptyList(){
		String test = null;
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(0, perms.size());
	}
	
	@Test
	public void EmptyString_returnsListWithEmptyString(){
		String test = "";
		
		List<String> perms = Permutations.permutations(test);
		
		assertEquals(1, perms.size());
		assertEquals("", perms.get(0));
	}
	
}
