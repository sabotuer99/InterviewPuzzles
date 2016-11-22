package spec.sonmez.bithackdecbin;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.sonmez.bithackdecbin.DecToBin;

public class DecToBinTests {

	@Test
	public void Given2_Get10() {
		int num = 2;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("10", binary);
	}
	
	@Test
	public void Given3_Get11() {
		int num = 3;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("11", binary);
	}
	
	@Test
	public void GivenNeg3_GetRightAnswer() {
		int num = -3;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("11111111111111111111111111111101", binary);
	}
	
	@Test
	public void GivenMAX_GetRightAnswer() {
		int num = Integer.MAX_VALUE;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("1111111111111111111111111111111", binary);
	}
	
	@Test
	public void GivenMIN_GetRightAnswer() {
		int num = Integer.MIN_VALUE;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("10000000000000000000000000000000", binary);
	}
	
	@Test
	public void GivenZero_GetZero() {
		int num = 0;
		
		String binary = DecToBin.convert(num);
		
		assertEquals("0", binary);
	}

}
