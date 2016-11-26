package puzzles.cracking.chapter1;

public class Matrix {

	private int[][] values;
	private int N;
	
	public Matrix(int[][] values){
		this.values = values;
		this.N = values.length;
		//could do some more validation here to ensure values are right size
	}
	
	public int[][] rotateClockwise(){
		
		//iterate through rings
		for(int ring = 0; ring < N/2; ring++){
			int L = ring;
			int R = N - 1 - ring;
			//iterate along edge
			for(int i = 0; i < R - L; i++){
				int NW = values[L][L+i];
				int NE = values[L+i][R];
				int SE = values[R][R-i];
				int SW = values[R-i][L];
				//SW=>NW, NW=>NE, NE=>SE, SE=>SW
				values[L][L+i] = SW;
				values[L+i][R] = NW;
				values[R][R-i] = NE;
				values[R-i][L] = SE;
			}
		}
		
		return values;
	}
}
