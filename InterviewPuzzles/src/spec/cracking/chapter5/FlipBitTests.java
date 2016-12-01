package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;
import puzzles.cracking.chapter5.FlipBit;

public class FlipBitTests {

	@Test
	public void BookTestCase_MisUnderstood(){
		int testNum = BitUtils.fromBitString("11011101111");
		int expected = BitUtils.fromBitString(     "10000");
		
		int result = FlipBit.bitToWin(testNum);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void AnotherTest(){
		
		int testNum = BitUtils.fromBitString("111011111011111011");
		int expected = BitUtils.fromBitString(        "100000000");
		
		int result = FlipBit.bitToWin(testNum);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void BookTestCase(){
		int testNum = BitUtils.fromBitString("11011101111");
		
		int result = FlipBit.maxScore(testNum);
		
		assertEquals(8, result);
	}
	
	@Test
	public void AnotherTestOfScore(){
		
		int testNum = BitUtils.fromBitString("111011111011111011");
		
		int result = FlipBit.maxScore(testNum);
		
		assertEquals(11, result);
	}
}
