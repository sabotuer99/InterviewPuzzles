package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.TreeNode;

public class SuccessorTests {

	@Test
	public void PerfectTree_ReturnsCorrectSuccessors() {
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
		
		assertEquals("d should be a's successor...", d, a.successor());
		assertEquals("f should be b's successor...", f, b.successor());
		assertEquals("a should be c's successor...", a, c.successor());
		assertEquals("root should be d's successor...", root, d.successor());
		assertEquals("b should be e's successor...", b, e.successor());
		assertEquals("f's successor should be null...", null, f.successor());
		assertEquals("e should be root's successor...", e, root.successor());
	}
	
	@Test
	public void SparseAvlTree_ReturnsTrue() {
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
		
		assertEquals("d should be a's successor...", d, a.successor());
		assertEquals("f should be b's successor...", f, b.successor());
		assertEquals("null should be c's successor...", null, c.successor());
		assertEquals("root should be d's successor...", root, d.successor());
		assertEquals("b should be e's successor...", b, e.successor());
		assertEquals("c should be f's successor...", c, f.successor());
		assertEquals("e should be root's successor...", e, root.successor());
	}
	
	@Test
	public void UnbalancedTree_ReturnsFalse() {
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
		
		assertEquals("root should be a's successor...", root, a.successor());
		assertEquals("f should be b's successor...", f, b.successor());
		assertEquals("null should be c's successor...", null, c.successor());
		assertEquals("e should be d's successor...", e, d.successor());
		assertEquals("b should be e's successor...", b, e.successor());
		assertEquals("c should be f's successor...", c, f.successor());
		assertEquals("d should be root's successor...", d, root.successor());
		
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
        root.setRight(a);                 //         /
        a.setLeft(b);                     //        d
        b.setRight(c);                    //         \
        c.setLeft(d);                     //          e
        d.setRight(e);                    //         / 
        e.setLeft(f);                     //        f  
		
		assertEquals("null should be a's successor...", null, a.successor());
		assertEquals("d should be b's successor...", d, b.successor());
		assertEquals("a should be c's successor...", a, c.successor());
		assertEquals("f should be d's successor...", f, d.successor());
		assertEquals("c should be e's successor...", c, e.successor());
		assertEquals("e should be f's successor...", e, f.successor());
		assertEquals("b should be root's successor...", b, root.successor());
	}

}
