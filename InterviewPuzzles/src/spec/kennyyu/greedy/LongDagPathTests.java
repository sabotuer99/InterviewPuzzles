package spec.kennyyu.greedy;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.greedy.LongDagPath.Graph;

public class LongDagPathTests {

	@Test
	public void SimpleTest(){
		Graph sut = new Graph();
		sut.addEdge(0, 1, 1);
		sut.addEdge(1, 2, 1);
		
		int longest = sut.longestPath();
		
		assertEquals(2, longest);
	}
	
	@Test
	public void BiggerTest(){
		Graph sut = new Graph();
		sut.addEdge(0, 1, 1);
		sut.addEdge(1, 2, 3);
		sut.addEdge(1, 3, 2);
		sut.addEdge(2, 4, 4);
		sut.addEdge(3, 4, 1);
		sut.addEdge(4, 5, 4);
		sut.addEdge(4, 6, 3);
		
		int longest = sut.longestPath();
		
		assertEquals(12, longest);
	}
	
	@Test
	public void TusharTest(){
		Graph sut = new Graph();
		sut.addEdge(0, 2, 1);
		sut.addEdge(1, 2, 1);
		sut.addEdge(1, 4, 1);
		sut.addEdge(2, 3, 1);
		sut.addEdge(3, 5, 1);
		sut.addEdge(4, 5, 1);
		sut.addEdge(5, 6, 1);
		
		int longest = sut.longestPath();
		
		assertEquals(4, longest);
	}
	
	@Test
	public void CLRSTest(){
		Graph sut = new Graph();
		sut.addEdge(0, 3, 1); // 0 undershorts
		sut.addEdge(0, 4, 1); // 1 socks
		sut.addEdge(1, 4, 1); // 2 watch
		sut.addEdge(2, 2, 1); // 3 pants
		sut.addEdge(3, 4, 1); // 4 shoes
		sut.addEdge(3, 5, 1); // 5 belt
		sut.addEdge(5, 8, 1); // 6 shirt
		sut.addEdge(6, 5, 1); // 7 tie
		sut.addEdge(6, 7, 1); // 8 jacket
		sut.addEdge(7, 8, 1);
		
		int longest = sut.longestPath();
		
		assertEquals(3, longest);
	}
	
	@Test
	public void EmptyGraphTest(){
		Graph sut = new Graph();
		
		int longest = sut.longestPath();
		
		assertEquals(0, longest);
	}
}
