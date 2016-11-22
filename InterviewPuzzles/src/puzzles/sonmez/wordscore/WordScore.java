package puzzles.sonmez.wordscore;

import java.util.HashMap;
import java.util.Map;

public class WordScore {

	public static int score(String word) {
		//Guard clause
		if(word == null || "".equals(word)){
			return 0;
		}
		
		Map<String, Integer> scores = new HashMap<>();
		scores.put("A", 2);
		scores.put("E", 2);
		scores.put("I", 2);
		scores.put("O", 2);
		scores.put("U", 2);
		scores.put("F", 3);
		scores.put("J", 6);
		scores.put("X", 12);
		scores.put("T", 5);
		
		String uword = word.toUpperCase();
		String[] letters = uword.split("");
		int score = 0;
		
		for(String letter : letters){
			score += scores.containsKey(letter) ? scores.get(letter) : 0;
		}
		
		return score;
	}

}
