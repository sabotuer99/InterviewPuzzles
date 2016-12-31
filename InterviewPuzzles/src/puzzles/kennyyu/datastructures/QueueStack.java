package puzzles.kennyyu.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueStack {

	Deque<Integer> a = new ArrayDeque<>();
	Deque<Integer> b = new ArrayDeque<>();
	
	public void push(int value){
		Deque<Integer> head = getInactive();
		Deque<Integer> aux = getActive();
		
		head.offer(value);
		while(aux.size() > 0){
			head.offer(aux.poll());
		}
	}
	
	private Deque<Integer> getInactive(){
		return a.size() == 0 ? a : b;
	}
	
	private Deque<Integer> getActive(){
		return a.size() == 0 ? b : a;
	}
	
	public int pop(){
		Deque<Integer> head = getActive();
		return head.poll();
	}
	
	public int peek(){
		Deque<Integer> head = getActive();
		return head.peek();
	}
	
	public int size(){
		Deque<Integer> head = getActive();
		return head.size();
	}
}
