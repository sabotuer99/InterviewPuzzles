package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.datastructures.DoubleLinkedList;

public class DoubleLinkedListTests {

	@Test
	public void Push(){
		DoubleLinkedList<Integer> sut = new DoubleLinkedList<>();
		
		sut.push(3);
		sut.push(2);
		sut.push(1);
		

		assertEquals(3, sut.size);
		assertEquals("{ 1 <=> 2 <=> 3 }", sut.toString());
	}
	
	@Test
	public void Append(){
		DoubleLinkedList<Integer> sut = new DoubleLinkedList<>();
		
		sut.append(3);
		sut.append(2);
		sut.append(1);
		

		assertEquals(3, sut.size);
		assertEquals("{ 3 <=> 2 <=> 1 }", sut.toString());
	}
	
	@Test
	public void Insert(){
		DoubleLinkedList<Integer> sut = new DoubleLinkedList<>();
		
		sut.push(1);
		sut.push(1);
		sut.push(1);
		sut.insert(1, 4);
		

		assertEquals(4, sut.size);
		assertEquals("{ 1 <=> 4 <=> 1 <=> 1 }", sut.toString());
	}
	
	@Test
	public void PopHead(){
		DoubleLinkedList<Integer> sut = new DoubleLinkedList<>();
		
		sut.push(3);
		sut.push(2);
		sut.push(1);
		int result = sut.popHead();
		
		assertEquals(1, result);
		assertEquals(2, sut.size);
		assertEquals("{ 2 <=> 3 }", sut.toString());
	}
	
	
	@Test
	public void PopTail(){
		DoubleLinkedList<Integer> sut = new DoubleLinkedList<>();
		
		sut.push(3);
		sut.push(2);
		sut.push(1);
		int result = sut.popTail();
		
		assertEquals(3, result);
		assertEquals(2, sut.size);
		assertEquals("{ 1 <=> 2 }", sut.toString());
	}
}
