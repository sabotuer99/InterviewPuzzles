package spec.cracking.chapter4;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import puzzles.cracking.chapter4.ListOfDepths;
import puzzles.cracking.chapter4.TreeNode;

public class ListOfDepthsTests {

	@Test
	public void SanityCheck() {
		TreeNode root = new TreeNode(1);  //     root
		TreeNode a = new TreeNode(2);     //    /    \
		TreeNode b = new TreeNode(3);     //   a      b
		root.left = a;                    //  / \    / \ 
		root.right = b;                   // c   d  e   f
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		a.left = c;
		a.right = d;
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.left = e;
		b.right = f;
		
		Map<Integer, List<TreeNode>> result = ListOfDepths.getDepths(root);
		
		assertEquals(1, result.get(1).size());
		assertEquals(2, result.get(2).size());
		assertEquals(4, result.get(3).size());
		assertTrue(result.get(3).contains(c));
	}
	
	@Test
	public void NullCheck() {
		Map<Integer, List<TreeNode>> result = ListOfDepths.getDepths(null);
		
		assertNull(result);
	}

}
