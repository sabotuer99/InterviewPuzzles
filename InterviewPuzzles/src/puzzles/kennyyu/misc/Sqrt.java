package puzzles.kennyyu.misc;

public class Sqrt {

	public static double sqrt(double n, double epsilon){
		double d = 2;
		double q = n/2;
		while(Math.abs(q-d) > epsilon){
			d = (d + q) / 2;
			q = n/d;
		}
		
		return d;
	}
}
