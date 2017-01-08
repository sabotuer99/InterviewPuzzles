package puzzles.kennyyu.misc;

import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
	
	private static boolean twoSum(int[] arr, int start, int k){
		Set<Integer> seen = new HashSet<>();
		for(int i = start; i < arr.length; i++){
			int comp = k - arr[i];
			if(seen.contains(comp)){
				return true;
			} else {
				seen.add(arr[i]);
			}
		}
		
		return false;
	}
	
	public static boolean threeSum(int[] arr, int k){
		for(int i = 0; i < arr.length - 2; i++){
			int comp = k - arr[i];
			if(twoSum(arr, i+1, comp)){
				return true;
			}
		}
		
		return false;
	}

}
