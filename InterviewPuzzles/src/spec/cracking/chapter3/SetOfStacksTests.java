package spec.cracking.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter3.SetOfStacks;

public class SetOfStacksTests {

	@Test
	public void SanityTest() {
		SetOfStacks sut = new SetOfStacks(5);
		for(int i = 10; i > 0; i--){
			sut.push(i);
		}
		int result = sut.pop();
		
		assertEquals(1, result);
	}
	
	@Test
	public void DrainMiddleStack_PopRest_CorrectResult() {
		SetOfStacks sut = new SetOfStacks(5);
		for(int i = 0; i < 15; i++){
			sut.push(2);
		}
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for(int i = 0; i < 5; i++){
			sum1 += sut.popAt(0);
			sum2 += sut.popAt(1);
			sum3 += sut.popAt(2);
		}
		
		assertEquals(10, sum1);
		assertEquals(10, sum2);
		assertEquals(10, sum3);
	}
	
	@Test
	public void DrainStack_CorrectResult() {
		SetOfStacks sut = new SetOfStacks(5);
		for(int i = 0; i < 15; i++){
			sut.push(2);
		}
		
		int sum1 = 0;
		for(int i = 0; i < 15; i++){
			sum1 += sut.pop();
		}
		
		assertEquals(30, sum1);
	}

}
