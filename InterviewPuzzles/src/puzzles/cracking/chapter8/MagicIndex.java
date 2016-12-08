package puzzles.cracking.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicIndex {

	public static List<Integer> findMagicIndices(int[] array){
		if(array == null){
			return new ArrayList<>();
		}
		
		int L = 0;
		int R = array.length -1;
		int mid = (L + R)/2;
		
		while(L < R && mid != array[mid]){
			mid = (L + R)/2;
			if(mid < array[mid]){
				L = mid;
			} else {
				R = mid;
			}
		}
		
		if(mid == array[mid]){
			L = mid;
			R = mid;
			while(R + 1 < array.length && array[R + 1] == R + 1){
				R++;
			}
			while(L - 1 >= 0 && array[L - 1] == L - 1){
				L--;
			}
			
			return copySubArrayToList(array, L, R);
		} else {
			return new ArrayList<>();
		}
		
	}
	
	private static List<Integer> copySubArrayToList(int[] source, int left, int right){
		List<Integer> list = new ArrayList<>();
		for(int i = left; i <= right; i++){
			list.add(source[i]);
		}
		return list;
	}
}
