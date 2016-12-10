package puzzles.cracking.chapter10;



public class MatrixFind {

	public static class Location {
		public int row = -1;
		public int col = -1;

		public Location() {
		}

		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	public static Location find(int[][] matrix, int target) {
		int startrow = 0;
		int endrow = matrix.length - 1;
		int startcol = 0;
		int endcol = matrix[0].length - 1;

		while (startrow <= endrow && startcol <= endcol) {
			// eliminate rows
			for (int i = startrow; i <= endrow; i++) {
				if (matrix[i][startcol] < target && matrix[i][endcol] < target) {
					startrow++;
				}
				if (matrix[i][startcol] > target && matrix[i][endcol] > target) {
					endrow--;
				}
			}
			
			if(startrow > endrow){ //prevent over and underflow
				break;
			}

			for (int j = startcol; j <= endcol; j++) {
				if (matrix[startrow][j] < target && matrix[endrow][j] < target) {
					startcol++;
				}
				if (matrix[startrow][j] > target && matrix[endrow][j] > target) {
					endcol--;
				}
			}

			if (matrix[startrow][startcol] == target) {
				return new Location(startrow, startcol);
			}
		}

		return new Location();
	}

}
