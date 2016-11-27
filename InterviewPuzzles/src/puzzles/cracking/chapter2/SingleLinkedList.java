package puzzles.cracking.chapter2;

public class SingleLinkedList{
	private Node head = null;
	
	public SingleLinkedList(Node head){
		this.head = head;
	}
	
	public SingleLinkedList(int[] values){
		
		if(values == null){
			return;
		}		
		
		Node node = new Node(0);
		Node last = node;
		this.head = node;
		for(int v : values){
			node.val = v;
			Node nextNode = new Node(0);
			//nextNode.prev = node;
			node.next = nextNode;
			last = node;
			node = nextNode;
		}
		last.next = null;
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