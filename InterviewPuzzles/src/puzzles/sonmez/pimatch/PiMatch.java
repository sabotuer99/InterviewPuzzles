package puzzles.sonmez.pimatch;

public class PiMatch {

	public static double score(long num) {
		
		num = Math.abs(num);
		
		if(num < 100){
			return num - 314.0;
		}
		
		double score = 0;
		int count = 0;
		
		while(num >= 100){
			long right = num % 1000L;
			score += right - 314.0;
			num /= 10;
			count += 1;
		}
		
		return score/count;
	}

}
