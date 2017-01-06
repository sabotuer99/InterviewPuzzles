package puzzles.kennyyu.misc;

public class ReverseString {

	public static String reverse(String input){
		
		if(input == null){
			return null;
		}
		
		char[] inputArr = input.toCharArray();
		
		int i = 0;
		int j = input.length() - 1;
		
		for(; i < j; i++, j--){
			char temp = inputArr[i];
			inputArr[i] = inputArr[j];
			inputArr[j] = temp;
		}
		return new String(inputArr);
	}
}
