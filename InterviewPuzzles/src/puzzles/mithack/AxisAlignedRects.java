package puzzles.mithack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

import puzzles.cracking.moderate.BisectSquares.Point;

public class AxisAlignedRects {

	public static class Rectangle{
		public Point upperLeft;
		public Point lowerRight;
		public Rectangle(Point ul, Point lr){
			upperLeft = ul;
			lowerRight = lr;
		}
		
		public boolean overlap(Rectangle other){
			       //upperleft inside 
			return inside(other.upperLeft.x, other.upperLeft.y) ||
				   //lowerRight inside
				   inside(other.lowerRight.x, other.lowerRight.y) ||
				   //upperRight inside
				   inside(other.lowerRight.x, other.upperLeft.y) ||
				   //lowerLeft inside
				   inside(other.upperLeft.x, other.lowerRight.y);
		}
		
		private boolean inside(double x, double y){
			return x >= upperLeft.x && x <= lowerRight.x && y >= lowerRight.y && y <= upperLeft.y;
		}
	}
	
	public static List<Rectangle> findOverlapPair(Rectangle[] rects){
		if(rects == null || rects.length == 1){
			return null;
		}
		
		Arrays.sort(rects, new Comparator<Rectangle>(){
			@Override
			public int compare(Rectangle a, Rectangle b){
				return (int)(a.upperLeft.x - b.upperLeft.x);
			}
		});
		Deque<Rectangle> starts = new ArrayDeque<>();
		for(Rectangle rect : rects){
			starts.offer(rect);
		}
		
		Arrays.sort(rects, new Comparator<Rectangle>(){
			@Override
			public int compare(Rectangle a, Rectangle b){
				return (int)(a.lowerRight.x - b.lowerRight.x);
			}
		});
		Deque<Rectangle> ends = new ArrayDeque<>();
		for(Rectangle rect : rects){
			ends.offer(rect);
		}
		
		List<Rectangle> currentlyActive = new ArrayList<>();
		while(ends.size() > 0 && starts.size() > 0){
			if(starts.peek().upperLeft.x < ends.peek().lowerRight.x){
				Rectangle next = starts.poll();
				for(Rectangle active : currentlyActive){
					if(active.overlap(next)){
						List<Rectangle> pairs = new ArrayList<>();
						pairs.add(next);
						pairs.add(active);
						return pairs;
					}
				}
				currentlyActive.add(next);
			} else {
				Rectangle done = ends.poll();
				currentlyActive.remove(done);
			}
		}
		
		return null;
	}
}
