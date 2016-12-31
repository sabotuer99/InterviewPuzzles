package puzzles.kennyyu.datastructures;

import puzzles.kennyyu.datastructures.ReverseList.SingleList;

public class ReverseList {
	
	private static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static class SingleList{
		
		
		Node head;
		
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

	public static void reverse(SingleList list) {
		if(list.head == null){
			return;
		}
		
		Node next = list.head.next;
		Node current = list.head;
		list.head.next = null;
		
		while(next != null){
			current = next;
			next = next.next;
			current.next = list.head;
			list.head = current;
		}
		
	}
	
}
