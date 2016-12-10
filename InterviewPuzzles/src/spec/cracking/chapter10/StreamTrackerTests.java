package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter10.StreamTracker;

public class StreamTrackerTests {

	@Test
	public void BookTestCase(){
		
		StreamTracker sut = new StreamTracker();
		int[] values = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		for(int value : values){
			sut.track(value);
		}
		
		assertEquals(0, sut.rank(1));
		assertEquals(1, sut.rank(3));
		assertEquals(3, sut.rank(4));
		assertEquals(5, sut.rank(5));
		assertEquals(6, sut.rank(7));
		assertEquals(7, sut.rank(9));
		assertEquals(8, sut.rank(13));
		
	}
	
	@Test
	public void OneValueRepeated(){
		
		StreamTracker sut = new StreamTracker();
		int[] values = {3,3,3,3,3,3,3,3,3};
		for(int value : values){
			sut.track(value);
		}
		
		assertEquals(8, sut.rank(3));
		
	}
	
	@Test
	public void EmptyTracker(){
		
		StreamTracker sut = new StreamTracker();
		
		assertEquals(-1, sut.rank(1));
		
	}
}
