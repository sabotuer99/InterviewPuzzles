package puzzles.misc;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SubPermutations {

	public static int subPermutations(String pattern, String text){

		if(Pattern.matches(".*[^a-z].*", pattern) || Pattern.matches(".*[^a-z].*", text)){
			throw new IllegalArgumentException("Can only compare strings of lower case letters.");
		}
		if(pattern == null || text == null){
			return 0;
		}
		
		Counter p = countLetters(pattern);
		
		String front = text.substring(0, pattern.length());
		Counter t = countLetters(front);
		
		int count = 0;
		
		for(int i = 0; i <= text.length() - pattern.length(); i++){
			if(p.hash() == t.hash()){
				count += sameCounts(p, t) ? 1 : 0;
			}
			
			//only update if we aren't at the end
			if(i < text.length() - pattern.length()){
				char drop = text.charAt(i);
				char add = text.charAt(i + pattern.length());
				System.out.printf("dropping %c, adding %c, hash: %d\n", drop, add, t.hash());
				updateCounts(t, drop, add);
			}
		}
		
		return count;
	}

	
	private static void updateCounts(Counter tcounts, char drop, char add) {
		tcounts.dec(drop);
		tcounts.inc(add);
	}

	public static int updateHash(int thash, char drop, char add) {
		
		int mask = ~(1 << (drop - 'a'));
		int set = (1 << (add - 'a'));
		
		return (thash & mask) | set;
	}
	
	private static boolean sameCounts(Counter pcounts, Counter tcounts) {
		if(pcounts.keys().size() != tcounts.keys().size()){
			return false;
		}
		
		for(Character key : pcounts.keys()){
			if(pcounts.get(key) != tcounts.get(key)){
				return false;
			}
		}
		
		return true;
	}

	private static class Counter{
		int[] counts = new int[26];
		private int hash;
		Set<Character> keys = new HashSet<>();
		
		
		public void inc(char key){
			int index = key - 'a';
			keys.add(key);
			counts[index]++;
			int set = (1 << (key - 'a'));
			hash |= set;
		}
		
		public void dec(char key){
			int index = key - 'a';
			counts[index]--;
			if(counts[index] <= 0){
				counts[index] = 0;
				int mask = ~(1 << (key - 'a'));
				hash &= mask;
				keys.remove(key);
			}
		}
		
		public int get(char key){
			int index = key - 'a';
			return counts[index];
		}
		
		public Set<Character> keys(){
			return keys;
		}
		
		public int hash(){
			return hash;
		}
	}
	
	public static int alphaHash(String text) {	
		int hash = 0;
		for(int i = 0; i < text.length(); i++ ){
			int shift = (int)(text.charAt(i) - 'a');
			hash |= 1 << shift;
		}
		return hash;
	}
	
	private static Counter countLetters(String text){
		Counter counts = new Counter();
		for(int i = 0; i < text.length(); i++ ){
			counts.inc(text.charAt(i));
		}
		return counts;
	}
	
}
