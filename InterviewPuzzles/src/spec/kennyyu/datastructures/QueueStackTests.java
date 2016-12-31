package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.datastructures.QueueStack;

public class QueueStackTests {

	@Test
	public void BasicTest(){
		QueueStack sut = new QueueStack();
		sut.push(1);
		sut.push(2);
		sut.push(3);
		
		int peek = sut.peek();
		int pop = sut.pop();
		int size = sut.size();
		
		assertEquals(3, peek);
		assertEquals(3, pop);
		assertEquals(2, size);
	}
}
