package puzzles.cracking.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Subsets {

	public static <T> List<Set<T>> getSubsets(Set<T> set){
		if(set == null || set.size() == 0){
			List<Set<T>> empty = new ArrayList<>();
			empty.add(new HashSet<>());
			return empty;
		}
		
		Set<T> other = new HashSet<>(set);
		List<Set<T>> allSubs = new ArrayList<Set<T>>();
		
		Iterator<T> iter = set.iterator();
		if(iter.hasNext()){
			T item = iter.next();
			other.remove(item);
			List<Set<T>> newSubs = getSubsets(other);
			allSubs.addAll(newSubs);
			
			for(Set<T> sub : newSubs){
				Set<T> newSub = new HashSet<>(sub);
				newSub.add(item);
				allSubs.add(newSub);
			}
			
			
		}
				
		return allSubs;
	}
}
