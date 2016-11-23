package puzzles.cracking.annagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Annagrams {

	public static List<String> compute(String word) {
		
		if(word == null || "".equals(word)){
			return new ArrayList<>();
		}
		
		return permutations(word);
	}

	private static List<String> permutations(String word) {
		if(word != null && word.length() == 1){
			return Arrays.asList(word);
		}
		
		
		List<String> results = new ArrayList<>();
		for(int i = 0; i < word.length(); i++){
			String letter = word.substring(i,i+1);
			String left = "";
			String right = "";
			if(i > 0){
				left = word.substring(0,i);
			}
			if(i < word.length() - 1){
				right = word.substring(i+1);
			}
			if(word.length()-1 != (left + right).length()){
				System.out.println("Left: " + left);
				System.out.println("Right: " + right);
				throw new RuntimeException("BUG!!");
			}
			
			List<String> subseqs = permutations(left + right);
			for(String subseq : subseqs){
				results.add(letter + subseq);
			}
		}	
		return results;
	}

}
