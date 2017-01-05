package puzzles.kennyyu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knapsack {

	private static class Item implements Comparable<Item>{
		public int id;
		public int weight;
		public int value;
		
		public Item(int weight, int value, int id){
			this.weight = weight;
			this.value = value;
			this.id = id;
		}

		@Override
		public int compareTo(Item o) {
			if(o.weight != weight){
				return weight - o.weight;
			} else {
				return o.value - value;
			}
		}
	}
	
	public static Set<Integer> bestItems(int[] w, int[] v, int limit){
		if(w == null || v == null || w.length != v.length){
			return null;
		}
		
		int[][] DP = new int[w.length + 1][limit + 1];
		
		//put everything in order
		List<Item> items = new ArrayList<>();
		for(int i = 0; i < w.length; i++){
			items.add(new Item(w[i], v[i], i));
		}
		Collections.sort(items);
		
		for(int i = 0; i < items.size(); i++){
			Item item = items.get(i);
			for(int j = 0; j < limit; j++){
				int row = i + 1;
				int col = j + 1;
				if(item.weight > col){ //item is too heavy for this column
					DP[row][col] = DP[row-1][col];
				} else {
					int woItem = DP[row-1][col];
					int withItem = DP[row-1][col - item.weight] + item.value;
					int max = Math.max(woItem, withItem);
					DP[row][col] = max;
				}
			}
		}
		
		Set<Integer> solution = new HashSet<>();
		for(int row = items.size(), col = limit; row > 0; row--){
			if(DP[row][col] != DP[row-1][col]){
				int i = row - 1;
				Item item = items.get(i);
				solution.add(item.id);
				col -= item.weight;
			}
		}
		
		return solution;
	}
	
}
