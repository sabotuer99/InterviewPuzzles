package puzzles.kennyyu.greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongDagPath {

	public static class Graph{
		Set<Integer> nodes = new HashSet<>();
		Map<Integer, List<Edge>> adjList = new HashMap<>();
		
		private class Edge{
			public int end;
			public int weight;
			public Edge(int end, int weight){
				this.end = end;
				this.weight = weight;
			}
		}
		
		public void addEdge(int u, int v, int weight){
			nodes.add(u);
			nodes.add(v);
			
			List<Edge> uedges = adjList.get(u);
			if(uedges == null){
				uedges = new ArrayList<>();
			}
			
			List<Edge> vedges = adjList.get(v);
			if(vedges == null){
				vedges = new ArrayList<>();
				adjList.put(v, vedges);
			}
			
			uedges.add(new Edge(v, weight));
			adjList.put(u, uedges);
		}
		
		public List<Integer> topoSort(){
			Deque<Integer> stack = new ArrayDeque<>();
			Set<Integer> seen = new HashSet<>();
			for(Integer node : nodes){
				if(!seen.contains(node)){
					seen.add(node);
					dfs(node,stack,seen);
				}
			}
			return new ArrayList<Integer>(stack);
		}
		
		private void dfs(Integer node, Deque<Integer> stack, Set<Integer> seen){
			List<Edge> outgoing = adjList.get(node);
			for(Edge edge : outgoing){
				if(!seen.contains(edge.end)){
					seen.add(edge.end);
					dfs(edge.end, stack, seen);
				}
			}
			stack.push(node);
		}
		
		public int longestPath(){
			if(nodes.size() == 0){
				return 0;
			}
			
			List<Integer> topoNodes = topoSort();
			Map<Integer, Integer> dists = new HashMap<>();
			for(Integer node : nodes){
				dists.put(node, 0);
			}
			int max = 0;
			
			for(Integer node : topoNodes){
				List<Edge> outgoing = adjList.get(node);
				int currentDist = dists.get(node);
				for(Edge edge : outgoing){
					int edgeDist = dists.get(edge.end);
					int newDist = Math.max(edgeDist, currentDist + edge.weight);
					dists.put(edge.end, newDist);
					max = Math.max(max, newDist);
				}
			}
			return max;
		}
	}
}
