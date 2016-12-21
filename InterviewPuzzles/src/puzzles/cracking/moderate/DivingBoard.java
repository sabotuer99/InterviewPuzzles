package puzzles.cracking.moderate;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {

	public static Set<Double> calculateLengths(double longB, double shortB, int k){
		
		Set<Double> boards = new HashSet<>();
		boards.add(0.0);
		
		for(int i = 0; i < k; i++){
			Set<Double> next = new HashSet<>();
			for(Double prev : boards){
				next.add(prev + longB);
				next.add(prev + shortB);
			}
			boards = next;
		}
		
		return boards;
	}
	
}
