package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.datastructures.SingleListCycle;
import puzzles.kennyyu.datastructures.SingleListCycle.SingleList;

public class SingleListCycleTests {

	@Test
	public void hasCycle_returnsTrue(){
		SingleList sut = new SingleList();
		
		sut.add(1);
		sut.add(1);
		sut.add(1);
		sut.head.next.next.next = sut.head;
		
		boolean result = SingleListCycle.hasCycle(sut);
		
		assertTrue(result);
	}
	
	@Test
	public void noCycle_returnsFalse(){
		SingleList sut = new SingleList();
		
		sut.add(1);
		sut.add(1);
		sut.add(1);
		
		boolean result = SingleListCycle.hasCycle(sut);
		
		assertFalse(result);
	}
}
