package puzzles.cracking.hackerrank.concepts;

import java.util.Scanner;

public class Fibonacci {
    
    public static int fibonacci(int n) {
        // Complete the function.
        if(n==0)
            return 0;
        int fib1 = 0;
        int fib2 = 1;
        int total = fib1 + fib2;
        for(int i = 1; i < n; i++){
            total = fib1 + fib2;
            fib1 = fib2;
            fib2 = total;
        }
      return total;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
