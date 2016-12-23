package puzzles.mithack;

import java.util.Deque;

public class BSTValidator {

	public static class Node{
		public Node left;
		public Node right;
		public int value;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	
	public static boolean isValid(Node node, Deque<Integer> seen){
		if(node == null){
			return true;
		}
		
		boolean valid = isValid(node.left, seen);
		valid = valid && (seen.size() == 0 || seen.peek() < node.value);
		seen.push(node.value);
		valid = valid && isValid(node.right, seen);
		
		return valid;
	}
	
}
