package spec.cracking.chapter4;

import static org.junit.Assert.*;


import org.junit.Test;

import puzzles.cracking.chapter4.CheckBalanced;
import puzzles.cracking.chapter4.TreeNode;

public class CheckBalancedTests {


	@Test
	public void PerfectTree_ReturnsTrue() {
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
		
		System.out.println("**********Perfect***********");
		boolean result = CheckBalanced.isBalanced(root);

		assertTrue(result);
	}
	
	@Test
	public void SparseAvlTree_ReturnsTrue() {
		TreeNode root = new TreeNode(1);  //     root
		TreeNode a = new TreeNode(2);     //    /    \
		TreeNode b = new TreeNode(3);     //   a      b
		root.left = a;                    //    \    / \ 
		root.right = b;                   //     d  e   f
		TreeNode c = new TreeNode(4);     //             \
		TreeNode d = new TreeNode(5);     //              c
		a.right = d;
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.left = e;
		b.right = f;
		f.right = c;
		
		System.out.println("**********Sparse AVL***********");
		boolean result = CheckBalanced.isBalanced(root);

		assertTrue(result);
	}
	
	@Test
	public void UnbalancedTree_ReturnsFalse() {
		TreeNode root = new TreeNode(1);  //     root
		TreeNode a = new TreeNode(2);     //    /    \
		TreeNode b = new TreeNode(3);     //   a      b
		root.left = a;                    //         / \ 
		root.right = b;                   //        e   f
		TreeNode c = new TreeNode(4);     //       /     \
		TreeNode d = new TreeNode(5);     //      d       c
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.left = e;
		b.right = f;
		f.right = c;
		e.left = d;
		
		System.out.println("**********Unbalanced***********");
		boolean result = CheckBalanced.isBalanced(root);

		assertFalse(result);
	}
	
	@Test
	public void ReallyUnbalancedTree_ReturnsFalse() {
		TreeNode root = new TreeNode(1);  //     root
		TreeNode a = new TreeNode(2);     //         \
		TreeNode b = new TreeNode(3);     //          a  
		TreeNode c = new TreeNode(4);     //         /
		TreeNode d = new TreeNode(5);     //        b
		TreeNode e = new TreeNode(6);     //         \
		TreeNode f = new TreeNode(7);     //          c        
        root.right = a;                   //         /
        a.left = b;                       //        d
        b.right = c;                      //         \
        c.left = d;                       //          e
        d.right = e;                      //         / 
        e.left = f;                       //        f  
		
        System.out.println("**********Terrible***********");
		boolean result = CheckBalanced.isBalanced(root);

		assertFalse(result);
	}
	
	@Test
	public void NullNode_ReturnsFalse() {
		boolean result = CheckBalanced.isBalanced(null);

		assertFalse(result);
	}

}
