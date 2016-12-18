package spec.cracking.moderate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import puzzles.cracking.moderate.WordCounter;

public class WordCounterTests {

	@Test
	public void CanLoadTestFile() throws FileNotFoundException{
		WordCounter sut = new WordCounter();
		
		InputStream test = this.getClass().getResourceAsStream("test.txt");
		
		sut.load(test);
	}
	
	@Test
	public void CanLoadRomeoFile() throws FileNotFoundException{
		WordCounter sut = new WordCounter();
		
		InputStream romeo = this.getClass().getResourceAsStream("romeo.txt");
		
		sut.load(romeo);
	}
	
	@Test
	public void GetsCountsFromRomeo() throws FileNotFoundException{
		WordCounter sut = new WordCounter();
		
		InputStream romeo = this.getClass().getResourceAsStream("romeo.txt");
		
		sut.load(romeo);
		
		System.out.println(sut.getFrequency("Romeo"));
		System.out.println(sut.getFrequency("Juliet"));
		System.out.println(sut.getFrequency("thee"));
	}
	
	
	@Test
	public void GetsCountsFromTestWithZeroFreq() throws FileNotFoundException{
		WordCounter sut = new WordCounter();
		
		InputStream test = this.getClass().getResourceAsStream("test.txt");
		
		sut.load(test);
		
		System.out.println(sut.getFrequency("Computer"));
	}
}
