package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import puzzles.cracking.chapter10.MissingInt;
import puzzles.cracking.chapter10.MissingInt.BigFile;

public class MissingIntTests {

	@Test
	public void SmallTest(){
		
		BigFile test = new MissingInt.BigFile(42);
		
		int result = MissingInt.getNewInt(test, 10000000);
		
		System.out.println(result);
		assertEquals(686227456, result);
	}
	
	@Test
	public void ConfirmResultNotProducedByRandomGenerator(){
		
		BigFile test = new MissingInt.BigFile(42);
		int fileSize = 100000000;
		
		int result = MissingInt.getNewInt(test, fileSize);
		
		boolean found = false;
		test.resetCursor();
		for(int i = 0; i < fileSize; i++){
			int val = test.nextInt();
			found = found || val == result;
		}
		
		assertFalse(found);
	}
	
	@Ignore //this test takes ~60 seconds
	@Test
	public void BigTest(){
		
		BigFile test = new MissingInt.BigFile(42);
		
		int result = MissingInt.getNewInt(test, Integer.MAX_VALUE);
		
		System.out.println(result);
		//assertEquals(686227456, result);
	}
	
}
