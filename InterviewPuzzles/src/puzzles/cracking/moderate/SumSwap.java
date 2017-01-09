package puzzles.cracking.moderate;

import java.util.HashMap;
import java.util.Map;

public class SumSwap {

	public static int[] sumSwap(int[] a, int[] b){
		if(a == null || b == null || a.length == 0 || b.length == 0){
			return null;
		}
		
		int sumA = 0, sumB = 0;
		Map<Integer, Integer> aMap = new HashMap<>();
		for(int i = 0; i < a.length; i++){
			aMap.put(a[i], i);
			sumA += a[i];
		}
		for(int num : b){
			sumB += num;
		}
		
		int sumDiff = sumA - sumB;
		if((sumDiff & 1) == 1){
			return null;
		}
		
		int avgDiff = sumDiff / 2;
		
		for(int i = 0; i < b.length; i++){
			int comp = b[i] + avgDiff;
			Integer compi = aMap.get(comp);
			if(compi != null){
				int[] ans = {compi, i};
				return ans;
			}
		}
		return null;

	}
}
