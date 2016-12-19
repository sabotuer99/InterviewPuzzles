package puzzles.cracking.moderate;

public class BitwiseMax {

	public static int max(int a, int b){
		
		int c = a - b;
		int k = (c >> 31) & 1;
		int max = a - k * c;
		return max;
	}
	
	
}
