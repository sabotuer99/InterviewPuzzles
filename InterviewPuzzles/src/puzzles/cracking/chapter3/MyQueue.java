package puzzles.cracking.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

	Deque<Integer> enqueue = new ArrayDeque<>();
	Deque<Integer> poll = new ArrayDeque<>();
	
	public void enqueue(int i) {
		enqueue.push(i);
	}

	public int poll() {
		if(poll.size() == 0){
			while(enqueue.size() > 0){
				poll.push(enqueue.pop());
			}
		}
		return poll.pop();
	}

}
