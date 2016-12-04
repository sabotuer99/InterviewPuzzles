package puzzles.cracking.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTables {
    Map<String, Integer> magazineMap = new HashMap<>();
    Map<String, Integer> noteMap = new HashMap<>();
    
    public HashTables(String magazine, String note) {
        mappify(magazine, magazineMap);
        mappify(note, noteMap);
    }
    
    private void mappify(String words, Map<String, Integer> map){
        for(String word : words.split(" ")){
            Integer count = map.containsKey(word) ? map.get(word) : 0;
            count++;
            map.put(word, count);
        }
    }
    
    
    public boolean solve() {
        for(String word : noteMap.keySet()){
            Integer noteCount = noteMap.get(word);
            Integer magCount = magazineMap.get(word);
            
            if(magCount == null || magCount < noteCount){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        HashTables s = new HashTables(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
