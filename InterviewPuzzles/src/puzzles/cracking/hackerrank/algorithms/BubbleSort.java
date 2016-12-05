package puzzles.cracking.hackerrank.algorithms;

import java.util.Scanner;

public class BubbleSort {

    static int swaps = 0;
    static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        swaps++;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        
        int lastUnsorted = n - 1;
        while(lastUnsorted > 0){
            for(int i = 0; i < lastUnsorted; i++){
                if(a[i] > a[i+1])
                    swap(i, i+1, a);

            }
            lastUnsorted--;
        }
        
        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d", a[n-1]);
    }
}
