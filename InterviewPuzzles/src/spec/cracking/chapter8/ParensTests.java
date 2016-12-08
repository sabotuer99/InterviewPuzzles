package spec.cracking.chapter8;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import puzzles.cracking.chapter8.Parens;

public class ParensTests {

	@Test
	public void Parens_BookTestCase(){
		int n = 3;
		Set<String> parens = Parens.parens(n);
		
		assertEquals(5, parens.size());
	}
	
	@Test
	public void ParensBiggerCase(){
		int n = 6;
		Set<String> parens = Parens.parens(n);
		
		assertEquals(132, parens.size());  //sixth catalan number
	}
	
	@Test
	public void ParensEvenBiggerCase(){
		int n = 12;
		Set<String> parens = Parens.parens(n);
		
		assertEquals(208012, parens.size());  //12th catalan number
	}
}
