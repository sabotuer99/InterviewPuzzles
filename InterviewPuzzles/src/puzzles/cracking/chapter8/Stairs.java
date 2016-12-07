package puzzles.cracking.chapter8;

public class Stairs {

	public static int steps(int n){
		n = Math.abs(n);
		int[] DP = new int[Math.max(3, n+1)];
		DP[0] = 1;
		DP[1] = 1;
		DP[2] = 2;
		for(int i = 3; i <= n; i++){
			DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
		}
		
		return DP[n];
	}
	
}
