package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;

public class BitUtilsTests {

	@Test
	public void toBitStringTests(){
		
		int _one = 1;
		int _negone = -1;
		int _smallest = Integer.MIN_VALUE;
		int _smallest_s = Short.MIN_VALUE;
		int _smallest_b = Byte.MIN_VALUE;
		int _biggest  = Integer.MAX_VALUE;
		
		String one = BitUtils.toBitString(_one);
		String negone = BitUtils.toBitString(_negone);
		String smallest = BitUtils.toBitString(_smallest);
		String biggest = BitUtils.toBitString(_biggest);
		String smallest_s = BitUtils.toBitString(_smallest_s);
		String smallest_b = BitUtils.toBitString(_smallest_b);
		
		assertEquals("00000001", one);
		assertEquals("11111111", negone);
		assertEquals("10000000 00000000 00000000 00000000", smallest);
		assertEquals("01111111 11111111 11111111 11111111", biggest);
		assertEquals("10000000 00000000", smallest_s);
		assertEquals("10000000", smallest_b);
	}
	
	@Test 
	public void RightMask(){
		int one = BitUtils.rightMask(1);
		int five = BitUtils.rightMask(5);
		int seven = BitUtils.rightMask(7);
		
		String bitStr1 = BitUtils.toBitString(one);
		String bitStr2 = BitUtils.toBitString(five);
		String bitStr3 = BitUtils.toBitString(seven);
		
		assertEquals("00000001", bitStr1);
		assertEquals("00011111", bitStr2);
		assertEquals("01111111", bitStr3);
	}
	
	@Test 
	public void LeftMask(){
		int one = BitUtils.leftMask(1);
		int five = BitUtils.leftMask(5);
		int seven = BitUtils.leftMask(7);
		
		String bitStr1 = BitUtils.toBitString(one);
		String bitStr2 = BitUtils.toBitString(five);
		String bitStr3 = BitUtils.toBitString(seven);
		
		assertEquals("11111110", bitStr1);
		assertEquals("11100000", bitStr2);
		assertEquals("10000000", bitStr3);
	}
	
	@Test 
	public void AndMask(){
		int one = BitUtils.andMask(1);
		int five = BitUtils.andMask(5);
		int seven = BitUtils.andMask(7);
		
		String bitStr1 = BitUtils.toBitString(one);
		String bitStr2 = BitUtils.toBitString(five);
		String bitStr3 = BitUtils.toBitString(seven);
		
		assertEquals("11111110", bitStr1);
		assertEquals("11101111", bitStr2);
		assertEquals("10111111", bitStr3);
	}
	
	@Test 
	public void OrMask(){
		int one = BitUtils.orMask(1);
		int five = BitUtils.orMask(5);
		int seven = BitUtils.orMask(7);
		
		String bitStr1 = BitUtils.toBitString(one);
		String bitStr2 = BitUtils.toBitString(five);
		String bitStr3 = BitUtils.toBitString(seven);
		
		assertEquals("00000001", bitStr1);
		assertEquals("00010000", bitStr2);
		assertEquals("01000000", bitStr3);
	}
}
