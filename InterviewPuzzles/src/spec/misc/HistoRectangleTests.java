package spec.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.misc.HistoRectangle;

public class HistoRectangleTests {

	@Test
	public void VideoExample_GetRightAnswer() {
		int[] histogram = {1,3,5,3,2,2,3,3,1,0,3,6};
		
		int max = HistoRectangle.maxRect(histogram);
		
		assertEquals(14, max);
	}
	
	@Test
	public void VideoExample2_GetRightAnswer() {
		int[] histogram = {1,3,5,3,0,2,6,6,1,0,3,6};
		
		int max = HistoRectangle.maxRect(histogram);
		
		assertEquals(12, max);
	}
	
	@Test
	public void Stack_VideoExample_GetRightAnswer() {
		int[] histogram = {1,3,5,3,2,2,3,3,1,0,3,6};
		
		int max = HistoRectangle.stackRect(histogram);
		
		assertEquals(14, max);
	}
	
	@Test
	public void Stack_VideoExample2_GetRightAnswer() {
		int[] histogram = {1,3,5,3,0,2,6,6,1,0,3,6};
		
		int max = HistoRectangle.stackRect(histogram);
		
		assertEquals(12, max);
	}
	
	@Test
	public void GivenNull_Return0() {
		int[] histogram = null;
		
		int max = HistoRectangle.maxRect(histogram);
		
		assertEquals(0, max);
	}
	
	@Test
	public void GivenEmpty_Return0() {
		int[] histogram = {};
		
		int max = HistoRectangle.maxRect(histogram);
		
		assertEquals(0, max);
	}
	
	@Test
	public void GivenOneValue_ReturnSame() {
		int[] histogram = {10};
		
		int max = HistoRectangle.maxRect(histogram);
		
		assertEquals(10, max);
	}

}
