package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;



public class PathInGraph {

	public static boolean isPath(GraphNode start, GraphNode end){
		if(start == null || end == null){
			return false;
		}
		
		Deque<GraphNode> q = new ArrayDeque<>();
		q.offer(start);
		GraphNode current = start;
		while(q.size() > 0 && current != end){
			current = q.poll();
			current.visited = true;
			for(GraphNode child : current.children){
				if(!child.visited){
					q.offer(child);
				}
			}
		}
		return current == end;
	}
}
