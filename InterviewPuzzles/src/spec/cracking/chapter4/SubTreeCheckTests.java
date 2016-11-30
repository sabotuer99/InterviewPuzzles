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
		boolean result2 = SubTreeCheck.isSubTree(root, b);
		assertTrue(result2);
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
		boolean result2 = SubTreeCheck.isSubTree(root, e);
		assertFalse(result2);
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
		boolean result2 = SubTreeCheck.isSubTree(root, b1);
		assertTrue(result2);
		assertTrue(result);
		
	}
	
	@Test
	public void HugeGeneratedTree_SubTreeInLeftCorner_ReturnTrue() {
		int levels = 20;
		TreeNode root = getGenTree(levels);
		
		TreeNode b1 = new TreeNode(levels - 2);
		TreeNode e1 = new TreeNode(levels - 1);
		TreeNode f1 = new TreeNode(levels);
		b1.setLeft(e1);
		b1.setRight(f1);
		
		long now = System.currentTimeMillis();
		boolean result = SubTreeCheck.isSubTreeNaive(root, b1);
		System.out.println("Naive approach took: " + (System.currentTimeMillis() - now));
		
		now = System.currentTimeMillis();
		boolean result2 = SubTreeCheck.isSubTree(root, b1);
		System.out.println("Smart approach took: " + (System.currentTimeMillis() - now));
		
		assertTrue(result2);
		assertTrue(result);
	}
	
	@Test
	public void HugeGeneratedTree_SubTreeInRightCorner_ReturnTrue() {
		int levels = 20;
		TreeNode root = getGenTree(levels);
		
		/*  //Had to use this to figure out the far right corner
		TreeNode finger = root;
		while(finger.right.right != null){
			finger = finger.right;
		}
		System.out.println("Subtree Config: ");
		System.out.println("    " + finger.value);
		System.out.println("   /   \\");
		System.out.println(finger.left.value + "   " + finger.right.value);
		*/
		
		TreeNode b1 = new TreeNode((1 << levels) - 4);
		TreeNode e1 = new TreeNode((1 << levels) - 3);
		TreeNode f1 = new TreeNode((1 << levels) - 2);
		b1.setLeft(e1);
		b1.setRight(f1);
		
		long now = System.currentTimeMillis();
		boolean result = SubTreeCheck.isSubTreeNaive(root, b1);
		System.out.println("Naive approach took: " + (System.currentTimeMillis() - now));
		
		now = System.currentTimeMillis();
		boolean result2 = SubTreeCheck.isSubTree(root, b1);
		System.out.println("Smart approach took: " + (System.currentTimeMillis() - now));
		
		assertTrue(result2);
		assertTrue(result);
	}
	
	private TreeNode getGenTree(int levels){
		nodeNum = 0;
		return genTree(levels);
	}
	
	private int nodeNum = 0;
	private TreeNode genTree(int levels){
		TreeNode root = new TreeNode(nodeNum);
		nodeNum++;
		if(levels > 1){
			root.setLeft(genTree(levels-1));
			root.setRight(genTree(levels-1));
		}
		return root;
	}
}
