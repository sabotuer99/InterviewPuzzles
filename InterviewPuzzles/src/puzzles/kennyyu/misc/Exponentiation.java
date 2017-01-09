package puzzles.kennyyu.misc;

import java.util.HashMap;
import java.util.Map;

public class Exponentiation {

	public static long exp(long n, long m){
		return exp(n, m, new HashMap<>());
	}
	
	public static long expNaive(long n, long m){
		long expect = 1;
		for(int i = 0; i < m; i++){
		   //System.out.printf("Calculating %d * %d^%d\n", expect, n, m-i);
		   expect *= n;
		}
		return expect;
	}

	private static long exp(long n, long m, Map<Long, Long> memo){
		
		if(memo.containsKey(m)){
			return memo.get(m);
		}
		//System.out.printf("Calculating %d ^ %d\n", n, m);
		
		if(m == 2){
			return n * n;
		}
		if(m == 1){
			return n;
		} 
		if(m == 0){ 
			return 1;
		}
		
		long m1 = m/2;
		long m2 = m - m1;
		
		long result = exp(n, m1, memo) * exp(n, m2, memo);
		memo.put(m, result);
		
		return result;
	}
	
}
