package spec.cracking.chapter3;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

import puzzles.cracking.chapter3.SortStack;

public class SortStackTests {

	@Test
	public void Sort5ElementStack() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(4);
		stack.push(41);
		stack.push(411);
		stack.push(14);
		stack.push(114);
		
		Deque<Integer> sorted = new SortStack().sort(stack);
		
		assertEquals(4, (int)sorted.pop());
		assertEquals(14, (int)sorted.pop());
		assertEquals(41, (int)sorted.pop());
		assertEquals(114, (int)sorted.pop());
		assertEquals(411, (int)sorted.pop());
	}

}
