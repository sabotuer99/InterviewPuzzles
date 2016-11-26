package puzzles.cracking.chapter1;

public class Rotation {

	
	public static boolean isRotation(String word1, String word2){
		if (word1 == null || word2 == null || word1 == "" || word2 == "" || 
		    word1.length() != word2.length()){
			return false;
		}
			
		String tester = word1 + word1;
		return tester.indexOf(word2) > -1;
	}
}
