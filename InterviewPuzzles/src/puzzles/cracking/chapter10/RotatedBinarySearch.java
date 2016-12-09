package puzzles.cracking.chapter10;

public class RotatedBinarySearch {


	public static int search(int value, int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		return search(value, 0, nums.length - 1, nums);
	}
	
	private static int search(int value, int left, int right, int[] nums){
		if(right < left){
			return -1;
		}
		int middle = (left + right) / 2;
		if(nums[middle] == value){
			return middle;
		}
		
		if(nums[middle] > nums[right]){
			if(value < nums[right] || value > nums[middle]){
				return search(value, middle + 1, right, nums);
			} else {
				return search(value, left, middle - 1, nums);
			}
		} else {
			if(value > nums[middle]){
				return search(value, middle + 1, right, nums);
			} else {
				return search(value, left, middle - 1, nums);
			}
		}
	}

}
