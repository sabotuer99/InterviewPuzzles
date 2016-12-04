package puzzles.cracking.hackerrank.datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heaps {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
      
        PriorityQueue<Integer> rightHalf = new PriorityQueue<>(n/2 + 1);
        PriorityQueue<Integer> leftHalf = new PriorityQueue<>(n/2 + 1, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 > o2){
                    return -1;
                }
                if(o1 < o2){
                    return 1;
                }
                return 0;
            } 
        });
       
        initialize(a[0], a[1], leftHalf, rightHalf);   
        
        for(int i = 2; i < n; i++){
            insert(a[i], leftHalf, rightHalf);
            double median = calculateMedian(leftHalf, rightHalf);
            System.out.printf("%.1f\n", median);
        }
    }
    
    public static void initialize(int first, int second, PriorityQueue<Integer> leftHalf, PriorityQueue<Integer> rightHalf){
        System.out.printf("%.1f\n", (double)first);
        System.out.printf("%.1f\n", (first + second) / 2.0);
        if(first < second){
            leftHalf.offer(first);
            rightHalf.offer(second);
        } else {
            leftHalf.offer(second);
            rightHalf.offer(first);
        }
        
    }
    
    public static double calculateMedian(PriorityQueue<Integer> leftHalf, PriorityQueue<Integer> rightHalf){
        if(leftHalf.size() > rightHalf.size()){
            return leftHalf.peek();
        }
        if(leftHalf.size() < rightHalf.size()){
            return rightHalf.peek();
        }
        return (leftHalf.peek() + rightHalf.peek())/2.0;
    }
    
    public static void insert(int val, PriorityQueue<Integer> leftHalf, PriorityQueue<Integer> rightHalf){        
        
        //System.out.printf("Inserting %d, Left: %d size, %d max;  Right: %d size, %d min;\n", val, leftHalf.size(), leftHalf.peek(), rightHalf.size(), rightHalf.peek());
        int right = rightHalf.peek();
        int left = leftHalf.peek();
        
        
        if(val > right){
            log("Branch A");
            if(rightHalf.size() > leftHalf.size()){
                log("Branch A1");
                int minRight = rightHalf.poll();
                leftHalf.offer(minRight);
            }
            rightHalf.offer(val);
        } else if(val < left) {
            log("Branch B");
            if(leftHalf.size() > rightHalf.size()){
                log("Branch B1");
                int maxLeft = leftHalf.poll();
                rightHalf.offer(maxLeft);
            }
            leftHalf.offer(val);
        } else {
            log("Branch C");
           if(leftHalf.size() > rightHalf.size()){
               
                rightHalf.offer(val);
            } else {
               leftHalf.offer(val);
           }
            
        }
        
        //System.out.printf("Inserted %d, Left: %d size, %d max;  Right: %d size, %d min;\n", val, leftHalf.size(), leftHalf.peek(), rightHalf.size(), rightHalf.peek());
    }
    
    public static void log(String message){
        //System.out.println(message);
    }
}
