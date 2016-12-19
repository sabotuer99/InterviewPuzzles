package spec.cracking.moderate;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.moderate.TicTacToeChecker;

public class TicTacToeCheckerTests {

	@Test
	public void WinRow(){
		int[][] board = {{1,1,1},
				        {0,0,0},
				        {0,0,0}};
		
		boolean won = TicTacToeChecker.wonGame(board, 1);
		
		assertTrue(won);
	}
	
	@Test
	public void WinCol(){
		int[][] board = {{1,0,0},
				        {1,0,0},
				        {1,0,0}};
		
		boolean won = TicTacToeChecker.wonGame(board, 1);
		
		assertTrue(won);
	}
	
	@Test
	public void WinDiag(){
		int[][] board = {{1,0,0},
				        {0,1,0},
				        {1,0,1}};
		
		boolean won = TicTacToeChecker.wonGame(board, 1);
		
		assertTrue(won);
	}
	
	@Test
	public void NoWin(){
		int[][] board = {{1,0,1},
				        {0,0,0},
				        {1,0,1}};
		
		boolean won = TicTacToeChecker.wonGame(board, 1);
		
		assertFalse(won);
	}
	
	@Test
	public void WinDiag4x4(){
		int[][] board = {{1,0,0,0},
				        {0,1,0,0},
				        {1,0,1,0},
				        {1,0,0,1}};
		
		boolean won = TicTacToeChecker.wonGame(board, 1);
		
		assertTrue(won);
	}
	
}
