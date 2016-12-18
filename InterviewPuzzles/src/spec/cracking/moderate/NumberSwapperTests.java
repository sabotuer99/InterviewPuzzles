package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.NumberSwapper;

public class NumberSwapperTests {
	
	@Test
	public void NumberSwapper(){
		int x = 1;
		int y = 8;
		int result = NumberSwapper.swap(x,y);
		assertEquals(result, y);
	}

}
