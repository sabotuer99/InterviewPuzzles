package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.SumPathCount;
import puzzles.cracking.chapter4.TreeNode;

public class SumPathCountTests {
	
	@Test
	public void OneNodeTree_RightValue_Returns1(){
		TreeNode root = new TreeNode(5);
		
		int result = SumPathCount.countPathsWithSum(5, root);
		
		assertEquals(1, result);
	}
	
	@Test
	public void OneNodeTree_WrongValue_Returns1(){
		TreeNode root = new TreeNode(5);
		
		int result = SumPathCount.countPathsWithSum(7, root);
		
		assertEquals(0, result);
	}
	
	@Test
	public void NullNodeTree_Returns0(){
		int result = SumPathCount.countPathsWithSum(7, null);
		
		assertEquals(0, result);
	}
	
	@Test
	public void GeneratedTree(){
		int levels = 4;
		TreeNode root = getGenTree(levels);
		
		//                0
		//           /        \
		//        1              8
		//      /  \           /   \
		//    2      5       9       12
		//   / \    / \     / \     /  \
		//  3   4  6   7  10   11  13   14
		//
		// Paths summing to 6:
		//  0-1-2-3
		//  0-1-5
		//  1-2-3
		//  1-5
		//  2-4
		//  6
	
		int result = SumPathCount.countPathsWithSum(6, root);
		assertEquals(6, result);
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
