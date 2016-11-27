package puzzles.cracking.chapter2;

public class DeleteNode {
	public static void deleteNode(Node node){
		if(node == null || node.next == null){
			return;
		}
		
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
