package puzzles.cracking.chapter2;

public class ListAdder {

	public static Node addLists(Node a, Node b) {
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		
		int carry = 0;
		Node result = new Node((a.val + b.val) - (carry * 10));
		carry = (a.val + b.val) / 10;
		System.out.println(carry);
		a = a.next;
		b = b.next;
		Node c = result;
		while(a != null && b != null){	
			int currentCarry = (a.val + b.val + carry) / 10;
			Node next = new Node((a.val + b.val + carry) - (currentCarry * 10));
			carry = currentCarry;
			c.next = next;
			c = next;
			a = a.next;
			b = b.next;
		}
		Node rest = a == null? b : a;
		while(rest != null){	
			int currentCarry = (rest.val + carry) / 10;
			Node next = new Node(rest.val + carry - (currentCarry * 10));
			carry = currentCarry;
			c.next = next;
			c = next;
			rest = rest.next;
		}
		if(carry > 0){
			Node last = new Node(carry);
			c.next = last;
		}
		return result;
	}
}
