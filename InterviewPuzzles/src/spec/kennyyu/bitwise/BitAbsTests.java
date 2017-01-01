package spec.kennyyu.bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.bitwise.BitAbs;

public class BitAbsTests {

	@Test
	public void simpleTest(){
		int x = 3;
		int y = 17;
		
		int result1 = BitAbs.absDiff(x, y);
		int result2 = BitAbs.absDiff(y, x);
		
		assertEquals(14, result1);
		assertEquals(14, result2);
	}
}
