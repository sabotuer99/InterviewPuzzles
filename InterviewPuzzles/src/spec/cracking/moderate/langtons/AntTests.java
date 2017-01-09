package spec.cracking.moderate.langtons;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.langtons.Ant;

public class AntTests {

	@Test
	public void BasicTest(){
		Ant ant = new Ant();
		int k = 4;
		ant.printKMoves(k);
		
		String expected = "    \n" +
		                  " XX \n" + 
				          " XX \n" + 
		                  "    \n";
		
		assertEquals(expected, ant.getBoard().toString());
	}
	
	@Test
	public void TestK9(){
		Ant ant = new Ant();
		int k = 9;
		ant.printKMoves(k);
		String expected = "     \n" +
                          "  XX \n" + 
		                  " XXX \n" + 
                          " XX  \n" +
                          "     \n";
		
		assertEquals(expected, ant.getBoard().toString());
	}
	
	@Test
	public void BigTest_Highway(){
		Ant ant = new Ant();
		int k = 11000;
		ant.printKMoves(k);
	}
}
