package puzzles.cracking.chapter2;

public class Dedupe{
	
	public static Node dedupe(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node prev = head;
		Node current = head.next;
		boolean isdupe = false;
		while(current != null){
			prev = current.prev;
			while(prev != null){
				if(prev.val == current.val){
					isdupe = true;
					break;
				}
				prev = prev.prev;
			}
			if(isdupe){
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
			current = current.next;
			isdupe = false;
		}
		
		return head;
	}
}
