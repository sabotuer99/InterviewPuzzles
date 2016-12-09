package spec.cracking.chapter10;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter10.ListySearch;
import puzzles.cracking.chapter10.ListySearch.Listy;

public class ListySearchTests {

	@Test
	public void SimpleSequence1(){
		int [] vals = {1,2,3,4,5,6,7,8,9,10};
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(10, test);
		
		assertEquals(9, result);
	}
	
	@Test
	public void SimpleSequence2(){
		int [] vals = {1,2,3,4,5,6,7,8,9,10};
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(5, test);
		
		assertEquals(4, result);
	}
	
	@Test
	public void SimpleSequence3(){
		int [] vals = {1,2,3,4,5,6,7,8,9,10};
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(8, test);
		
		assertEquals(7, result);
	}
	
	@Test
	public void SimpleSequence4(){
		int [] vals = {1,2,3,4,5,6,7,8,9,10};
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(9, test);
		
		assertEquals(8, result);
	}
	
	@Test
	public void SimpleSequence5(){
		int [] vals = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(16, test);
		
		assertEquals(15, result);
	}
	
	@Test
	public void LongSequence1(){
		int [] vals = new int[10000];
		
		for(int i = 0; i < 10000; i++){
			vals[i] = i;
		}
		
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(5000, test);
		
		assertEquals(5000, result);
	}
	
	@Test
	public void LongSequence2(){
		int [] vals = new int[1000000];
		
		for(int i = 0; i < 1000000; i++){
			vals[i] = i;
		}
		
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(700000, test);
		
		assertEquals(700000, result);
	}
	
	@Test
	public void LongSequence3(){
		int [] vals = new int[1000000];
		
		for(int i = 0; i < 1000000; i++){
			vals[i] = i;
		}
		
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(800000, test);
		
		assertEquals(800000, result);
	}
	
	@Test
	public void LongSequence4(){
		int [] vals = new int[1000000];
		
		for(int i = 0; i < 1000000; i++){
			vals[i] = i;
		}
		
		Listy test = new ListySearch.Listy(vals);
		
		int result = ListySearch.search(999999, test);
		
		assertEquals(999999, result);
	}
	
}