package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.EnglishInt;

public class EnglishIntTests {

	@Test
	public void ToEnglish_100(){
		long n = 100;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("One Hundred", result);
	}
	
	@Test
	public void ToEnglish_1(){
		long n = 1;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("One", result);
	}
	
	@Test
	public void ToEnglish_NEG1(){
		long n = -1;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("Negative One", result);
	}
	
	@Test
	public void ToEnglish_NEG1000(){
		long n = -1000;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("Negative One Thousand", result);
	}
	
	@Test
	public void ToEnglish_1000001(){
		long n = 1000001;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("One Million, One", result);
	}
	
	@Test
	public void ToEnglish_123456789(){
		long n = 123456789;
		
		String result = EnglishInt.toEnglish(n);
		
		assertEquals("One Hundred Twenty Three Million, Four Hundred Fifty Six Thousand, Seven Hundred Eighty Nine", result);
	}
	
	@Test
	public void ToEnglish_LONGMIN(){
		long n = Long.MIN_VALUE;
		
		String result = EnglishInt.toEnglish(n);
		
		System.out.println(result);
		//assertEquals("One Hundred Twenty Three Million, Four Hundred Fifty Six Thousand, Seven Hundred Eighty Nine", result);
	}
}
