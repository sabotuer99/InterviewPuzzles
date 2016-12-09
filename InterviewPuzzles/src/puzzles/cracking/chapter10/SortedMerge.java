package puzzles.cracking.chapter10;

public class SortedMerge {

	public static int[] merge(int[] a, int[] b, int endA) {
		if(b == null || b.length == 0) { return a;}
		if(a == null || a.length == 0 || endA == 0) { return b;}
		
		int endB = b.length - 1;
		
		for(int last = endA + b.length; last >= 0 && endB >= 0; last--){
			if(b[endB] > a[endA]){
				a[last] = b[endB];
				endB--;
			} else {
				a[last] = a[endA];
				endA--;
			}
		}
		
		return a;
	}

}
