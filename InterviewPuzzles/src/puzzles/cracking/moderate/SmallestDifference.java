package puzzles.cracking.moderate;

import java.util.Arrays;

public class SmallestDifference {

	public static int minDiff(int[] a, int[] b){
		
		if(a == null || b == null || a.length == 0 || b.length == 0){
			return -1;
		}
			
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0, j = 0, min = Integer.MAX_VALUE;
		
		while(i < a.length && j < b.length){
			min = Math.min(min,  Math.abs(a[i] - b[j]));
			if(a[i] == b[j]){
				return 0;
			} else if (a[i] < b[j]){
				i++;
			} else {
				j++;
			}
		}
		
		return min;
	}
	
}
