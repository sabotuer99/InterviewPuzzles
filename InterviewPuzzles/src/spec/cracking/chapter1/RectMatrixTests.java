package spec.cracking.chapter1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter1.RectMatrix;

public class RectMatrixTests {

	@Test
	public void Given3x3WithZeroInMiddle() {
		int[][] test = {{1,1,1},
				        {1,0,1},
				        {1,1,1}};
		
		int[][] expected = {{1,0,1},
		        			{0,0,0},
		        			{1,0,1}};
		
		int[][] result = RectMatrix.clobberRowCol(test);
		
		for(int i = 0; i < result.length; i++){
			assertEquals(Arrays.toString(expected[i]), Arrays.toString(result[i]));
		}
	}
	
	@Test
	public void Given3x4WithZeroInMiddle() {
		int[][] test = {{1,1,1,1},
				        {1,0,1,1},
				        {1,1,1,1}};
		
		int[][] expected = {{1,0,1,1},
		        			{0,0,0,0},
		        			{1,0,1,1}};
		
		int[][] result = RectMatrix.clobberRowCol(test);
		
		for(int i = 0; i < result.length; i++){
			assertEquals(Arrays.toString(expected[i]), Arrays.toString(result[i]));
		}
	}
	
	@Test
	public void Given3x4WithMultipleZeros() {
		int[][] test = {{0,1,1,1},
				        {1,1,1,1},
				        {1,1,1,0}};
		
		int[][] expected = {{0,0,0,0},
		        			{0,1,1,0},
		        			{0,0,0,0}};
		
		int[][] result = RectMatrix.clobberRowCol(test);
		
		for(int i = 0; i < result.length; i++){
			assertEquals(Arrays.toString(expected[i]), Arrays.toString(result[i]));
		}
	}

}
