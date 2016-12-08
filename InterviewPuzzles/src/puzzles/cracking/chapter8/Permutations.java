package puzzles.cracking.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<String> seen = new HashSet<>();
		
		for(int i = 0; i < len; i++){
			String letter = word.substring(i, i+1);
			
			//prevent dupes
			if(seen.contains(letter)){
				continue;
			} else {
				seen.add(letter);
			}
			
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
