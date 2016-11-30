package spec.cracking.chapter4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter4.BstSequences;
import puzzles.cracking.chapter4.TreeNode;

public class BstSequenceTests {

	@Test
	public void BookTestCase(){
		TreeNode r = new TreeNode(2);       //     2
		TreeNode a = new TreeNode(1);       //    / \
		TreeNode b = new TreeNode(3);       //   1   3
		r.setLeft(a);
		r.setRight(b);
		
		List<String> result = BstSequences.getPrintableSequences(r);
		
		assertTrue(result.contains("[ 2 1 3 ]"));
		assertTrue(result.contains("[ 2 3 1 ]"));
		assertEquals(2, result.size());
	}

	
	@Test
	public void PerfectTree() {
		TreeNode r = new TreeNode(5);       //       5
		TreeNode a = new TreeNode(3);       //     /   \
		TreeNode b = new TreeNode(7);       //   3       7
		r.setLeft(a);                       //  / \     / \ 
		r.setRight(b);                      // 2   4   6   8
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		a.setLeft(c);
		a.setRight(d);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(8);
		b.setLeft(e);
		b.setRight(f);
		
		List<String> result = BstSequences.getPrintableSequences(r);
		
		System.out.println("Found " + result.size() + " sequences: ");
		for(String s : result){
			System.out.println(s);
		}

		assertTrue(result.contains("[ 5 3 7 2 4 6 8 ]"));
	}
	
	@Test
	public void SparseTree() {
		TreeNode r = new TreeNode(5);       //       5
		TreeNode a = new TreeNode(3);       //     /   \
		TreeNode b = new TreeNode(7);       //   3       7
		r.setLeft(a);                       //  /         \ 
		r.setRight(b);                      // 2           8
		TreeNode c = new TreeNode(2);
		a.setLeft(c);
		TreeNode f = new TreeNode(8);
		b.setRight(f);
		
		List<String> result = BstSequences.getPrintableSequences(r);
		
		System.out.println("Found " + result.size() + " sequences: ");
		for(String s : result){
			System.out.println(s);
		}

		assertTrue(result.contains("[ 5 3 7 2 8 ]"));
		assertTrue(result.contains("[ 5 3 7 8 2 ]"));
		assertTrue(result.contains("[ 5 7 3 2 8 ]"));
		assertTrue(result.contains("[ 5 7 3 8 2 ]"));
		assertTrue(result.contains("[ 5 7 8 3 2 ]"));
		assertTrue(result.contains("[ 5 3 2 7 8 ]"));
		assertEquals(6, result.size());
	}
	
	@Test
	public void GivenNull_ReturnNull() {
		List<String> result = BstSequences.getPrintableSequences(null);
		assertNull(result);
	}
	
	@Test
	public void GivenSingleNode_ReturnOneResult() {
		TreeNode r = new TreeNode(5); 
		List<String> result = BstSequences.getPrintableSequences(r);
		
		assertTrue(result.contains("[ 5 ]"));
		assertEquals(1, result.size());
	}
}
