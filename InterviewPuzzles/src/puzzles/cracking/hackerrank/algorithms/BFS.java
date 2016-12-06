package puzzles.cracking.hackerrank.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFS {
    public static class Graph {
        
        Map<Integer, Node> nodes = new HashMap<>();
        
        private class Node{
            
            List<Node> adjacent = new ArrayList<>();
            public int id;
            
            public int distance = -1;
            
            public Node(int id){
                this.id = id;
            }
           
        }
        
        public Graph(int size) {
            for(int i = 0; i < size; i++){
                nodes.put(i, new Node(i));
            }
        }

        public void addEdge(int first, int second) {
            Node firstNode = nodes.get(first);
            Node secondNode = nodes.get(second);
            
            firstNode.adjacent.add(secondNode);
            secondNode.adjacent.add(firstNode);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            Node start = nodes.get(startId);
            start.distance = 0;
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(start);
            while(queue.size() > 0){
                Node current = queue.poll();
                int dist = current.distance;
                for(Node child : current.adjacent){
                    if(child.distance == -1){
                        child.distance = dist + 6;
                        queue.offer(child);
                    }
                }
            }
            
            int[] dists = new int[nodes.size()];
            for(Node node : nodes.values()){
                dists[node.id] = node.distance;
            }
            return dists;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
