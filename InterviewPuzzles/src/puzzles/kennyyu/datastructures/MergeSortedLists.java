package puzzles.kennyyu.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLists {

	private static class Wrapper{
		public int index;
		public int value;
		
		public Wrapper(int value, int index){
			this.index = index;
			this.value = value;
		}
		
		public static Comparator<Wrapper> getComparator(){
			return new Comparator<Wrapper>(){
				@Override
				public int compare(Wrapper o1, Wrapper o2) {
					return o1.value - o2.value;
				}};
		}
	}
	
	public static Integer[] merge(int[]... lists){
		
		int[] pointers = new int[lists.length];
		PriorityQueue<Wrapper> q = new PriorityQueue<Wrapper>(10, Wrapper.getComparator());
		
		for(int i = 0; i < lists.length; i++){
			if(lists[i] != null && lists[i].length > 0){
				q.add(new Wrapper(lists[i][0], i));
			}
		}
		
		List<Integer> merged = new ArrayList<>();
		
		while(q.size() > 0){
			Wrapper min = q.poll();
			merged.add(min.value);
			int i = min.index;
			pointers[i]++;
			int next = pointers[i];
			if(next < lists[i].length){
				q.add(new Wrapper(lists[i][next], i));
			}
		}
		
		return merged.toArray(new Integer[merged.size()]);
	}
	

	
}
