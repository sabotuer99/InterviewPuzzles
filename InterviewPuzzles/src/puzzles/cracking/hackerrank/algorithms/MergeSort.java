package puzzles.cracking.hackerrank.algorithms;

import java.util.Scanner;

public class MergeSort {

    public static void mergesort(int[] array){
        mergesort(array, new int[array.length], 0, array.length -1);
    }
    
    public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd)/2;
        mergesort(array, temp, leftStart, middle);
        mergesort(array, temp, middle + 1, rightEnd);
        merge(array, temp, leftStart, middle, rightEnd);
    }
    
    private static int inversions = 0;
    public static void merge(int[] array, int[] temp, int leftStart, int middle, int rightEnd){
        int leftEnd = middle;
        int rightStart = middle + 1;
        int size = rightEnd - leftStart + 1;
        
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                inversions += middle - left + 1;
                right++;
            }    
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
    
    public static long countInversions(int[] arr){
        mergesort(arr);
        return inversions;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
        in.close();
    }
    
    
}
