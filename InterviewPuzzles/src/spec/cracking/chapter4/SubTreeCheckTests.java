package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.SubTreeCheck;
import puzzles.cracking.chapter4.TreeNode;

public class SubTreeCheckTests {

	@Test
	public void PerfectTree_ReturnsCorrectSignature() {
		TreeNode root = new TreeNode(1);    //     root
		TreeNode a = new TreeNode(2);       //    /    \
		TreeNode b = new TreeNode(3);       //   a      b
		root.setLeft(a);                    //  / \    / \ 
		root.setRight(b);                   // c   d  e   f
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		a.setLeft(c);
		a.setRight(d);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.setLeft(e);
		b.setRight(f);
		
		StringBuilder sb = new StringBuilder();
		SubTreeCheck.buildSign(sb, root);
		
		assertEquals("L4R2L5R1L6R3L7R", sb.toString());
		
		boolean result = SubTreeCheck.isSubTreeNaive(root, b);
		assertTrue(result);
	}
	
	@Test
	public void Monkey3() {
		TreeNode root = new TreeNode(1);    //     root
		TreeNode a = new TreeNode(2);       //    /    \
		TreeNode b = new TreeNode(3);       //   a      b
		root.setLeft(a);                    //    \    / \ 
		root.setRight(b);                   //     d  e   f
		TreeNode c = new TreeNode(4);       //             \
		TreeNode d = new TreeNode(5);       //              c
		a.setRight(d);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.setLeft(e);
		b.setRight(f);
		f.setRight(c);
		
		StringBuilder sb = new StringBuilder();
		SubTreeCheck.buildSign(sb, root);
		
		assertEquals("L2L5R1L6R3L7L4R", sb.toString());
	}
	
	@Test
	public void Monkey2() {
		TreeNode root = new TreeNode(1);    //     root
		TreeNode a = new TreeNode(2);       //    /    \
		TreeNode b = new TreeNode(3);       //   a      b
		root.setLeft(a);                    //         / \ 
		root.setRight(b);                   //        e   f
		TreeNode c = new TreeNode(4);       //       /     \
		TreeNode d = new TreeNode(5);       //      d       c
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.setLeft(e);
		b.setRight(f);
		f.setRight(c);
		e.setLeft(d);
		
		StringBuilder sb = new StringBuilder();
		SubTreeCheck.buildSign(sb, root);
		
		assertEquals("L2R1L5R6R3L7L4R", sb.toString());		
	}
	
	@Test
	public void Monkey1() {
		TreeNode root = new TreeNode(1);  //     root
		TreeNode a = new TreeNode(2);     //         \
		TreeNode b = new TreeNode(3);     //          a  
		TreeNode c = new TreeNode(4);     //         /
		TreeNode d = new TreeNode(5);     //        b
		TreeNode e = new TreeNode(6);     //         \
		TreeNode f = new TreeNode(7);     //          c        
        root.setRight(a);                 //         /
        a.setLeft(b);                     //        d
        b.setRight(c);                    //         \
        c.setLeft(d);                     //          e
        d.setRight(e);                    //         / 
        e.setLeft(f);                     //        f  
		
		StringBuilder sb = new StringBuilder();
		SubTreeCheck.buildSign(sb, root);
		
		assertEquals("L1L3L5L7R6R4R2R", sb.toString());	
		
		//chop off e
		d.right = null;
		e.parent = null;
		boolean result = SubTreeCheck.isSubTreeNaive(root, e);
		assertFalse(result);
	}

	@Test
	public void SeperateTreeWithMatchingStructureAndValues_ReturnTrue() {
		TreeNode root = new TreeNode(1);    //     root
		TreeNode a = new TreeNode(2);       //    /    \
		TreeNode b = new TreeNode(3);       //   a      b
		root.setLeft(a);                    //  / \    / \ 
		root.setRight(b);                   // c   d  e   f
		TreeNode c = new TreeNode(4);       //
		TreeNode d = new TreeNode(5);       //      b1
		a.setLeft(c);                       //     /  \
		a.setRight(d);                      //    e1  f1
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		b.setLeft(e);
		b.setRight(f);
		
		TreeNode b1 = new TreeNode(3);
		TreeNode e1 = new TreeNode(6);
		TreeNode f1 = new TreeNode(7);
		b1.setLeft(e1);
		b1.setRight(f1);
		
		boolean result = SubTreeCheck.isSubTreeNaive(root, b1);
		assertTrue(result);
	}
}
