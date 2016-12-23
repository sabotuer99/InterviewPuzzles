package spec.mithack;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.moderate.BisectSquares.Point;
import puzzles.mithack.AxisAlignedRects;
import puzzles.mithack.AxisAlignedRects.Rectangle;

public class AxisAlignedRectsTests {

	@Test
	public void BasicTest(){
		Rectangle a = new Rectangle(new Point(1, 3), new Point(4, 1));
		Rectangle b = new Rectangle(new Point(3, 5), new Point(5, 2));
		Rectangle[] rects = {a, b};
		
		List<Rectangle> pair = AxisAlignedRects.findOverlapPair(rects);
		
		assertTrue(pair.contains(a));
		assertTrue(pair.contains(b));
	}
	
	@Test
	public void BasicTestDisjoint(){
		Rectangle a = new Rectangle(new Point(1, 3), new Point(4, 1));
		Rectangle b = new Rectangle(new Point(5, 5), new Point(7, 2));
		Rectangle[] rects = {a, b};
		
		List<Rectangle> pair = AxisAlignedRects.findOverlapPair(rects);
		
		assertNull(pair);
	}
	
	@Test
	public void AbuttingRectanglesDontIntersect(){
		Rectangle a = new Rectangle(new Point(1, 3), new Point(4, 1));
		Rectangle b = new Rectangle(new Point(4, 5), new Point(7, 2));
		Rectangle[] rects = {a, b};
		
		List<Rectangle> pair = AxisAlignedRects.findOverlapPair(rects);
		
		assertNull(pair);
	}
	
	@Test
	public void MoreRectangles(){
		Rectangle a = new Rectangle(new Point(1, 3), new Point(4, 1));
		Rectangle b = new Rectangle(new Point(5, 5), new Point(7, 2));
		Rectangle c = new Rectangle(new Point(-5, 5), new Point(-1, 2));
		Rectangle d = new Rectangle(new Point(7, 5), new Point(8, 2));
		Rectangle e = new Rectangle(new Point(6, 4), new Point(9, 1));
		Rectangle[] rects = {a, b, c, d, e};
		
		List<Rectangle> pair = AxisAlignedRects.findOverlapPair(rects);
		
		assertTrue(pair.contains(b));
		assertTrue(pair.contains(e));
	}
}
