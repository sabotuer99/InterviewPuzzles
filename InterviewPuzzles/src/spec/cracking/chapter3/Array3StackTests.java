package spec.cracking.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter3.Array3Stack;

public class Array3StackTests {

	@Test
	public void SanityCheck() {
		Array3Stack sut = new Array3Stack();
		sut.a.push(1);
		sut.a.push(2);
		
		String expectedA = "1 => 2";
		String expectedB = "empty";
		String expectedC = "empty";
		
		assertEquals(expectedA, sut.a.toString());
		assertEquals(expectedB, sut.b.toString());
		assertEquals(expectedC, sut.c.toString());
		
		//System.out.println(sut.toString());
	}
	
	@Test
	public void GivenLotsOfPushesToMultipleSubstacks_NoBadBehavior() {
		Array3Stack sut = new Array3Stack();
		
		for(int i = 0; i < 12; i ++){
			sut.a.push(i + 1);
			sut.b.push(12 - i);
		}

		
		String expectedA = "1 => 2 => 3 => 4 => 5 => 6 => 7 => 8 => 9 => 10 => 11 => 12";
		String expectedB = "12 => 11 => 10 => 9 => 8 => 7 => 6 => 5 => 4 => 3 => 2 => 1";
		String expectedC = "empty";
		
		assertEquals(expectedA, sut.a.toString());
		assertEquals(expectedB, sut.b.toString());
		assertEquals(expectedC, sut.c.toString());
		
		//System.out.println(sut.toString());
	}
	
	@Test
	public void GivenEqualNumberOfPushAndPopToAllSubStacks_AllEmpty() {
		Array3Stack sut = new Array3Stack();
		
		for(int i = 0; i < 12; i ++){
			sut.a.push(i);
			sut.b.push(i);
			sut.c.push(i);
		}
		
		for(int i = 0; i < 12; i ++){
			sut.a.pop();
			sut.b.pop();
			sut.c.pop();
		}

		
		String expectedA = "empty";
		String expectedB = "empty";
		String expectedC = "empty";
		
		assertEquals(expectedA, sut.a.toString());
		assertEquals(expectedB, sut.b.toString());
		assertEquals(expectedC, sut.c.toString());
		
		//System.out.println(sut.toString());
	}
	
	@Test
	public void PopingStackYieldsCorrectValues() {
		Array3Stack sut = new Array3Stack();
		
		for(int i = 0; i < 12; i ++){
			sut.a.push(1);
			sut.b.push(2);
			sut.c.push(3);
		}
		
		int atot = 0;
		int btot = 0;
		int ctot = 0;
		
		for(int i = 0; i < 12; i ++){
			atot += sut.a.pop();
			btot += sut.b.pop();
			ctot += sut.c.pop();
		}
		
		assertEquals(12, atot);
		assertEquals(24, btot);
		assertEquals(36, ctot);
	}
	
	@Test(expected=RuntimeException.class)
	public void PopEmptyStack_ThrowRuntimeException() {
		Array3Stack sut = new Array3Stack();
		
		sut.a.pop();
	}

}
