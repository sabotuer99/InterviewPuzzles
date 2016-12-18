package puzzles.cracking.moderate;

public class NumberSwapper {

	public static int swap(int x, int y){
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		return x;
	}
}
