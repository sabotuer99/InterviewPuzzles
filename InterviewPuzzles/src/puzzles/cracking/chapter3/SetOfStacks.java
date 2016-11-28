package puzzles.cracking.chapter3;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SetOfStacks {

	private Map<Integer, Deque<Integer>> stacks;
	private int stackSize;
	private int size;
	private int stackCount;

	public SetOfStacks(int stackSize) {
		this.stackSize = stackSize;
		this.stacks = new HashMap<>();
		this.size = 0;
		this.stackCount = 0;
	}
	
	public void push(int value){
		if(stackCount == 0 || stacks.get(stackCount-1).size() == stackSize){
			stacks.put(stackCount, new LinkedList<Integer>());
			stackCount++;
		}
		System.out.println(stacks.size());
		Deque<Integer> stack = stacks.get(stackCount-1);
		stack.push(value);
		size++;
	}
	
	public int pop(){
		if(size == 0){
			throw new RuntimeException("Cannot pop from empty stack.");
		}
		Deque<Integer> stack = stacks.get(stackCount-1);
		while(stack == null){
			stackCount--;
			stacks.get(stackCount-1);
		}
		return popStack(stack, stackCount-1, true);
	}
	
	public int popAt(int index){
		if(size == 0 || stacks.get(index) == null){
			throw new RuntimeException("Cannot pop from empty stack.");
		}
		Deque<Integer> stack = stacks.get(index);
		return popStack(stack, index, false);
	}

	private int popStack(Deque<Integer> stack, int index, boolean decrement) {
		int value = stack.pop();
		if(stack.size() == 0){
			stacks.remove(index);
			if(decrement){
				stackCount--;
			}
		}
		return value;
	}
}
