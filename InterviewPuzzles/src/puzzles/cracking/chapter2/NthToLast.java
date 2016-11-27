package puzzles.cracking.chapter2;

public class NthToLast {

	public static Node getNthFromEnd(Node head, int n) {
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node offset = head;
		Node current = head;
		for(int i = 1; i < n && offset.next != null; i++){
			offset = offset.next;
		}
		
		while(offset.next != null){
			offset = offset.next;
			current = current.next;
		}
		
		return current;
	}

}
