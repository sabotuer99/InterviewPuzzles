package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;
import puzzles.cracking.chapter5.NextNumber;

public class NextNumberTests {

	@Test
	public void NextSmaller_Given13_Return11() {
		
		int test = BitUtils.fromBitString("1101");
		int expected = BitUtils.fromBitString("1011");
		
		int result = NextNumber.nextSmaller(test);
		
		assertEquals(expected, result);
	}

	@Test
	public void NextSmaller_Given0_Return0() {
		
		int result = NextNumber.nextSmaller(0);
		
		assertEquals(0, result);
	}

	@Test
	public void NextSmaller_Given7_ReturnHugeNegative() {
		
		int test = BitUtils.fromBitString("111");
		int expected = BitUtils.fromBitString("11100000 00000000 00000000 00000000");
		
		int result = NextNumber.nextSmaller(test);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void BookSmaller_Given7() {
		
		int test = BitUtils.fromBitString("111");
		int expected = BitUtils.fromBitString("11100000 00000000 00000000 00000000");
		
		
		
		int result = NextNumber.getPrev(test);
		
		System.out.println(BitUtils.toBitString(result));
		
		assertEquals(expected, result);
	}
	
	@Test
	public void NextSmaller_MoreComplex() {
		
		int test = BitUtils.fromBitString("1101001");
		int expected = BitUtils.fromBitString("1100101");
		System.out.println(test + " " + expected);
		
		int result = NextNumber.nextSmaller(test);
		
		assertEquals(expected, result);
	}

	@Test
	public void NextBigger_Given13_Return14() {
		
		int test = BitUtils.fromBitString("1101");
		int expected = BitUtils.fromBitString("1110");
		
		int result = NextNumber.nextBigger(test);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void NextBigger_Given7_Return11() {
		
		int test = BitUtils.fromBitString("111");
		int expected = BitUtils.fromBitString("1011");
		
		int result = NextNumber.nextBigger(test);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void NextBigger_MoreComplex() {
		
		int test = BitUtils.fromBitString("1101001");
		int expected = BitUtils.fromBitString("1101010");
		System.out.println(test + " " + expected);
		
		int result = NextNumber.nextBigger(test);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void NextBigger_BookTestCase() {
		
		int test = BitUtils.fromBitString("11100");
		int expected = BitUtils.fromBitString("100011");
		System.out.println(test + " " + expected);
		
		int result = NextNumber.nextBigger(test);
		
		assertEquals(expected, result);
	}
}
