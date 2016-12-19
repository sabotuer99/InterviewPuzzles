package puzzles.cracking.moderate;

import java.util.Arrays;

public class TicTacToeChecker {

	public static boolean wonGame(int[][] board, int player){
		int n = board.length;
		boolean[] cols = new boolean[n];
		Arrays.fill(cols, true);
		boolean diag1 = true;
		boolean diag2 = true;
		
		for(int i = 0; i < n; i++){
			boolean row = true;
			for(int j = 0; j < n; j++){
				row = row && (board[i][j] == player);
				cols[j] = cols[j] && (board[i][j] == player);
			}
			if(row){
				return true;
			}
			
			diag1 = diag1 && board[i][i] == player;
			diag2 = diag2 && board[i][n-1-i] == player;
		}
		
		for(boolean col : cols){
			if(col){
				return true;
			}
		}
		
		return diag1 || diag2;
	}
}
