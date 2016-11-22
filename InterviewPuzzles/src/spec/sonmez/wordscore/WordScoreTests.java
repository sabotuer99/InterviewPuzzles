package spec.sonmez.wordscore;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.sonmez.wordscore.WordScore;

public class WordScoreTests {

	@Test
	public void GivenXRayMachine_ScoreIs20() {
		String word = "XRay Machine";
		
		int score = WordScore.score(word);
		
		assertEquals(20, score);
	}
	
	@Test
	public void GivenJabbt_ScoreIs13() {
		String word = "Jabbt";
		
		int score = WordScore.score(word);
		
		assertEquals(13, score);
	}
	
	@Test
	public void GivenEmptyString_ScoreIs0() {
		String word = "";
		
		int score = WordScore.score(word);
		
		assertEquals(0, score);
	}
	
	@Test
	public void GivenNumberString_ScoreIs0() {
		String word = "1846347 476467 464637";
		
		int score = WordScore.score(word);
		
		assertEquals(0, score);
	}
	
	@Test
	public void GivenSpecialCharacterString_ScoreIs0() {
		String word = ")$(@^%^%*#*#(   *()(*#&#^#";
		
		int score = WordScore.score(word);
		
		assertEquals(0, score);
	}
	
	@Test
	public void GivenNull_ScoreIs0() {
		String word = null;
		
		int score = WordScore.score(word);
		
		assertEquals(0, score);
	}

}
