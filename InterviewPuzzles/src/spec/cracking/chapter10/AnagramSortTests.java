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
	
	@Test
	public void AnagramBiggerSortTest(){
		String[] words = {"anna", "banana", "apple", "naan", "butt" , "ananab", "paple", "moon"};
		
		String[] result = AnagramSort.anagramSort(words);
		List<String> resultList = Arrays.asList(result);
		
		int ind1 = resultList.indexOf("anna");
		int ind2 = resultList.indexOf("naan");
		int ind3 = resultList.indexOf("paple");
		int ind4 = resultList.indexOf("apple");
		
		assertEquals(1, Math.abs(ind1 - ind2));
		assertEquals(1, Math.abs(ind3 - ind4));
	}
}
