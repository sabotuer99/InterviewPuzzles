package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;
import puzzles.cracking.chapter5.Insertion;

public class InsertionTests {

	@Test
	public void BookTestCase(){
		int N = BitUtils.fromBitString("10000000000");
		int M = BitUtils.fromBitString("10011");
		int i = 2;
		int j = 6;
		int expected = BitUtils.fromBitString("10001001100");
		
		int result = Insertion.insert(N, M, i, j);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void EnsureOnesAreCleared(){
		int N = BitUtils.fromBitString("11111111111");
		int M = BitUtils.fromBitString("10011");
		int i = 2;
		int j = 6;
		int expected = BitUtils.fromBitString("11111001111");
		
		int result = Insertion.insert(N, M, i, j);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void MisZero_LeavesGapOfZeros(){
		int N = BitUtils.fromBitString("11111111111");
		int M = 0;
		int i = 2;
		int j = 6;
		int expected = BitUtils.fromBitString("11110000011");
		
		System.out.println("#############");
		int result = Insertion.insert(N, M, i, j);
		System.out.println("#############");
		
		assertEquals(expected, result);
	}
}
