package puzzles.kennyyu.misc;

import java.util.Arrays;

public class DutchFlag {

	public static void dutchify(int[] arr, int low, int high){
		if(arr == null || arr.length == 0){
			return;
		}
		
		int mid = 0;
		int lower = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < low){
				lower++;
			} else if(arr[i] <= high){
				mid++;
			}
		}
		
		int highi = lower + mid;
		int midi = lower;
		int lowi = 0;
		
		while(lowi < lower){
			printState(arr, lowi, midi, highi);
			if(arr[lowi] < low){
				lowi++;
			} else if(arr[lowi] <= high){
				swap(arr, lowi, midi);
				midi++;
			} else {
				swap(arr, lowi, highi);
				highi++;
			}
			
		}
		printState(arr, lowi, midi, highi);
		
		while(midi < lower + mid && highi < arr.length){
			if(arr[midi] <= high){
				midi++;
			} else {
				swap(arr, midi, highi);
				highi++;
			}
			printState(arr, lowi, midi, highi);
		}
	}

	private static void printState(int[] arr, int lowi, int midi, int highi) {
		String arrStr = Arrays.toString(arr);
		System.out.println(arrStr);
		char[] pointers = new char[arrStr.length()];
		char[] letters = new char[arrStr.length()];
		
		for(int i = 0; i < arrStr.length(); i++){
			pointers[i] = ' ';
			letters[i] = ' ';
		}
		
		monkey(arrStr, pointers, lowi, '^');
		monkey(arrStr, letters, lowi, 'L');
		monkey(arrStr, pointers, midi, '^');
		monkey(arrStr, letters, midi, 'M');
		monkey(arrStr, pointers, highi, '^');
		monkey(arrStr, letters, highi, 'H');
		System.out.println(new String(pointers));
		System.out.println(new String(letters));
	}

	private static void monkey(String text, char[] arr, int i, char c) {
		
		if(i == 0){
			arr[1] = c;
			return;
		}
		
		int j = text.indexOf(",");
		int count = 1;
		while(j != -1 && count < i){
			j = text.indexOf(",", j+1);
			count++;
		}
		
		if(j == -1){
			arr[arr.length - 1] = c;
		} else {
			arr[j+2] = c;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
