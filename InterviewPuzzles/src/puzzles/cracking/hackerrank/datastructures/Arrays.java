package puzzles.cracking.hackerrank.datastructures;

import java.util.Scanner;

public class Arrays {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] b = new int[a.length];
        for(int i = 0; i < n; i++){
            int shiftdex = (n-k+i)%n;
            b[shiftdex] = a[i];
        }
        return b;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
        in.close();
    }
}
