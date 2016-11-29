package puzzles.cracking.chapter4;

public class TreeNode {

	public TreeNode(int value){
		this.value = value;
	}
	
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	public int value;
	
	public void setLeft(TreeNode child){
		left = child;
		child.parent = this;
	}
	
	public void setRight(TreeNode child){
		right = child;
		child.parent = this;
	}
	
	
	public TreeNode min(){
		if(left == null){
			return this;
		} else {
			return left.min();
		}
	}
	
	public TreeNode max(){
		if(right == null){
			return this;
		} else {
			return right.max();
		}
	}
	
	public TreeNode successor(){
		if(right != null){
			return right.min();
		}
		
		if(parent != null && parent.left == this){
			return parent;
		}
		
		TreeNode candidate = parent;
		TreeNode child = this;
		while(candidate != null && candidate.left != child){
			child = candidate;
			candidate = candidate.parent;
		}
		return candidate;
	}
	
}
