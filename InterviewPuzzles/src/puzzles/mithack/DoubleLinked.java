package puzzles.mithack;

public class DoubleLinked {

	private class Node{
		Node next;
		Node prev;
		int value;
		
		public Node(int value){
			this.value = value;
		}
		
		@Override
		public String toString(){
			return Integer.toString(value);
		}
	}
	
	Node head;
	
	public void add(int val){
		Node next = new Node(val);
		next.next = head;
		if(head != null){
			head.prev = next;
		}
		head = next;
	}
	
	public void delete(int val){
		if(head == null){
			return;
		}
		
		if(head.value == val){
			if(head.next != null){
				head.next.prev = null;
				head = head.next;
				return;
			}
		}
		
		Node current = head;
		while(current != null && current.value != val){
			current = current.next;
		}
		
		if(current != null){
			if(current.next != null){
				current.next.prev = current.prev;
			}
			current.prev.next = current.next;
		}
	}
	
	@Override
	public String toString(){
		Node pointer = head;
		StringBuilder sb = new StringBuilder();
		sb.append(pointer);
		while(pointer != null){
			sb.append(" <=> ").append(pointer.next);
			pointer = pointer.next;
		}
		return sb.toString();
	
	}
	
}
