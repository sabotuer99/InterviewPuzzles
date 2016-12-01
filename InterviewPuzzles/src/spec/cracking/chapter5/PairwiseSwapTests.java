package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;
import puzzles.cracking.chapter5.PairwiseSwap;

public class PairwiseSwapTests {

	@Test
	public void SwapBits() {
		int n = BitUtils.fromBitString("110010110");
		int expected = BitUtils.fromBitString("1001101001");
		
		int result = PairwiseSwap.swapBits(n);
		
		System.out.println(BitUtils.toBitString(result));
		System.out.println(BitUtils.toBitString(expected));
		
		assertEquals(expected, result);
	}

}
