package spec.cracking.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter2.CycleStart;
import puzzles.cracking.chapter2.Node;
import puzzles.cracking.chapter2.SingleLinkedList;

public class CycleStartTests {

	@Test
	public void BookTestCase_ReturnsNodeC() {
		int[] avals = {1,2,3,4,5};
		Node a = new SingleLinkedList(avals).getHead();
		// B    C    D    E             B    C
		a.next.next.next.next.next = a.next.next;
		
		Node result = CycleStart.getCycleStart(a);
		Node expected = a.next.next;
		
		assertEquals(expected.getId(), result.getId());
	}
	
	@Test
	public void SingleNodeSelfCycle_ReturnsNode() {
		int[] avals = {1};
		Node a = new SingleLinkedList(avals).getHead();
		a.next = a;
		
		Node result = CycleStart.getCycleStart(a);
		Node expected = a;
		
		assertEquals(expected.getId(), result.getId());
	}
	
	@Test
	public void NoCycle_ReturnsNull() {
		int[] avals = {1,2,3,4,5};
		Node a = new SingleLinkedList(avals).getHead();
		
		Node result = CycleStart.getCycleStart(a);
		
		assertNull(result);
	}

}
