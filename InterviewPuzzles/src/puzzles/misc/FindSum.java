package puzzles.misc;

import java.util.HashSet;
import java.util.Set;

/*
 *
 * Found video:
 * https://www.youtube.com/watch?v=XKu_SEDAykw
 * 
 */
public class FindSum {

	public static boolean hasSumUnsorted(int[] nums, int sum) {
		if(nums == null || nums.length == 0){
			return false;
		}
		
		Set<Integer> seen = new HashSet<>();
		
		for(int num : nums){
			int complement = sum - num;
			if(seen.contains(complement)){
				return true;
			}
			seen.add(complement);
		}
		
		return false;
	}
	
	public static boolean hasSum(int[] nums, int sum) {
		if(nums == null || nums.length == 0){
			return false;
		}
		
		int L = 0;
		int R = nums.length - 1;
		
		while(R > L){
			int pairsum = nums[R] + nums[L];
			if(pairsum > sum){
				R--;
			} else if (pairsum < sum){
				L++;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	

}
