package puzzles.kennyyu;

public class Shuffle {

	public static int[] shuffle(int[] arr){
		if(arr == null){
			return null;
		}
		
		for(int i =0; i < arr.length; i++){
			int k = randbetween(i, arr.length);
			int t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
		}
		
		return arr;
	}
	
	
	public static int randbetween(int a, int b){
		
		int range = Math.abs(a - b);
		int start = Math.min(a, b);
		
		return (int)(Math.random() * range) + start;
	}
}
