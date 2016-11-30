package puzzles.cracking.chapter4;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	public TreeNode(int value){
		this.value = value;
	}
	
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	public int value;
	
	public List<TreeNode> getChildren(){
		List<TreeNode> children = new ArrayList<>();
		if(left != null){
			children.add(left);
		}
		if(right != null){
			children.add(right);
		}
		return children;
	}
	
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

	public TreeNode firstCommonAncestor(TreeNode other) {
		if(other == null){
			return null;
		}
		
		TreeNode a = this;
		TreeNode b = other;
		int depthA = a.depth();
		int depthB = b.depth();
		//advance pointers to same depth
		while(depthA != depthB){
			if(depthA > depthB){
				a = a.parent;
				depthA--;
			} else {
				b = b.parent;
				depthB--;
			}
		}
		while(a != b && a.parent != null && b.parent != null){
			a = a.parent;
			b = b.parent;
		}
		return a == b ? a : null;
	}

	private int depth() {
		TreeNode finger = this;
		int depth = 0;
		while(finger.parent != null){
			finger = finger.parent;
			depth++;
		}
		return depth;
	}
	
}
