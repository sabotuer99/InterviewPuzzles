package puzzles.cracking.moderate;

public class SegmentIntersection {

	public static class Point{
		public final double x;
		public final double y;
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		public static double getDistance(Point point1, Point point2){
			double a = point2.x - point1.x;
			double b = point2.y - point1.y;
			double c = Math.sqrt(a*a + b*b);
			return c;
		}
		
		@Override
		public boolean equals(Object other){
			if(other instanceof Point){
				Point o = (Point) other;
				return o.x == this.x && o.y == this.y;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString(){
			return String.format("x: %f  y: %f", x, y);
		}
	}
	
	public static class LineSegment{
		public final Point start;
		public final Point end;
		public final double slope;
		public final double length;

		public LineSegment(Point start, Point end){
			this.start = start;
			this.end = end;
			slope = calculateSlope(start, end);
			length = Point.getDistance(start, end);
		}
		
		private double calculateSlope(Point start, Point end){
			return (end.y - start.y) / (end.x - start.x);
		}
		
		public Point findIntersection(LineSegment b){
			LineSegment a = this;
			
			if(a.slope == b.slope){
				//check for collinearity
				if(calculateSlope(a.start, b.start) == a.slope){
					//check if b starts on a or is contained entirely on a
					if((a.start.x <= b.start.x && a.end.x >= b.start.x) ||
					   (a.start.x <= b.start.x && a.end.x >= b.end.x)	){
						return b.start;
					//check if a starts on b or is contained entirely on b
					} else if((a.start.x <= b.end.x && a.end.x >= b.end.x) ||
							  (a.start.x >= b.start.x && a.end.x <= b.end.x)) {
						return a.start;
					}
				} else {
					return null;
				}
			}
			if(a.start.equals(b.start) || a.start.equals(b.end)){
				return a.start;
			}
			if(b.end.equals(a.end)){
				return b.end;
			}
			
			double y1 = a.start.y;
			double y2 = b.start.y;
			double x1 = a.start.x;
			double x2 = b.start.x;
			double m1 = a.slope;
			double m2 = b.slope;			
			
			double r1 = (y1 - y2 - (m2 * (x1-x2)))/(m2 - m1);
			
			double xi = x1 + r1;
			double yi = y1 + (m1 * r1);
			
			System.out.printf("%f   %f   %f   %f   %f   %f   %f\n", y1, y2, x1, m1, m2, xi, yi);
			
			
			Point intx = new Point(xi, yi);
			
			if(Point.getDistance(a.start, intx) <= a.length && 
			   Point.getDistance(b.start, intx) <= b.length){
				   return intx;
			   } else {
				   return null;
			   }
			
		}
	}
	
	
	
}
