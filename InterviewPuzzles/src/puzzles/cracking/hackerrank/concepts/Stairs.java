package puzzles.cracking.hackerrank.concepts;

import java.util.Scanner;

public class Stairs {
    public static int stairs(int n){
        int[] DP = new int[Math.max(n+1, 3)];
        
        //base cases
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;
        if(n < 3){
            return DP[n];
        }
        
        for(int i = 3; i <= n; i++){
            DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
        }
        
        return DP[n];
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(stairs(n));
        }
        in.close();
    }
}
