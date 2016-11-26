package puzzles.cracking.chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

	
	
	
	public static boolean uniqueChars(String word) {
		
		if(word == null || word.length() == 0){
			return false;
		}
		Set<Character> lettersSeen = new HashSet<>();
		
		for(char letter : word.toCharArray()){
			if(lettersSeen.contains(letter)){
				return false;
			}
			lettersSeen.add(letter);
		}
		return true;
	}

	public static boolean uniqueCharsNoSet(String word) {
		if(word == null || word.length() == 0){
			return false;
		}
		
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		
		for(int i = 1; i < letters.length; i++){
			if(letters[i] == letters[i-1]){
				return false;
			}
		}
		return true;
		
	}

}
