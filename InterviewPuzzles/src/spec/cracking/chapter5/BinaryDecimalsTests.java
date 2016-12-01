package spec.cracking.chapter5;

import org.junit.Test;

import puzzles.cracking.chapter5.BinaryDecimals;

public class BinaryDecimalsTests {

	@Test
	public void BookTestCase(){
		double num = 0.72;
		
		String bitString = BinaryDecimals.getBits2(num);
		
		System.out.println(bitString);
	}
	
	@Test
	public void EasyConversion(){
		double num = 0.75;
		
		String bitString = BinaryDecimals.getBits2(num);
		
		System.out.println(bitString);
	}
	
}
