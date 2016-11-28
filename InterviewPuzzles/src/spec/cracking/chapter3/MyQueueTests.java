package spec.cracking.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter3.MyQueue;

public class MyQueueTests {

	@Test
	public void ConfirmFIFO() {
		MyQueue sut = new MyQueue();
		sut.enqueue(1);
		sut.enqueue(2);
		sut.enqueue(3);
		
		assertEquals(1, sut.poll());
		assertEquals(2, sut.poll());
		assertEquals(3, sut.poll());
	}

}
