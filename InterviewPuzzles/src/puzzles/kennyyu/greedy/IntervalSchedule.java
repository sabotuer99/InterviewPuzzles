package puzzles.kennyyu.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntervalSchedule {

	private static class Interval implements Comparable<Interval>{
		public int start;
		public int finish;
		public int id;

		public Interval(int start, int finish, int id){
			this.start = start;
			this.finish = finish;
			this.id = id;
		}
		
		
		@Override
		public int compareTo(Interval o) {
			return finish - o.finish;
		}
		
		public boolean compatible(Interval o) {	
			return start >= o.finish;
		}	
		
		@Override
		public String toString(){
			return String.format("{%d: %d-%d}", id, start, finish);
		}
	}
	
	public static Set<Integer> largestSchedule(int[] starts, int[] finishes){
		Set<Integer> solution = new HashSet<>();
		if(starts == null || finishes == null || starts.length != finishes.length){
			return solution;
		}
		
		List<Interval> intervals = new ArrayList<>();
		for(int i = 0; i < starts.length; i++){
			intervals.add(new Interval(starts[i], finishes[i], i));
		}
		
		Collections.sort(intervals);
		System.out.println(Arrays.toString(intervals.toArray()));
		
		Map<Integer, Set<Integer>> DP = new HashMap<>();
		Set<Integer> base = new HashSet<>();
		base.add(intervals.get(0).id);
		DP.put(0, base);
		
		for(int i = 1; i < intervals.size(); i++){
			Set<Integer> bestSubSet = new HashSet<>();
			Interval currentInterval = intervals.get(i);
			
		    int bestId = -1;
		    int bestSize = 0;
			for(int j = 0; j < i && currentInterval.compatible(intervals.get(j)); j++){
				if(bestSize < DP.get(j).size()){
					bestSize = DP.get(j).size();
					bestId = j;
				}
			}
			if(bestId >= 0){
				bestSubSet = new HashSet<Integer>(DP.get(bestId));
			}
			bestSubSet.add(currentInterval.id);
			DP.put(i, bestSubSet);
			if(solution.size() < bestSubSet.size()){
				solution = bestSubSet;
			}
			System.out.println(Arrays.toString(solution.toArray()));
		}
		
		return solution;
		
	}
	
}
