package puzzles.kennyyu.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxPrimeFactor {

	
	public static int maxPrimeFactor(int n){
		System.out.println("#####################################");
		List<Integer> factors = new ArrayList<>();
		getFactors(n, factors);
		
		System.out.println(Arrays.toString(factors.toArray()));
		
		return Collections.max(factors);
	}
	
	private static void getFactors(int n, List<Integer> factors){
		int end = (int)Math.sqrt(n);
		//System.out.println(n);
		for(int i = 2; i <= end; i++){
			System.out.printf("Checking if %d if factor in %d\n",i,n);
			if(n%i == 0){
				factors.add(i);
				n /= i;
				i = 2;
				end = (int)Math.sqrt(n);
			} else if( i == end){
				factors.add(n);
			}
		}
	}
}
