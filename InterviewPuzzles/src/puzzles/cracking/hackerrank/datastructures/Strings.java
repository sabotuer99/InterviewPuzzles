package puzzles.cracking.hackerrank.datastructures;

import java.util.Scanner;

public class Strings {
    public static int numberNeeded(String first, String second) {
        int[] firstArr = new int[26];
        int[] secondArr = new int[26];
        
        for(char letter : first.toCharArray()){
            firstArr[letter - 'a']++;
        }
        for(char letter : second.toCharArray()){
            secondArr[letter - 'a']++;
        }
        
        int deletions = 0;
        for(int i = 0; i < 26; i++){
            deletions += Math.abs(firstArr[i] - secondArr[i]);
        }
        return deletions;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
