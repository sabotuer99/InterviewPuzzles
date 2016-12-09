package puzzles.cracking.chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnagramSort {

	public static String[] anagramSort(String[] words) {
		if(words == null || words.length < 3){
			return words;
		}
		
		Map<String, List<String>> signatures = new HashMap<>();
		for(String word : words){
			//Count up the letter in the words, sorting them alphabetically
			Map<Character, Integer> letterCounts = new TreeMap<>();
			for(int i = 0; i < word.length(); i++){
				Character letter = word.charAt(i);
				int count = letterCounts.containsKey(letter) ? 
								letterCounts.get(letter) : 0 ;
				count++;
				letterCounts.put(letter, count);
			}
			//create signature from letter counts and add to map
			StringBuilder sb = new StringBuilder();
			for(Character letter : letterCounts.keySet()){
				int count = letterCounts.get(letter);
				sb.append(letter).append(count);
			}
			String signature = sb.toString();
			List<String> anagrams = signatures.containsKey(signature) ? 
										signatures.get(signature) : new ArrayList<>();
			anagrams.add(word);
			signatures.put(signature, anagrams);
		}
		
		String[] result = new String[words.length];
		int index = 0;
		for(List<String> anagrams : signatures.values()){
			for(String word : anagrams){
				result[index] = word;
				index++;
			}
		}

		return result;
	}

}
