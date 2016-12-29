package puzzles.cracking.moderate;

public class SubSort {

	public static int[] subSort(int[] arr) {
		if(arr == null || arr.length == 1){
			return null;
		}
		
		int firstInversion = findInversion(arr, 0, arr.length - 1);
		int lastInversion = findBackwardInv(arr, 0, arr.length - 1);
		
		if(firstInversion == -1){
			return null;
		}
		int [] result = {firstInversion, lastInversion};
		return result;
	}

	
	
	
	
	
	


	private static int findInversion(int[] arr, int start, int end) {
		if(start >= end){
			return -1;  //can't be an inversion in an array of 0 or 1 length
		}
		
		int i = start + 1;
		
		for(; i <= end && arr[i] > arr[i-1]; i++){}
		
		if(i > end){
			return -1; //array was sorted
		} else {
			int min = findMin(arr, i, end);
			for(int j = start; j <= end; j++){
				if(arr[j] >= min){
					return j;
				}
			}
		}
		return -1;
	}
	
	private static int findMin(int[] arr, int start, int end) {
		int min = arr[start];
		for(int i = start; i <= end; i++){
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	private static int findBackwardInv(int[] arr, int start, int end) {
		if(start >= end){
			return -1;  //can't be an inversion in an array of 0 or 1 length
		}
		
		int i = end - 1;
		
		for(; i >= start && arr[i] < arr[i+1]; i--){}
		
		if(i < start){
			return -1; //array was sorted
		} else {
			int max = findMax(arr, start, i);
			for(int j = end; j >= start; j--){
				if(arr[j] <= max){
					return j;
				}
			}
		}
		return -1;
	}
	
	private static int findMax(int[] arr, int start, int end) {
		int max = arr[end];
		for(int i = start; i <= end; i++){
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}
