package puzzles.cracking.moderate;

public class FactorialZeros {

	public static int factorialTailZeros(int n){
		int count = 0;
		for(int i = 1; Math.pow(5, i) <= n && i < 10; i++){
			count += n / (int)Math.pow(5, i);
		}
		return count;
	}
	
	
}
