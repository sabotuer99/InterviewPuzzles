package puzzles.cracking.chapter4;

public class CheckBst {

	public static boolean isBst(TreeNode root){
		return isBst(root, false);
	}
	
	private static boolean isBst(TreeNode root, boolean nullOk){
		if(root == null){
			return nullOk;
		}
		
		boolean bst = true;
		bst = bst && (root.left == null || root.left.value < root.value);
		bst = bst && (root.right == null || root.right.value > root.value);
		
		return bst && isBst(root.left, true) && isBst(root.right, true);
	}
}
