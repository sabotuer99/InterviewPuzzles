package puzzles.kennyyu.misc;

public class Atoi {

	public static int atoi(String a){
		if(a == null || "".equals(a)){
			return 0;
		}
		
		int sign = 1;
		int value = 0;
		if(a.charAt(0) == '-'){
			sign = -1;
		} else {
			value = a.charAt(0) - '0';
		}
		
		for(int i = 1; i < a.length(); i++){
			value *= 10;
			value += a.charAt(i) - '0';
		}
		return value * sign;
	}
	
}
