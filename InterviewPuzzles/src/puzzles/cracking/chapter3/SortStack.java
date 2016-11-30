package puzzles.cracking.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

	public Deque<Integer> sort(Deque<Integer> stack){
		if(stack.size() < 2){
			return stack;
		}
		Deque<Integer> L = new ArrayDeque<>(stack.size()/2 + 1);
		Deque<Integer> R = new ArrayDeque<>(stack.size()/2 + 1);
		boolean bit = false;
		while(stack.size() > 0){
			if(bit){
				L.push(stack.pop());
			} else {
				R.push(stack.pop());
			}
			bit = !bit;
		}
		
		L = sort(L);
		R = sort(R);
		return merge(L, R);
	}

	private Deque<Integer> merge(Deque<Integer> L, Deque<Integer> R) {
		Deque<Integer> merged = new ArrayDeque<>(L.size() + R.size());
		
		System.out.println("Merging L: " + L.size() + " with R: " + R.size());
		//System.out.println("Merging L: " + L.peek() + " with R: " + R.peek());
		
		while(L.size() > 0 || R.size() > 0){
			if(R.size() == 0 || (L.size() > 0 && L.peek() < R.peek())){
				merged.push(L.pop());
			} else {
				merged.push(R.pop());
			}
		}
		
		Deque<Integer> reversed = new ArrayDeque<>(merged.size());
		while(merged.size() > 0){
			reversed.push(merged.pop());
		}
		
		//System.out.println(Arrays.toString(merged.toArray(new Integer[merged.size()]))
			//	+ " Top: " + merged.peek());
		
		return reversed;
	}
	
	
}
