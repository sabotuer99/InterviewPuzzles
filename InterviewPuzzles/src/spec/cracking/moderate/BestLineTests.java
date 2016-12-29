package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import puzzles.cracking.moderate.BestLine;
import puzzles.cracking.moderate.BestLine.Line;
import puzzles.cracking.moderate.BestLine.Point;

public class BestLineTests {

	@Test
	public void MultipleVerticals_ReturnsCorrectBest(){
		Point a = new Point(1,1);
		Point b = new Point(2,2);
		Point c = new Point(3,3);
		Point d = new Point(4,4);
		Point e = new Point(1,0);
		Point f = new Point(2,1);
		Point g = new Point(3,2);
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		points.add(c);
		points.add(d);
		points.add(e);
		points.add(f);
		points.add(g);
		
		Line result = BestLine.bestLine(points);
		
		assertEquals("1.000000x + 0.000000", result.toString());
	}
	
	@Test
	public void TwoPointsVerticalLine_ReturnsLineBetween(){
		Point a = new Point(1,1);
		Point b = new Point(1,2);
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		
		Line result = BestLine.bestLine(points);
		
		assertEquals("x = 1.000000", result.toString());
	}
	
	@Test
	public void TwoPoints_ReturnsLineBetween(){
		Point a = new Point(1,1);
		Point b = new Point(2,2);
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		
		Line result = BestLine.bestLine(points);
		
		assertEquals("1.000000x + 0.000000", result.toString());
	}
	
	@Test
	public void SevenPoints_ReturnsBestLine(){
		Point a = new Point(1,2);
		Point b = new Point(2,3);
		Point c = new Point(3,6);
		Point d = new Point(4,8);
		Point e = new Point(6,1);
		Point f = new Point(6,3);
		Point g = new Point(6,12);
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		points.add(c);
		points.add(d);
		points.add(e);
		points.add(f);
		points.add(g);
		
		Line result = BestLine.bestLine(points);
		
		assertEquals("2.000000x + 0.000000", result.toString());
	}
	
	@Test
	public void BadInput_ReturnsNull(){
		Point a = new Point(1,2);
		List<Point> points = new ArrayList<>();
		points.add(a);
		
		Line result1 = BestLine.bestLine(points);
		Line resultNull = BestLine.bestLine(null);
		
		assertNull(result1);
		assertNull(resultNull);
	}
}
