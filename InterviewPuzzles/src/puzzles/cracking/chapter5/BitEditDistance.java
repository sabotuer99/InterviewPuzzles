package puzzles.cracking.chapter5;

public class BitEditDistance {

	public static int bitEditDistance(int a, int b){
		int bitcount = 0;
		int difference = a ^ b;
		while(difference > 0){
			bitcount += difference & 1;
			difference >>= 1;
		}
		return bitcount;
	}
}
