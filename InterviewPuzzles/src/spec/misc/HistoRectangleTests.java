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

}
