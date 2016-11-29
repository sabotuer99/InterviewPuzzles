package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.TreeNode;

public class FirstCommonAncestorTests {

	@Test
	public void PerfectTree() {
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
		
		TreeNode fca_de = d.firstCommonAncestor(e);
		TreeNode fca_ef = e.firstCommonAncestor(f);
		TreeNode fca_cr = c.firstCommonAncestor(root);
		
		assertEquals(root, fca_de);
		assertEquals(b, fca_ef);
		assertEquals(root, fca_cr);
	}
	
	@Test
	public void SparseAvlTree() {
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
		
		TreeNode fca_de = d.firstCommonAncestor(e);
		TreeNode fca_ec = e.firstCommonAncestor(c);
		TreeNode fca_cr = c.firstCommonAncestor(root);
		
		assertEquals(root, fca_de);
		assertEquals(b, fca_ec);
		assertEquals(root, fca_cr);
	}
	
	@Test
	public void UnbalancedTree() {
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

		TreeNode fca_de = d.firstCommonAncestor(e);
		TreeNode fca_ec = e.firstCommonAncestor(c);
		TreeNode fca_cr = c.firstCommonAncestor(root);
		
		assertEquals(e, fca_de);
		assertEquals(b, fca_ec);
		assertEquals(root, fca_cr);
	}
	
	@Test
	public void TwoTrees_CommonAncestorIsNull() {
		TreeNode r1 = new TreeNode(1);      //     r1        r2
		TreeNode a = new TreeNode(2);       //    /  \      /  \ 
		TreeNode b = new TreeNode(3);       //   a    b    d    e
		TreeNode r2 = new TreeNode(4);      //                   \
		TreeNode d = new TreeNode(5);       //                    f
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		r1.setLeft(a);
		r1.setRight(b);
		r2.setLeft(d);
		r2.setRight(e);
		e.setRight(f);

		TreeNode fca = b.firstCommonAncestor(f);
		
		assertNull(fca);
	} 
	
	@Test
	public void NullOther_ReturnsNull() {
		TreeNode r1 = new TreeNode(1);   

		TreeNode fca = r1.firstCommonAncestor(null);
		
		assertNull(fca);
	}

}
