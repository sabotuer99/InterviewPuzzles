package puzzles.kennyyu.datastructures;

public class SingleListCycle {

	public static class Node{
		int data;
		public Node next;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static class SingleList{
		
		public Node head;
		
		public void add(int data){
			Node node = new Node(data);
			
			if(head == null){
				head = node;
			} else {
				node.next = head;
				head = node;
			}
		}
		
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("{ ");
			
			Node current = head;
			while(current != null){
				sb.append(current.data).append(" ");
				current = current.next;
				if(current != null){
					sb.append("=> ");
				}
			}
			
			sb.append("}");
			return sb.toString();
		}
	}
	
	public static boolean hasCycle(SingleList list){
		if(list == null || list.head == null || list.head.next == null){
			return false;
		}
		
		Node tort = list.head;
		Node hare = list.head.next;
		
		while(tort != null && hare != null){
			if(tort == hare){
				return true;
			}
			tort = tort.next;
			hare = hare.next;
			if(hare != null){
				hare = hare.next;
			}
		}
		
		return false;
	}
}
