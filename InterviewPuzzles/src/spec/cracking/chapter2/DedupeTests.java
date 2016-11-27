package spec.cracking.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter2.Dedupe;
import puzzles.cracking.chapter2.DoubleLinkedList;

public class DedupeTests {
	
	@Test
	public void testDoubleLinkedList() {
		int[] vals = {1,3,6,4,89,32,56,0};
		DoubleLinkedList sut = new DoubleLinkedList(vals);
		System.out.println(sut.toString());
		assertTrue(true);
	}
	
	@Test
	public void NormalCase_WorksCorrectly() {
		int[] vals = {89,3,3,4,89,56,56,0};
		int[] expectedVals = {89,3,4,56,0};
		DoubleLinkedList sut = new DoubleLinkedList(vals);
		DoubleLinkedList expected = new DoubleLinkedList(expectedVals);
		
		Dedupe.dedupe(sut.getHead());
		
		assertEquals(expected.toString(), sut.toString());
	}

}
