package spec.mithack;

import static org.junit.Assert.*;

import java.util.ArrayDeque;

import org.junit.Test;

import puzzles.mithack.BSTValidator;
import puzzles.mithack.BSTValidator.Node;

public class BSTValidatorTests {

	@Test
	public void isValid(){
		Node head = new Node(4);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node five = new Node(5);
		Node six = new Node(6);
		
		head.left = three;
		head.right = five;
		five.right = six;
		three.left = one;
		one.right = two;
		
		boolean result = BSTValidator.isValid(head, new ArrayDeque<Integer>());
		
		assertTrue(result);
	}
	
	@Test
	public void isNotValid(){
		Node head = new Node(4);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node five = new Node(5);
		Node six = new Node(6);
		
		head.left = three;
		head.right = five;
		five.left = six;
		three.left = one;
		one.right = two;
		
		boolean result = BSTValidator.isValid(head, new ArrayDeque<Integer>());
		
		assertFalse(result);		
	}
	
}
