package puzzles.cracking.chapter4;

import java.util.HashMap;
import java.util.Map;

public class CheckBalanced {

	@SuppressWarnings("unused")
	private static String[] nodes = {"", "root", "a", "b", "c", "d", "e", "f"};
	
	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return false;
		}
		
		Map<TreeNode, Integer> heights = new HashMap<>();
		getHeight(root, heights);
		return isBalanced(root, heights);
	}
	
	private static int getHeight(TreeNode root, 
			Map<TreeNode, Integer> heights) {
		if(root == null){
			return 0;
		}
		
		if(heights.containsKey(root)){
			return heights.get(root);
		}
		
		int height = Math.max(getHeight(root.left, heights), 
			      	          getHeight(root.right, heights)) + 1;
		
		heights.put(root, height);
		return height;
	}

	private static boolean isBalanced(TreeNode root,
			Map<TreeNode, Integer> heights) {
		if(root == null){
			return true;
		}
		int lefth = getHeight(root.left, heights);
		int righth = getHeight(root.right, heights);

		
		boolean balanced = Math.abs(lefth - righth) <= 1; 
		
		if(!balanced){
			return false;
		}
		
		
		return  isBalanced(root.left, heights) && 
				isBalanced(root.right, heights);
	}
}
