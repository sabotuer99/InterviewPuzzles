package puzzles.cracking.hackerrank.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Stacks {
    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < expression.length(); i++){
            Character next = expression.charAt(i);
            if("({[".indexOf(next) > -1){
                stack.push(next);
            } else {
                if(stack.size() == 0)
                    return false;
                Character top = stack.pop();
                if("({[".indexOf(top) != ")}]".indexOf(next))
                    return false;
            }
        }
        return stack.size() == 0;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}
