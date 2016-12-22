package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.BisectSquares;
import puzzles.cracking.moderate.BisectSquares.Line;
import puzzles.cracking.moderate.BisectSquares.Point;
import puzzles.cracking.moderate.BisectSquares.Square;

public class BisectSquaresTests {

	@Test
	public void SanityCheck(){
		Square a = new Square(new Point(-3,-3), new Point(-1,-1));
		Square b = new Square(new Point(1,3), new Point(3,1));
		
		Line result = BisectSquares.bisect(a, b);
		
		assertEquals(1, result.slope, 0.00000001);
		assertEquals(0, result.yintercept, 0.00000001);
	}
	
	@Test
	public void Check2(){
		Square a = new Square(new Point(-3.5,-3.5), new Point(-1,-1));
		Square b = new Square(new Point(5,4), new Point(7,2));
		
		Line result = BisectSquares.bisect(a, b);
		
		assertEquals(63.0/99.0, result.slope, 0.00000001);
		assertEquals(-81.0/99.0, result.yintercept, 0.00000001);
	}
}
