package puzzles.kennyyu.bitwise;

public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n){
		return (n & (n-1)) == 0;
	}
}
