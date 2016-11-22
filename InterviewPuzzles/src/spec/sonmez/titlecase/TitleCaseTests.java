package spec.sonmez.titlecase;

import puzzles.sonmez.titlecase.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TitleCaseTests {

	@Test
	public void OneWordTitle() {
		String title = "blah";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blah", result);
	}
	
	@Test
	public void TwoWordTitle() {
		String title = "blahdy blah";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blahdy Blah", result);
	}

	@Test
	public void ThreeWordTitle_NoIgnoreWords() {
		String title = "blah your blarg";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blah Your Blarg", result);
	}
	
	@Test
	public void ThreeWordTitle_WithIgnoreWords() {
		String title = "blah and blah";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blah and Blah", result);
	}
	
	@Test
	public void LongTitle_WithIgnoreWords() {
		String title = "the catcher in the rye went to market";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("The Catcher in the Rye Went to Market", result);
	}

	@Test
	public void TwoWordTitle_WeirdCaps() {
		String title = "blahDY bLaH";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blahdy Blah", result);
	}

	@Test
	public void ThreeWordTitle_NoIgnoreWords_WeirdCaps() {
		String title = "blah YOUR BlaH";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blah Your Blah", result);
	}
	
	@Test
	public void ThreeWordTitle_WithIgnoreWords_WeirdCaps() {
		String title = "blah AND BlaH";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("Blah and Blah", result);
	}
	
	@Test
	public void EmptyString_ReturnsEmptyString() {
		String title = "";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("", result);
	}
	
	@Test
	public void NullInput_ReturnsEmptyString() {
		
		String result = TitleCase.toTitleCase(null);
		
		assertEquals("", result);
	}
	
	@Test
	public void NumericString_ReturnsSameString() {
		String title = "1984";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("1984", result);
	}
	
	@Test
	public void SpecialCharactersString_ReturnsSameString() {
		String title = "!@#$%$% ^&*())^ %$%$#$";
		
		String result = TitleCase.toTitleCase(title);
		
		assertEquals("!@#$%$% ^&*())^ %$%$#$", result);
	}
	
}
