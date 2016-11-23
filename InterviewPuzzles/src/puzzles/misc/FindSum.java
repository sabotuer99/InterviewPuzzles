package puzzles.misc;
/*
 *
 * Found video:
 * https://www.youtube.com/watch?v=XKu_SEDAykw
 * 
 */
public class FindSum {

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
