package spec.cracking.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter3.MinStack;

public class MinStackTests {

	@Test
	public void SanityCheck() {
		MinStack sut = new MinStack();
		sut.push(1);
		
		int min = sut.min();
		int result = sut.pop();
		
		assertEquals(1, min);
		assertEquals(1, result);
	}
	
	@Test
	public void ForceGrowAndShrink_PreservesValues() {
		MinStack sut = new MinStack();
		
		for(int i = 0; i < 100; i++){
			sut.push(1);
		}
		
		int total = 0;
		
		for(int i = 0; i < 100; i++){
			total += sut.pop();
		}
		
		assertEquals(100, total);
	}
	
	@Test
	public void PopMin_PreviousMinReturnedNext() {
		MinStack sut = new MinStack();
		
		sut.push(2);
		sut.push(3);
		sut.push(4);
		sut.push(5);
		sut.push(1);
		
		int min1 = sut.min();
		sut.pop();
		
		int min2 = sut.min();

		
		assertEquals(1, min1);
		assertEquals(2, min2);
	}

}
