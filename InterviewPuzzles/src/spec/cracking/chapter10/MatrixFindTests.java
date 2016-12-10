package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter10.MatrixFind;
import puzzles.cracking.chapter10.MatrixFind.Location;

public class MatrixFindTests {

	@Test
	public void SimpleTest(){
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
				          { 7, 8, 9,10,11,12},
				          {13,14,15,16,17,18},
				          {19,20,21,22,23,24}};
		
		Location result = MatrixFind.find(matrix, 17);
		
		assertEquals(2, result.row);
		assertEquals(4, result.col);
	}
	
	@Test
	public void MissingValue(){
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
				          { 7, 8, 9,10,11,12},
				          {13,14,15,17,18,19},
				          {20,21,22,23,24,25}};
		
		Location result = MatrixFind.find(matrix, 16);
		
		assertEquals(-1, result.row);
		assertEquals(-1, result.col);
	}
	
	@Test
	public void MissingValue_BetweenRows(){
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
				          { 7, 8, 9,10,11,12},
				          {13,14,15,16,17,18},
				          {20,21,22,23,24,25}};
		
		Location result = MatrixFind.find(matrix, 19);
		
		assertEquals(-1, result.row);
		assertEquals(-1, result.col);
	}
	
	@Test
	public void MissingValue_BetweenCols(){
		int[][] matrix = {{ 1, 6,10,14,18,22},
				          { 2, 7,11,15,19,23},
				          { 3, 8,12,16,20,24},
				          { 4, 9,13,17,21,25}};
		
		Location result = MatrixFind.find(matrix,  5);
		
		assertEquals(-1, result.row);
		assertEquals(-1, result.col);
	}
	
	@Test
	public void MissingValue_BelowMin(){
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
				          { 7, 8, 9,10,11,12},
				          {13,14,15,17,18,19},
				          {20,21,22,23,24,25}};
		
		Location result = MatrixFind.find(matrix, 0);
		
		assertEquals(-1, result.row);
		assertEquals(-1, result.col);
	}
	
	@Test
	public void MissingValue_AboveMax(){
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
				          { 7, 8, 9,10,11,12},
				          {13,14,15,17,18,19},
				          {20,21,22,23,24,25}};
		
		Location result = MatrixFind.find(matrix, 26);
		
		assertEquals(-1, result.row);
		assertEquals(-1, result.col);
	}
	
	@Test
	public void CornerTest(){
		int[][] matrix = {{ 1, 5, 9,10,11,15},
				          { 2, 6,12,13,14,16},
				          { 3, 7,17,18,21,23},
				          { 4, 8,19,20,22,24}};
		
		Location result1 = MatrixFind.find(matrix, 1);
		Location result2 = MatrixFind.find(matrix, 24);
		
		assertEquals(0, result1.row);
		assertEquals(0, result1.col);
		assertEquals(3, result2.row);
		assertEquals(5, result2.col);
	}
}
