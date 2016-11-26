package spec.cracking.chapter1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter1.Matrix;

public class MatrixTests {

	@Test
	public void Given4x4Matrix_CorrectRotation() {
		int[][] matrix = {{10,11,12,13},{20,21,22,23},{30,31,32,33},{40,41,42,43}};
		
		Matrix sut = new Matrix(matrix);
		
		int[][] rotated = sut.rotateClockwise();
			
		int[][] expected = {{40,30,20,10},{41,31,21,11},{42,32,22,12},{43,33,23,13}};
		
		for(int i = 0; i < 4; i++){
			System.out.println(Arrays.toString(rotated[i]));
		}
		
		assertEquals(Arrays.toString(expected[0]), Arrays.toString(rotated[0]));
		assertEquals(Arrays.toString(expected[1]), Arrays.toString(rotated[1]));
		assertEquals(Arrays.toString(expected[2]), Arrays.toString(rotated[2]));
		assertEquals(Arrays.toString(expected[3]), Arrays.toString(rotated[3]));
	}

}
