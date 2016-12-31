package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.datastructures.ReverseList;
import puzzles.kennyyu.datastructures.ReverseList.SingleList;

public class ReverseListTests {

	@Test
	public void singleList_toString(){
		SingleList sut = new SingleList();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		
		assertEquals("{ 3 => 2 => 1 }", sut.toString());
	}
	
	@Test
	public void reverseSingleList(){
		SingleList sut = new SingleList();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		
		ReverseList.reverse(sut);
		
		assertEquals("{ 1 => 2 => 3 }", sut.toString());
		
	}
	
}
