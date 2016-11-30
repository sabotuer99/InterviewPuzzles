package spec.cracking.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter2.ListAdder;
import puzzles.cracking.chapter2.Node;
import puzzles.cracking.chapter2.SingleLinkedList;

public class ListAdderTests {

	@Test
	public void BookTestCase_Returns808() {
		int[] avals = {3,1,5};
		int[] bvals = {5,9,2};
		int[] exvals = {8,0,8};
		Node a = new SingleLinkedList(avals).getHead();
		Node b = new SingleLinkedList(bvals).getHead();
		Node expected = new SingleLinkedList(exvals).getHead();
		
		Node result = ListAdder.addLists(a, b);
		
		assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	public void GivenLotsOfTail9s_CarriesProperly() {
		int[] avals = {3,1,9,9,9};
		int[] bvals = {5,9,2};
		int[] exvals = {8,0,2,0,0,1};
		Node a = new SingleLinkedList(avals).getHead();
		Node b = new SingleLinkedList(bvals).getHead();
		Node expected = new SingleLinkedList(exvals).getHead();
		
		Node result = ListAdder.addLists(a, b);
		
		assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	public void GivenOneNullNode_GetOtherNodeBack() {
		int[] avals = {3,1,9,9,9};
		int[] exvals = {3,1,9,9,9};
		Node a = new SingleLinkedList(avals).getHead();
		Node expected = new SingleLinkedList(exvals).getHead();
		
		Node result = ListAdder.addLists(a, null);
		
		assertEquals(expected.toString(), result.toString());
	}


}
