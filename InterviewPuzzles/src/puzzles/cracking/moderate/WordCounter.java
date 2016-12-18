package puzzles.cracking.moderate;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

	Map<String, Integer> counts = new HashMap<>();
	int size = 0;
	public void count(String word){
		int current = counts.containsKey(word) ? counts.get(word) : 0;
		counts.put(word, current + 1);
		size++;
	}
	
	public double getFrequency(String word){
		double count = counts.containsKey(word) ? counts.get(word) : 0;
		return count / size;
	}
	
	public void load(InputStream book){
		Scanner bookStream = new Scanner(book);
		try{
			while(bookStream.hasNext()){
				count(bookStream.next().replaceAll("[^A-Za-z]", ""));
			}
		} finally {
			bookStream.close();
		}	
	}
}
