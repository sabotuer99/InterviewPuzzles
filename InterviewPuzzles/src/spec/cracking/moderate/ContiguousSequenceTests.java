package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.ContiguousSequence;

public class ContiguousSequenceTests {

	@Test
	public void BookTestCase(){
		int[] input = {-8, 3, -2, 4, -10};
		int result = ContiguousSequence.maxSeq(input);
		assertEquals(5, result);
	}

	@Test
	public void SequenceAtBeginning(){
		int[] input = {100, 1, 2, 3, -800, 3, -2, 4, -10};
		int result = ContiguousSequence.maxSeq(input);
		assertEquals(106, result);
	}

	@Test
	public void SequenceAtEnd(){
		int[] input = {-8, 3, -2, 4, -10, 100, 1, 2, 3};
		int result = ContiguousSequence.maxSeq(input);
		assertEquals(106, result);
	}
	
	@Test
	public void EmptySetIsBest(){
		int[] input = {-1, -1, -1, -1};
		int result = ContiguousSequence.maxSeq(input);
		assertEquals(0, result);
	}
}
