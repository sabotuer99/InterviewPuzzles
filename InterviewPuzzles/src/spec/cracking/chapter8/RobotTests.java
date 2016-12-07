package spec.cracking.chapter8;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter8.Coord;
import puzzles.cracking.chapter8.Robot;

public class RobotTests {

	@Test
	public void SanityCheck(){
		int[][] grid = {{ 0, 0,-1, 0, 0},
				        { 0, 0,-1, 0, 0},
				        { 0, 0, 0, 0, 0},
				        {-1,-1, 0, 0, 0},
				        { 0, 0, 0, 0, 0}};
		
		List<Coord> result = Robot.findPath(grid);
		
		System.out.println(coordPathToString(5, 5, result));
		
		assertEquals(9, result.size());
	}
	
	
	public String coordPathToString(int width, int height, List<Coord> coords){
		String[][] grid = new String[height][width];
		for(int row = 0; row < height; row++){
			for(int col = 0; col < width; col++ ){
				grid[row][col] = " ";
			}
		}
		
		for(Coord coord : coords){
			if(coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height){
				grid[coord.y][coord.x] = "X";
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(String[] row : grid){
			sb.append(Arrays.toString(row));
			sb.append("\n");
		}
		
		return sb.toString();
	}
}


