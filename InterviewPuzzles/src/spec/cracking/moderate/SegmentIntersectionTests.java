package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.SegmentIntersection.LineSegment;
import puzzles.cracking.moderate.SegmentIntersection.Point;

public class SegmentIntersectionTests {

	@Test
	public void Point_GetDistance_CorrectVal(){
		Point a = new Point(0,0);
		Point b = new Point(3,4);
		
		double result = Point.getDistance(a, b);
		
		assertEquals(5, result, 0.000000001);
	}
	
	@Test
	public void Point_GetDistance_CorrectValOtherDir(){
		Point a = new Point(0,0);
		Point b = new Point(-3, -4);
		
		double result = Point.getDistance(a, b);
		
		assertEquals(5, result, 0.000000001);
	}
	
	@Test
	public void Point_Equals_CorrectVal(){
		Point a = new Point(0,0);
		Point b = new Point(0,0);
		Point c = new Point(0,1);
		
		boolean eq = a.equals(b);
		boolean neq = b.equals(c);
		
		assertTrue(eq);
		assertFalse(neq);
	}
	
	@Test
	public void Intersect_FindIntersection_SimpleCase(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(0,5);
		Point bend = new Point(5,0);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		Point expected = new Point(2.5,2.5);
		
		assertEquals(expected, intx);
	}	
	
	@Test
	public void Intersect_FindIntersection_ReverseSimpleCase(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(0,5);
		Point bend = new Point(5,0);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bend, bstart);
		
		Point intx = a.findIntersection(b);
		Point expected = new Point(2.5,2.5);
		
		assertEquals(expected, intx);
	}
	
	@Test
	public void Intersect_FindIntersection_Q3SimpleCase(){
		Point astart = new Point(0,0);
		Point aend = new Point(-5,-5);
		Point bstart = new Point(0,-5);
		Point bend = new Point(-5,0);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		Point expected = new Point(-2.5,-2.5);
		
		assertEquals(expected, intx);
	}
	
	@Test
	public void Intersect_FindIntersection_BothPosSlope(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(-1.5, -0.5);
		Point bend = new Point(6.5, 5.5);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		Point expected = new Point(2.5,2.5);
		
		assertEquals(expected, intx);
	}
	
	@Test
	public void Intersect_FindIntersection_Parallel(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(0,1);
		Point bend = new Point(5,6);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		
		assertNull(intx);
	}
	
	@Test
	public void Intersect_FindIntersection_IntersectPastEndOfSegment(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(1,2);
		Point bend = new Point(5,6);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		
		assertNull(intx);
	}
	
	@Test
	public void Intersect_FindIntersection_Collinear1(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(1,1);
		Point bend = new Point(6,6);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		
		assertEquals(bstart, intx);
	}
	
	@Test
	public void Intersect_FindIntersection_Collinear2(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(-1,-1);
		Point bend = new Point(6,6);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		
		assertEquals(astart, intx);
	}
	
	@Test
	public void Intersect_FindIntersection_CollinearNoIntx(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(6,6);
		Point bend = new Point(8,8);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		
		assertNull(intx);
	}
	
	@Test
	public void Intersect_FindIntersection_EndPointOnOtherSegment(){
		Point astart = new Point(0,0);
		Point aend = new Point(5,5);
		Point bstart = new Point(0,5);
		Point bend = new Point(2.5,2.5);
		
		LineSegment a = new LineSegment(astart, aend);
		LineSegment b = new LineSegment(bstart, bend);
		
		Point intx = a.findIntersection(b);
		Point expected = new Point(2.5,2.5);
		
		assertEquals(expected, intx);
	}
	
}
