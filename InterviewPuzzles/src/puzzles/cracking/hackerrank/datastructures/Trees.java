package puzzles.cracking.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Trees {
	/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

	The Node class is defined as follows:*/
	    class Node {
	        int data;
	        Node left;
	        Node right;
	     }
	
	    List<Integer> inOrder = new ArrayList<>();
	    boolean checkBST(Node root) {
	        getValues(root);
	        Integer[] values = inOrder.toArray(new Integer[inOrder.size()]);
	        for(int i = 1; i < values.length; i++){
	            if(values[i] <= values[i-1]){
	                return false;
	            }
	        }
	        return true;
	    }

	    void getValues(Node root){
	        if(root == null){
	            return;
	        }
	        getValues(root.left);
	        inOrder.add(root.data);
	        getValues(root.right);
	    }
}
