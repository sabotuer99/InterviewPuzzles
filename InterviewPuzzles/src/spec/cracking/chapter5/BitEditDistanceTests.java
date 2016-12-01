package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitEditDistance;
import puzzles.cracking.chapter5.BitUtils;

public class BitEditDistanceTests {

	@Test
	public void BookTestCase(){
		
		int a = BitUtils.fromBitString("11101"); //29
		int b = BitUtils.fromBitString("01111"); //15		
		
		int result = BitEditDistance.bitEditDistance(a, b);
		
		assertEquals(2, result);
	}
	
	@Test
	public void GivenSameNumberTwice_ReturnZero(){
		
		int a = BitUtils.fromBitString("11101"); //29
		int b = BitUtils.fromBitString("11101"); //29		
		
		int result = BitEditDistance.bitEditDistance(a, b);
		
		assertEquals(0, result);
	}
	
	
	@Test
	public void GivenNumbersWithNoSharedBits_ReturnSumOfOnes(){
		
		int a = BitUtils.fromBitString("1011101"); 
		int b = BitUtils.fromBitString( "100010"); 		
		
		int result = BitEditDistance.bitEditDistance(a, b);
		
		assertEquals(7, result);
	}

}
