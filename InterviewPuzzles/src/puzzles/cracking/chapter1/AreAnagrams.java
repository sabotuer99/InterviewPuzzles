package puzzles.cracking.chapter1;

import java.util.HashMap;
import java.util.Map;

public class AreAnagrams {

	public static boolean areAnagrams(String word1, String word2) {
		
		if(word1 == null || word2 == null || word1 == "" || word2 == "" 
				|| word1.length() != word2.length()){
			return false;
		}
			
		word1 = word1.toUpperCase();
		word2 = word2.toUpperCase();
		Map<Character, Integer> letterCount = new HashMap<>();
		
		for(char letter : word1.toCharArray()){
			Integer oldCount = letterCount.containsKey(letter) ? letterCount.get(letter) : 0;
			letterCount.put(letter, oldCount + 1); 			
		}
		
		for(char letter : word2.toCharArray()){
			Integer oldCount = letterCount.get(letter);
			if(oldCount == null || oldCount == 0){
				return false;
			}
			letterCount.put(letter, oldCount - 1);
		}
		
		return true;
	}

}
