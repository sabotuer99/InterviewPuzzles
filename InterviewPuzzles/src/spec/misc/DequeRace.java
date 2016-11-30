package spec.misc;

//import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class DequeRace {

	int n = 5000000;
	
	@Test
	public void Race_Reused() {
		
		System.out.println("Reused Queues");
		System.out.println("********************");
		
		Deque<Integer> sutAD = new ArrayDeque<>(n);
		Deque<Integer> sutLL = new LinkedList<>();
		
		for(int i = 0; i < 10; i++){
			runs(n, sutAD, "ArrayDeque");
			runs(n, sutLL, "LinkedList");
		}
	}
	
	@Test
	public void Race_New() {
		
		System.out.println("New Queues Every Run");
		System.out.println("********************");
				
		for(int i = 0; i < 10; i++){
			Deque<Integer> sutAD = new ArrayDeque<>(n);
			Deque<Integer> sutLL = new LinkedList<>();
			runs(n, sutAD, "ArrayDeque");
			runs(n, sutLL, "LinkedList");
		}
	}

	
	private static void runs(int n, Deque<Integer> list, String listType){
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			list.push(i);
		}
		
		for(int i = 0; i < n; i++){
			list.pop();
		}
		long now = System.currentTimeMillis();
		System.out.println(listType + ": " + (now - start));
	}

}
