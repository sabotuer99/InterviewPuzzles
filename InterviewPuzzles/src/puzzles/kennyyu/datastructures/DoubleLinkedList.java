package puzzles.kennyyu.datastructures;

public class DoubleLinkedList<T> {

	private class Node{
		public T data;
		public Node prev;
		public Node next;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	Node head;
	Node tail;
	public int size = 0;
	
	public void push(T data){
		size++;
		Node node = new Node(data);
		if(head == null){
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
	
	public void append(T data){
		size++;
		Node node = new Node(data);
		if(tail == null){
			head = node;
			tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}
	
	public void insert(int index, T data){
		if(index < 0){
			return;
		}
		if(index == 0 || size == 0){
			push(data);
			return;
		}
		if(index >= size){
			append(data);
			return;
		}
		
		size++;
		Node node = new Node(data);
		Node current = get(index);
		
		node.next = current;
		node.prev = current.prev;
		current.prev.next = node;
		current.prev = node;
	}
	
	private Node get(int index){
		if(index < 0 || index >= size){
			return null;
		}
		Node current = head;
		for(int i = 0; i < index; i++ ){
			current = current.next;
		}
		return current;
	}
	
	public T popHead(){
		if(head == null){
			return null;
		}
		
		size--;
		T data = head.data;
		head = head.next;
		head.prev = null;
		validateEnds();
		return data;
	}
	
	private void validateEnds() {
		if(size == 0){
			head = null;
			tail = null;
		}
	}

	public T popTail(){
		if(tail == null){
			return null;
		}
		size--;
		T data = tail.data;
		tail = tail.prev;
		tail.next = null;
		validateEnds();
		return data;
	}
	
	public T popAt(int index){
		Node node = get(index);
		
		if(node == null){
			return null;
		}
		size--;
		if(node.prev != null){
			node.prev.next = node.next;
		}
		if(node.next != null){
			node.next.prev = node.prev;
		}
		validateEnds();
		
		return node.data;
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
				sb.append("<=> ");
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
}
