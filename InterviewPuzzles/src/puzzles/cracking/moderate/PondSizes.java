package puzzles.cracking.moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {

	public static int pondsize(int[][] grid, int row, int col){
		if(row < 0 || col < 0 || grid == null || 
				row >= grid.length || col >= grid[0].length || 
				grid[row][col] != 0){
			return 0;
		}
		
		int size = 1;
		grid[row][col] = 1;
		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				size += pondsize(grid, row + i, col + j);
			}
		}
		return size;
	}
	
	public static List<Integer> findAllPonds(int[][] grid){
		if(grid == null){
			return null;
		}
		
		List<Integer> sizes = new ArrayList<>();
		
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				int size = pondsize(grid, row, col);
				if(size > 0){
					sizes.add(size);
				}
			}
		}
		
		return sizes;
	}
	
}
