package puzzles.cracking.hackerrank.concepts;

import java.util.Scanner;

public class LonelyInt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int a[] = new int[n];
        int a = 0;
        for(int a_i=0; a_i < n; a_i++){
            a ^= in.nextInt();
        }
        System.out.println(a);
        in.close();
    }
    
}
