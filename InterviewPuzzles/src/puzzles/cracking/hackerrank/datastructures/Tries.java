package puzzles.cracking.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Scanner;

public class Tries {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Node root = new Node();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if("add".equals(op)){
                root.add(contact);
            } else {
                System.out.println(root.getPrefixCount(contact));
            }
        }
        
        in.close();
    }



    public static class Node {
        public HashMap<Character, Node> children = new HashMap<>();
        public boolean isTerminal = false;
        int prefixCount = 0;

        public void add(String word){
            
            Character first = word.charAt(0);
            Node node = children.get(first);
            if(node == null){
                node = new Node();
                node.prefixCount = 1;
            } else {
                node.prefixCount++;
            }
            if(word.length() == 1){
                node.isTerminal = true;
            } else {
                node.add(word.substring(1));
            }
            children.put(first, node);
        }

        public int getPrefixCount(String pref){
            Character first = pref.charAt(0);
            Node node = children.get(first);
            if(node == null){
                return 0;
            }
            if(pref.length() == 1){
                return node.prefixCount;
            }
            return node.getPrefixCount(pref.substring(1));
        }
    }
}
