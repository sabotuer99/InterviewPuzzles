package puzzles.cracking.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<String> permutations(String word) {
		List<String> perms = new ArrayList<>();
		if(word == null){	
			return perms;
		}
		if(word.length() == 0 || word.length() == 1){
			perms.add(word);
			return perms;
		}
		
		int len = word.length();
		for(int i = 0; i < len; i++){
			String letter = word.substring(i, i+1);
			String front = i == 0 ? "" : word.substring(0, i);
			String back = i == len - 1 ? "" : word.substring(i+1, len);
			List<String> subPerms = permutations(front + back);
			for(String subPerm : subPerms){
				perms.add(letter + subPerm);
			}
		}
		
		return perms;
	}
}
