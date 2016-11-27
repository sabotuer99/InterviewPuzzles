package puzzles.cracking.chapter2;

import java.util.HashSet;
import java.util.Set;

public class CycleStart {

	public static Node getCycleStart(Node head) {
		
		if(head == null || head.next == null){
			return null;
		}
		
		Set<String> seen = new HashSet<>();
		seen.add(head.getId());
		Node next = head.next;
		while(next != null){
			if(seen.contains(next.getId())){
				return next;
			}
			seen.add(next.getId());
			next = next.next;
		}
		return null;
	}

}
