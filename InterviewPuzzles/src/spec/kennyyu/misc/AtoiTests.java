package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.Atoi;

public class AtoiTests {

	@Test
	public void Atoi_BasicTest_NegativeNum(){
		String a = "-4128";
		
		int result = Atoi.atoi(a);
		
		assertEquals(-4128, result);
	}
	
	@Test
	public void Atoi_BasicTest_PositiveNum(){
		String a = "4128";
		
		int result = Atoi.atoi(a);
		
		assertEquals(4128, result);
	}
	
	@Test
	public void Atoi_BasicTest_Null(){
		String a = null;
		
		int result = Atoi.atoi(a);
		
		assertEquals(0, result);
	}
}
