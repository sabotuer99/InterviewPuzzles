package puzzles.cracking.chapter8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static Set<String> parens(int n) {
		// TODO Auto-generated method stub
		return parens(n, new HashMap<Integer, Set<String>>());
	}

	private static Set<String> parens(int n, HashMap<Integer, Set<String>> memo) {
		Set<String> parens = new HashSet<>();
		if(memo.containsKey(n)){
			return memo.get(n);
		}
		
		//Base case
		if(n == 0){
			parens.add("");
			memo.put(n, parens);
			return parens;
		}
		
		//Wrap case
		Set<String> subs = parens(n-1);
		for(String sub : subs){
			parens.add("(" + sub + ")");
		}
		
		//Permutation case
		for(int i = 1; i < n; i++){
			int left = i;
			int right = n - i;
			for(String leftSub : parens(left, memo)){
				for(String rightSub : parens(right, memo)){
					parens.add(leftSub + rightSub);
				}
			}
		}
		
		memo.put(n, parens);

		return parens;
	}

}
