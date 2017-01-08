package puzzles.kennyyu.misc;


public class NeedleHaystack {

	public static boolean findNeedle(String needle, String haystack){
		
		if(needle == null || haystack == null || needle.isEmpty() || haystack.isEmpty()){
			return false;
		}
		
		int[] prefix = createPrefixArray(needle);
		
		int m = 0;
		int i = 0;
		
		while(m + i < haystack.length()){
			if(needle.charAt(i) == haystack.charAt(i + m)){
				if(i == needle.length() - 1){
					return true;
				}
				i++;
			} else {
				if(prefix[i] >= 0){   //is there a prefix that is a suffix?
					m = m + i - prefix[i];
					i = prefix[i];
				} else {
					m++;
					i = 0;
				}
			}
		}
		
		return false;
	}
	
	private static int[] createPrefixArray(String pattern){
		int[] T = new int[pattern.length() + 1];
		T[0] = -1;
		T[1] = 0;
		
		int pos = 2;
		int cand = 0;
		
		while(pos < pattern.length()){
			if(pattern.charAt(pos-1) == pattern.charAt(cand)){
				T[pos] = cand + 1;
				cand++;
				pos++;
			} else if(cand > 0){
				cand = T[cand];
			} else {
				T[pos] = 0;
				pos++;
			}
		}
		return T;
	}
}
