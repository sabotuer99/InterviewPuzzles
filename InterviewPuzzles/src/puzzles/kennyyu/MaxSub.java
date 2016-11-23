package puzzles.kennyyu;

public class MaxSub {

	public static int maxsubarray(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int[] D = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++){
			if(i == 0){
				if(nums[0] > 0){
					D[0] = nums[0];
				}
			} else {
				if(nums[i] + D[i-1] > 0){
					D[i] = nums[i] + D[i-1];
				}
			}
		}
		
		int max = 0;
		for(int sub : D){
			max = Math.max(max, sub);
		}
		
		return max;
	}

}
