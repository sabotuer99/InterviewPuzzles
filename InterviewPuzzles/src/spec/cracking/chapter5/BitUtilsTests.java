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
	
	@Test 
	public void GetBit_11(){
		// 11 = 00001011
		int[] expected = {0,0,0,0,1,0,1,1}; 
		int[] bits = new int[8];
		for(int i = 0; i < 8; i++){
			bits[i] = BitUtils.getBit(11,i+1);
		}
		
		for(int i = 0; i < 8; i++){
			assertEquals("Bit " + (i+1) + ": ", expected[i], bits[7-i]);
		}		
	}
	
	@Test 
	public void GetBit_Minus1(){
		// -1 = 11111111
		int[] expected = {1,1,1,1,1,1,1,1}; 
		int[] bits = new int[8];
		for(int i = 0; i < 8; i++){
			bits[i] = BitUtils.getBit(-1,i+1);
		}
		
		for(int i = 0; i < 8; i++){
			assertEquals("Bit " + (i+1) + ": ", expected[i], bits[7-i]);
		}
	}
	
	
	@Test 
	public void ClearBit(){
		// 127 = 01111111
		int cb1 = BitUtils.clearBit(127, 3);
		int cb2 = BitUtils.clearBit(127, 5);
		int cb3 = BitUtils.clearBit(127, 8);
		
		assertEquals("01111011", BitUtils.toBitString(cb1));
		assertEquals("01101111", BitUtils.toBitString(cb2));
		assertEquals("01111111", BitUtils.toBitString(cb3));
	}
	
	@Test 
	public void UpdateBit(){
		// 127 = 01111111
		// 1   = 00000001 
		int ub1 = BitUtils.updateBit(127, 3, 0);
		int ub2 = BitUtils.updateBit(127, 8, 1);
		int ub3 = BitUtils.updateBit(127, 3, 1);
		int ub4 = BitUtils.updateBit(127, 8, 0);
		int ub5 = BitUtils.updateBit(1, 3, 0);
		int ub6 = BitUtils.updateBit(1, 8, 1);
		int ub7 = BitUtils.updateBit(1, 3, 1);
		int ub8 = BitUtils.updateBit(1, 8, 0);
		
		assertEquals("01111011", BitUtils.toBitString(ub1));
		assertEquals("00000000 11111111", BitUtils.toBitString(ub2));
		assertEquals("01111111", BitUtils.toBitString(ub3));
		assertEquals("01111111", BitUtils.toBitString(ub4));
		assertEquals("00000001", BitUtils.toBitString(ub5));
		assertEquals("00000000 10000001", BitUtils.toBitString(ub6));
		assertEquals("00000101", BitUtils.toBitString(ub7));
		assertEquals("00000001", BitUtils.toBitString(ub8));
	}
}
