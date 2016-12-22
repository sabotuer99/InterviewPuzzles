package puzzles.mithack;

import java.util.Arrays;

public class Substring {

	public static int findMatchesKMP(String pattern, String text){
		
		int[] prefix = kmpPrefix(pattern);
		int n = text.length();
		int m = pattern.length();
		char[] p = pattern.toCharArray();
		char[] t = text.toCharArray();
		int matchCount = 0;
		int bigO = 0;
		int i = 0, j = 0, k = 0;
		
		while( k < n - m + 1){
			
			//iterate through the pattern and text until either the pattern runs out or there is a mismatch
			while( j < m && t[i] == p[j]){
				i++;
				j++;
				bigO++;
			}
			
			//if j == m, we've matched the entire pattern
			if(j == m){
				matchCount++;	
			}
			
			
			if(j > 0 && prefix[j-1] > 0){
				k = i - prefix[j-1];
			} else {
				if(i == k){
					i++;
				}
				k = i;
			}
			
			if(j > 0){
				j = prefix[j-1];
			}
		}
		
		System.out.println("KMP found matches in " + bigO + " operations.");
		
		return matchCount;
	}

	public static int[] kmpPrefix(String pattern) {
		//Preprocess pattern
		int bigO = 0;
		
		char[] p = pattern.toCharArray();
		int[] prefix = new int[p.length];
		prefix[0] = 0;
		int a = 0;
		for(int b = 1; b < p.length; b++){
			bigO++;
			while(a > 0 && p[a] != p[b]){
				bigO++;
				a = prefix[a-1];
			}
			if(p[a] == p[b]){
				a++;
			}
			prefix[b] = a;
		}
		
		System.out.println("Finished preprocessing with " + bigO + " operations");
		return prefix;
	}
	
	public static int findMatchesNaive(String pattern, String text){
		
		int matchCount = 0;
		int bigO = 0;
		
		for(int i = 0; i < text.length() - pattern.length() + 1; i++){
			boolean match = true;
			for(int j = 0; j < pattern.length(); j++){
				bigO++;
				if(pattern.charAt(j) != text.charAt(i + j)){
					match = false;
					break;
				}
				
			}
			if(match){
				matchCount++;
			}
		}
		
		System.out.println("Naive found matches in " + bigO + " operations.");
		
		
		return matchCount;
	}
	
}
