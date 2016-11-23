package puzzles.kennyyu;

public class Shuffle {

	
	
	
	public static int randbetween(int a, int b){
		
		int range = Math.abs(a - b);
		int start = Math.min(a, b);
		
		return (int)(Math.random() * range) + start;
	}
}
