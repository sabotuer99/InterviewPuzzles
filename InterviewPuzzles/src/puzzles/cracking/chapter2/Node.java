package puzzles.cracking.chapter2;

public class Node{
	
	int val;
	Node next = null;
	Node prev = null;
	
	public Node(int val){
		this.val = val;
	}
	
	public int getVal(){
		return val;
	}
}
