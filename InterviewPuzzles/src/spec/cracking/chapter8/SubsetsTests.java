package spec.cracking.chapter8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import puzzles.cracking.chapter8.Subsets;

public class SubsetsTests {

	@Test
	public void StringSubs_ABCD(){
		
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		
		List<Set<String>> result = Subsets.getSubsets(set);
		
		assertEquals(16, result.size());
		
		for(Set<String> sub : result){
			System.out.println(Arrays.toString(sub.toArray(new String[sub.size()])));
		}
	}
	
}
