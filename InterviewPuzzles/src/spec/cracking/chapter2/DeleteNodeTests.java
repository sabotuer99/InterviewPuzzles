package spec.cracking.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter2.DeleteNode;
import puzzles.cracking.chapter2.SingleLinkedList;
import puzzles.cracking.chapter2.Node;

public class DeleteNodeTests {

	@Test
	public void DeleteFifthNode_ReturnCorrectElement() {
		int[] vals = {1,3,6,4,89,32,56,0};
		int[] evals = {1,3,6,4,32,56,0};
		SingleLinkedList list = new SingleLinkedList(vals);
		SingleLinkedList expected = new SingleLinkedList(evals);
		Node dnode = list.getHead().next.next.next.next;
		
		DeleteNode.deleteNode(dnode);
		
		assertEquals(expected.toString(), list.toString());
	}
	
	@Test
	public void DeleteHead_ReturnCorrectElement() {
		int[] vals = {1,3,6,4,89,32,56,0};
		int[] evals = {3,6,4,89,32,56,0};
		SingleLinkedList list = new SingleLinkedList(vals);
		SingleLinkedList expected = new SingleLinkedList(evals);
		Node dnode = list.getHead();
		
		DeleteNode.deleteNode(dnode);
		
		assertEquals(expected.toString(), list.toString());
	}
	
	@Test
	public void DeleteTail_DoNothing() {
		int[] vals = {1,3,6,4,89,32,56,0};
		int[] evals = {1,3,6,4,89,32,56,0};
		SingleLinkedList list = new SingleLinkedList(vals);
		SingleLinkedList expected = new SingleLinkedList(evals);
		Node dnode = list.getHead().next.next.next.next.next.next.next;
		
		DeleteNode.deleteNode(dnode);
		
		assertEquals(expected.toString(), list.toString());
	}
	
	@Test
	public void GivenNull_DoNothing() {
		int[] vals = {1,3,6,4,89,32,56,0};
		int[] evals = {1,3,6,4,89,32,56,0};
		SingleLinkedList list = new SingleLinkedList(vals);
		SingleLinkedList expected = new SingleLinkedList(evals);
		
		DeleteNode.deleteNode(null);
		
		assertEquals(expected.toString(), list.toString());
	}

}
