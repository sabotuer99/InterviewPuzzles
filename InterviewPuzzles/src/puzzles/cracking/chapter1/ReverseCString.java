package puzzles.cracking.chapter1;

public class ReverseCString {

	public static String reverse(String input) {
		if(input == null || input.length() < 2){
			return input;
		}
		
		char[] letters = input.toCharArray();
		int L = 0;
		int R = letters[letters.length - 1] == '\0' ? letters.length - 2 : letters.length - 1;
		
		while(L < R){
			char temp = letters[L];
			letters[L] = letters[R];
			letters[R] = temp;
			L++;
			R--;
		}
		
		return new String(letters);
	}

}
