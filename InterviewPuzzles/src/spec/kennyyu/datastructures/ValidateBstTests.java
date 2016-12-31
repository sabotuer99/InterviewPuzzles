package spec.kennyyu.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.datastructures.ValidateBst;
import puzzles.kennyyu.datastructures.ValidateBst.Node;

public class ValidateBstTests {

	@Test
	public void nullNode_IsValid(){
		Node sut = null;
		
		boolean result = ValidateBst.isBst(sut);
		
		assertTrue(result);
	}
	
	@Test
	public void singleNode_IsValid(){
		Node sut = new Node(1);
		
		boolean result = ValidateBst.isBst(sut);
		
		assertTrue(result);
	}
	
	@Test
	public void smallBst_IsValid(){
		Node sut = new Node(2);
		sut.left = new Node(1);
		sut.right = new Node(3);
		
		
		boolean result = ValidateBst.isBst(sut);
		
		assertTrue(result);
	}
	
	@Test
	public void smallBadBst_IsNotValid(){
		Node sut = new Node(2);
		sut.left = new Node(3);
		sut.right = new Node(1);
		
		
		boolean result = ValidateBst.isBst(sut);
		
		assertFalse(result);
	}
	
}
