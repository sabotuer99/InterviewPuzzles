package puzzles.cracking.moderate;

public class ContiguousSequence {

	public static int maxSeq(int[] arr){
		if(arr == null || arr.length == 0){
			return 0;
		}
		
		int prev = arr[0] < 0 ? 0 : arr[0];
		int max = prev;
		
		for(int i = 1; i <= arr.length; i++){
			if(i == arr.length || arr[i] + prev < 0){
				max = Math.max(max, prev);
				prev = 0;
			} else {
				prev += arr[i];
			}
		}
		
		return max;
	}
	
}
