package puzzles.cracking.moderate;

public class BisectSquares {

	public static class Line{
		public double slope;
		public double yintercept;
		public Line(double m, double b){
			this.slope = m;
			this.yintercept = b;
		}
	}
	
	
	public static class Point{
		public double x;
		public double y;
		
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		public static double slopeBetween(Point a, Point b){
			double rise = b.y - a.y;
			double run = b.x - a.x;
			return rise / run;
		}
	}
	
	public static class Square{
		public Point ul, ur, ll, lr;
		public Square(Point upperLeft, Point lowerRight){
			this.ul = upperLeft;
			this.lr = lowerRight;
			this.ur = new Point(lr.x, ul.y);
			this.ll = new Point(ul.x, lr.y);
		}
		
		public Point getCenter(){
			double cx = (ul.x + lr.x)/2;
			double cy = (ul.y + lr.y)/2;
			return new Point(cx, cy);
		}
	}
	
	
	public static Line bisect(Square a, Square b){
		Point aCenter = a.getCenter();
		Point bCenter = b.getCenter();
		double m = Point.slopeBetween(aCenter, bCenter);
		double yint = aCenter.y - m * aCenter.x;
		return new Line(m, yint);
	}
}
