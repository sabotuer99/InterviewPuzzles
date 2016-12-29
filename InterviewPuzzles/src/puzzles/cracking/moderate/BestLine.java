package puzzles.cracking.moderate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BestLine {
	public static class Point{
		public double x;
		public double y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString(){
			return String.format("(%.6f, %.6f)", x, y);
		}
	}
	
	public static class Line{
		private double a;
		private double b;
		public Point start;
		public Point end;
		public Line(Point first, Point second){
			if(first.x > second.x){
				Point temp = first;
				first = second;
				second = temp;
			}
			double rise = second.y - first.y;
			double run = second.x - first.x;
			a = rise/run;
			b = first.y - first.x * a;
			start = first;
			end = second;
		}
		
		@Override
		public int hashCode(){
			return ((int)(a * 1000000) << 16) ^ (int)(b * 1000000);
			//return this.toString().hashCode();
		}
		
		@Override
		public boolean equals(Object other){
			if(other == null || !(other instanceof Line)){
				return false;
			}
			Line o = (Line) other;
			return o.a == this.a && o.b == this.b &&
					((this.a > Double.NEGATIVE_INFINITY && this.a < Double.POSITIVE_INFINITY) || 
					  this.start.x == o.start.x);
			//return o.toString().equals(this.toString());
		}
		
		@Override
		public String toString(){
			if(a == Double.NEGATIVE_INFINITY || a == Double.POSITIVE_INFINITY){
				return String.format("x = %.6f", start.x);
			}
			
			String sign = b < 0 ? "-" : "+";
			return String.format("%.6fx %s %.6f", a, sign , Math.abs(b));
		}
	}
	
	public static Line bestLine(List<Point> points){
		if(points == null || points.size() < 2){
			return null;
		}
		
		List<Set<Line>> lines = new ArrayList<>();
		List<Point> seen = new ArrayList<>();
		lines.add(new HashSet<>());
		
		for(Point point : points){
			System.out.println("Checking point " + point);
			//check if point extends an existing line
			int maxLength = lines.size();
			for(int i = maxLength - 1; i >= 0; i--){
				Set<Line> existingLines = lines.get(i);
				for(Line exline : existingLines){
					Line candidate = new Line(exline.start, point);
					if(existingLines.contains(candidate)){
						if(i == lines.size() - 1){
							lines.add(new HashSet<>());
						}
						lines.get(i+1).add(candidate);
						System.out.println("Added " + exline.start + " - " + point + " to bucket " + (i+1));
					}
				}
			}
			//create lines with seen points
			for(Point seenp : seen){
				lines.get(0).add(new Line(seenp, point));
			}
			seen.add(point);
		}
		
		return lines.get(lines.size() - 1).iterator().next();
	}
}
