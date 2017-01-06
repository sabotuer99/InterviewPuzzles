package puzzles.kennyyu.misc;

import java.util.HashSet;
import java.util.Set;

public class FindRepeats {

	public static Set<Integer> findRepeats(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		
		Set<Integer> solution = new HashSet<>();
		for(int i = 0; i < arr.length; i++){
			int index = Math.abs(arr[i]);
			if(index >= arr.length){
				return null;
			}
			
			if(arr[index] < 0 ){
				solution.add(index);
			} else {
				arr[index] *= -1;
			}
			
		}
		
		return solution;
	}
	
}
