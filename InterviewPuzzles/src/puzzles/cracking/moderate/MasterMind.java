package puzzles.cracking.moderate;

import java.util.Arrays;

public class MasterMind {

	public static int[] guessResult(String guess, String solution){
		if(guess == null || solution == null || guess.length() != solution.length()){
			return null;
		}
		
		int[] counts = new int[26];
		for(char bit : solution.toCharArray()){
			int index = bit - 'A';
			counts[index]++;
		}
		
		for(char gbit : guess.toCharArray()){
			int index = gbit - 'A';
			counts[index] = Math.max(counts[index] - 1, 0);//don't go negative
		}
		
		System.out.println(Arrays.toString(counts));
		
		int phits = solution.length();
		for(int misses : counts){
			phits -= misses;
		}
		
		int hits = 0;
		for(int i = 0; i < solution.length(); i++){
			hits += solution.charAt(i) == guess.charAt(i) ? 1 : 0;
		}
		
		int[] result = {hits, phits - hits};
		return result;
	}
}
