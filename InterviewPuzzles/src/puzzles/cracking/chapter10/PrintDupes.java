package puzzles.cracking.chapter10;

public class PrintDupes {

	public static void printDupesBit(int[] input){
		int[] bits = new int[1000];
		for(int number : input){
			int bucket = (number-1) / 32;
			int bit = (number-1) % 32;
			
			boolean seen = (bits[bucket] & (1 << bit)) == (1 << bit);
			if(seen){
				System.out.println(number);
			} else {
				bits[bucket] |= (1 << bit);
			}
		}
	}
}
