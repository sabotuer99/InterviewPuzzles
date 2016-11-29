package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.CheckBalanced;
import puzzles.cracking.chapter4.CheckBst;
import puzzles.cracking.chapter4.TreeNode;

public class CheckBstTests {

	@Test
	public void HeapTree_ReturnsFalse() {
		TreeNode root = new TreeNode(1);  //      1
		TreeNode a = new TreeNode(2);     //    /   \
		TreeNode b = new TreeNode(3);     //   2     3
		root.left = a;                    //  / \   / \ 
		root.right = b;                   // 4   5 6   7
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		a.left = c;
		a.right = d;
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.left = e;
		b.right = f;
		
		boolean result = CheckBst.isBst(root);

		assertFalse(result);
	}
	
	@Test
	public void Bst_ReturnsTrue() {
		TreeNode root = new TreeNode(10); //      10
		TreeNode a = new TreeNode(2);     //    /    \
		TreeNode b = new TreeNode(13);    //   2      13
		root.left = a;                    //  / \    / \ 
		root.right = b;                   // 1   5  8   15
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(5);
		a.left = c;
		a.right = d;
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(15);
		b.left = e;
		b.right = f;
		
		boolean result = CheckBst.isBst(root);

		assertTrue(result);
	}
	
	@Test
	public void Null_ReturnsFalse() {
		boolean result = CheckBst.isBst(null);
		assertFalse(result);
	}

}
