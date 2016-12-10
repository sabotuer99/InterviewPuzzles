package spec.cracking.chapter10;

import org.junit.Test;

import puzzles.cracking.chapter10.PrintDupes;

public class PrintDupesTests {

	@Test
	public void SimpleTest(){
		int[] input = {9, 8, 7, 7, 7, 1, 2, 3, 6, 5, 4, 4};
		
		PrintDupes.printDupesBit(input);
	}
	
	@Test
	public void BigTest(){
		int[] input = new int[32005];
		
		for(int i = 0; i < 32000; i++){
			input[i] = i + 1;
		}
		input[32000] = 1;
		input[32001] = 3;
		input[32002] = 3;
		input[32003] = 7;
		input[32004] = 32000; 
		
		PrintDupes.printDupesBit(input);
	}
	
}
