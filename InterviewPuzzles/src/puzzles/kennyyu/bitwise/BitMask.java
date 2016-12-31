package puzzles.kennyyu.bitwise;

import java.util.regex.Pattern;

public class BitMask {

	public static String missingLetters(String input){
		
		if(input == null || Pattern.matches(".*[^a-z].*", input)){
			return null;
		}
		
		
		int bits = 0;
		for(int i = 0; i < input.length(); i++){
			int index = input.charAt(i) - 'a';
			bits = setBit(bits, index);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++){
			if( !isSet(bits, i)){
				sb.append((char)(i + 'a'));
			}
		}
		return sb.toString();
	}

	private static boolean isSet(int bits, int index) {
		return (((bits >> index)) & 1) == 1;
	}

	private static int setBit(int bits, int index) {
		return bits | 1 << index;
	}
}
