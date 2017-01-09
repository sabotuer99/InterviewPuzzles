package spec.cracking.moderate.langtons;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.langtons.Board;
import puzzles.cracking.moderate.langtons.Point;

public class BoardTests {

	@Test
	public void toString_NewBoard_3x3Area(){
		
		Board sut = new Board();
		String result = sut.toString();
		String expected = "   \n" + 
		                  "   \n" + 
				          "   \n";
		
		System.out.println(result);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void toString_PositionFlipped_BiggerArea(){
		
		Board sut = new Board();
		sut.flipGridSquare(new Point(0,1));
		String result = sut.toString();
		String expected = "   \n" +
				          " X \n" + 
		                  "   \n" + 
				          "   \n";
		
		System.out.println(result);
		
		assertEquals(expected, result);
	}
	
}
