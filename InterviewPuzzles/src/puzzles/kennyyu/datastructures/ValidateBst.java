package puzzles.kennyyu.datastructures;

public class ValidateBst {

	public static class Node{
		public Node left;
		public Node right;
		public int data;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static boolean isBst(Node node){
		return isBst(Integer.MIN_VALUE, Integer.MAX_VALUE, node);
	}
	
	private static boolean isBst(int min, int max, Node node){
		if(node == null){
			return true;
		}
		
		if(node.data <= min || node.data >= max){
			return false;
		}
		
		return isBst(min, node.data, node.left) &&
			   isBst(node.data, max, node.right);
	}
}
