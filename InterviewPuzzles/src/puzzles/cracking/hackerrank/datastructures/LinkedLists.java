package puzzles.cracking.hackerrank.datastructures;

public class LinkedLists {

    class Node {
        int data;
        Node next;
    }
	
	boolean hasCycle(Node head) {
	    if(head == null || head.next == null){
	        return false;
	    }

	    Node turtle = head;
	    Node hare = head.next;
	    while(turtle.next != null && hare.next != null && hare.next.next != null && hare != turtle){
	        turtle = turtle.next;
	        hare = hare.next.next;
	    }
	    
	    return hare == turtle;
	}
}
