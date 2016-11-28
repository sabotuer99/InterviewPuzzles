package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.MakeBST;
import puzzles.cracking.chapter4.TreeNode;

public class MakeBstTests {

	@Test
	public void SevenElementArray_DepthIs3() {
		int[] input = {1,2,3,4,5,6,7};
		
		TreeNode root = MakeBST.toBst(input);
		
		assertEquals(4, root.value);
		assertEquals(2, root.left.value);
		assertEquals(6, root.right.value);
		assertEquals(1, root.left.left.value);
		assertEquals(3, root.left.right.value);
		assertEquals(5, root.right.left.value);
		assertEquals(7, root.right.right.value);		
	}

	@Test
	public void GivenNull_returnNull() {
		TreeNode root = MakeBST.toBst(null);
		assertNull(root);
	}
	
	@Test
	public void GivenEmptyArray_returnNull() {
		TreeNode root = MakeBST.toBst(new int[]{});
		assertNull(root);
	}
	
}
