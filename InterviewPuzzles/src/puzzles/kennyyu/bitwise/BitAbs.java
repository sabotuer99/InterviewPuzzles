package puzzles.kennyyu.bitwise;

public class BitAbs {

	public static int absDiff(int x, int y){
		int c = x + (~y + 1);
		int d = ~c + 1;
		return (c * ((c >>> 31) ^ 1)) + (d * ((d >>> 31) ^ 1));
	}
}
