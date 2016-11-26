package puzzles.cracking.chapter1;

import java.util.Arrays;

public class DedupeString {

	public static String dedupe(String input) {
		if(input == null || input.length() < 2){
			return input;
		}
		
		char[] letters = input.toCharArray();
		int L = 0;
		int R = letters.length -1;
		
		while(R > L){
			char target = letters[L];
			int offset = 0;
			for(int i = L + 1; i <= R; i++){
				if(letters[i] == target){
					offset++;
				} else if (offset > 0){
					letters[i-offset] = letters[i];
				}
			}
			R -= offset;
			L++;
		}
		
		return new String(Arrays.copyOfRange(letters, 0, R+1));
	}

}
