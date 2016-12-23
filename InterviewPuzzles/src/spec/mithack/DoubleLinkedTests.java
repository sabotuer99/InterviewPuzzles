package spec.mithack;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.mithack.DoubleLinked;

public class DoubleLinkedTests {

	@Test
	public void SimpleTest(){
		DoubleLinked sut = new DoubleLinked();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.delete(2);
		
		assertEquals("3 <=> 1 <=> null", sut.toString());
	}
	
	@Test
	public void DeleteHead(){
		DoubleLinked sut = new DoubleLinked();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.delete(3);
		
		assertEquals("2 <=> 1 <=> null", sut.toString());
	}
	
	@Test
	public void DeleteTail(){
		DoubleLinked sut = new DoubleLinked();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.delete(1);
		
		assertEquals("3 <=> 2 <=> null", sut.toString());
	}
	
	
	@Test
	public void DeleteNotInList(){
		DoubleLinked sut = new DoubleLinked();
		
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.delete(4);
		
		assertEquals("3 <=> 2 <=> 1 <=> null", sut.toString());
	}
	
	
	
	@Test
	public void DeleteEmptyList(){
		DoubleLinked sut = new DoubleLinked();

		sut.delete(4);
		
		assertEquals("null", sut.toString());
	}
}
