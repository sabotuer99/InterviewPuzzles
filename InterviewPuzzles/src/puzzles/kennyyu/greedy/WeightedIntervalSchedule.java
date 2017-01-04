package puzzles.kennyyu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedIntervalSchedule {

	private static class WeightedInterval implements Comparable<WeightedInterval>{

		public int id;
		public int start;
		public int finish;
		public int weight;
		
		public WeightedInterval(int start, int finish, int weight, int id) {
			this.id = id;
			this.start = start;
			this.finish = finish;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(WeightedInterval o) {
			// TODO Auto-generated method stub
			return finish - o.finish;
		}
		
		public boolean compatible(WeightedInterval o){
			return start >= o.finish || finish <= o.start;
		}	
	}
	
	public static Set<Integer> maxValueSchedule(int[] s, int[] f, int[] w){
		Set<Integer> solution = new HashSet<>();
		if(s == null || f == null || w == null || s.length != f.length || s.length != w.length || s.length == 0){
			return solution;
		}
		
		List<WeightedInterval> intervals = new ArrayList<>();
		for(int i = 0; i < s.length; i++){
			intervals.add(new WeightedInterval(s[i], f[i], w[i], i));
		}
		Collections.sort(intervals);
		
		int[] backpointers = new int[intervals.size()];
		int[] totals = new int[intervals.size()];
		backpointers[0] = 0;
		totals[0] = intervals.get(0).weight;
		int max = totals[0];
		int maxIndex = 0;
		
		for(int i = 1; i < intervals.size(); i++){
			WeightedInterval current = intervals.get(i);
			backpointers[i] = i;
			totals[i] = current.weight;
			for(int j = 0; j < i && current.compatible(intervals.get(j)); j++){
				int inclusiveWeight = totals[j] + current.weight;
				if(totals[i] < inclusiveWeight){
					totals[i] = inclusiveWeight;
					backpointers[i] = j;
				}
			}
			if(max < totals[i]){
				max = totals[i];
				maxIndex = i;
			}
		}
		
		int inSet = maxIndex;
		int nextId;
		do{
			nextId = intervals.get(inSet).id;
			solution.add(nextId);
			inSet = backpointers[inSet];
		} while (nextId != intervals.get(inSet).id);
		
		return solution;
	}
	
	
	
}
