package spec.cracking.chapter10;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter10.AnagramSort;

public class AnagramSortTests {

	@Test
	public void AnagramSortTest(){
		String[] words = {"anna", "banana", "apple", "naan"};
		
		String[] result = AnagramSort.anagramSort(words);
		List<String> resultList = Arrays.asList(result);
		
		int annaIndex = resultList.indexOf("anna");
		int naanIndex = resultList.indexOf("naan");
		
		assertEquals(1, Math.abs(annaIndex - naanIndex) );
	}
}
