package puzzles.cracking.chapter2;

public class DoubleLinkedList{
	private Node head = null;
	
	public DoubleLinkedList(Node head){
		this.head = head;
	}
	
	public DoubleLinkedList(int[] values){
		
		if(values == null){
			return;
		}		
		
		Node node = new Node(0);
		this.head = node;
		for(int v : values){
			node.val = v;
			Node nextNode = new Node(0);
			nextNode.prev = node;
			node.next = nextNode;
			node = nextNode;
		}
		node.prev.next = null;
	}
	
	public Node getHead(){
		return head;
	}
	
	@Override 
	public String toString(){
		
		Node node = this.head;
		StringBuilder sb = new StringBuilder();
		do{
			sb.append(node.val);
			if(node.next != null){
				sb.append(" => ");
			}
			node = node.next;
		} while (node != null);
		
		return sb.toString();
	}
}