package spec.cracking.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter2.DoubleLinkedList;
import puzzles.cracking.chapter2.Node;
import puzzles.cracking.chapter2.NthToLast;

public class NthToLastTests {

	@Test
	public void Get2ndToLast_ReturnCorrectElement() {
		int[] vals = {1,3,6,4,89,32,56,0};
		int n = 2;
		DoubleLinkedList list = new DoubleLinkedList(vals);

		Node result = NthToLast.getNthFromEnd(list.getHead(), n);
		
		assertEquals(56, result.getVal());
	}
	
	@Test
	public void GetLast_ReturnCorrectElement() {
		int[] vals = {1,3,6,4,89,32,56,10};
		int n = 1;
		DoubleLinkedList list = new DoubleLinkedList(vals);

		Node result = NthToLast.getNthFromEnd(list.getHead(), n);
		
		assertEquals(10, result.getVal());
	}
	
	@Test
	public void GivenNull_ReturnNull() {
		int n = 1;

		Node result = NthToLast.getNthFromEnd(null, n);
		
		assertNull(result);
	}
	
	@Test
	public void GetNGreatThanListLength_ReturnHead() {
		int[] vals = {1,3,6,4,89,32,56,10};
		int n = 99;
		DoubleLinkedList list = new DoubleLinkedList(vals);

		Node result = NthToLast.getNthFromEnd(list.getHead(), n);
		
		assertEquals(1, result.getVal());
	}

}
