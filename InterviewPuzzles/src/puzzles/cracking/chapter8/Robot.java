package puzzles.cracking.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {

	public static int getCell(int[][] grid, int row, int col){
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
			return -1;
		} else {
			return grid[row][col];
		}
	}
	
	public static List<Coord> findPath(int[][] grid){
		if(grid == null){
			return new ArrayList<>();
		}
		grid[0][0] = 1;
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(row == 0 && col == 0)
					continue;
				boolean reachable = (getCell(grid, row - 1, col) == 1 ||
						            getCell(grid, row, col - 1) == 1) &&
						            getCell(grid, row, col) != -1;
				grid[row][col] = reachable ? 1 : -1;
			}
			System.out.println(Arrays.toString(grid[row]));
		}
		
		return trackback(grid);
	}

	private static List<Coord> trackback(int[][] grid) {
		if(grid == null || grid[grid.length - 1][grid[0].length - 1] != 1){
			return new ArrayList<>();
		}
		
		List<Coord> coords = new ArrayList<>();
		int row = grid.length - 1;
		int col = grid[0].length - 1;
		
		while(row > 0 || col > 0){
			coords.add(new Coord(col, row));
			if(getCell(grid, row - 1, col) == 1){
				row--;
			} else {
				col--;
			}
		}
		
		coords.add(new Coord(0,0));
		
		return coords;
	}
	
}
