package puzzles.cracking.chapter1;

public class RectMatrix {

	public static int[][] clobberRowCol(int[][] input){
		if(input == null || input.length == 0){
			return input;
		}
		
		int rows = input.length;
		int cols = input[0].length;
		boolean[] deadcol = new boolean[cols];
		int[][] result = new int[rows][cols];
		
		for(int row = 0; row < rows; row++){
			boolean deadrow = false;
			for(int col = 0; col < cols; col++){
				if(deadrow || deadcol[col]){
					result[row][col] = 0;
					continue;
				} else if(input[row][col] == 0){
					deadrow = true;
					deadcol[col] = true;
					for(int i = 0; i <= col; i++){
						result[row][i] = 0;
					}
					for(int j = 0; j < row; j++){
						result[j][col] = 0;
					}
				} else {
					result[row][col] = input[row][col];
				}
			}
		}
		
		return result;
	}
	
}
