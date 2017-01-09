package puzzles.cracking.moderate.langtons;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private final char BLACK = 'X';
	private final char WHITE = ' ';
	
	private Map<String, Character> touched = new HashMap<>();
	private int minx = 0; 
	private int miny = 0;
	private int maxx = 0;
	private int maxy = 0;
	
	public Character getGridSquare(Point coord){
		Character data = touched.get(coord.toString());
		if(data == null){
			if(isOdd(coord.x) == isOdd(coord.y)){
				return BLACK;
			} else {
				return WHITE;
			}
		} else {
			return data;
		}
	}
	
	public void flipGridSquare(Point coord){
		char current = getGridSquare(coord);
		char flipped = current == BLACK ? WHITE : BLACK;
		touched.put(coord.toString(), flipped);
		updateBounds(coord);
	}
	
	private void updateBounds(Point coord) {
		minx = Math.min(minx, coord.x);
		miny = Math.min(miny, coord.y);
		maxx = Math.max(maxx, coord.x);
		maxy = Math.max(maxy, coord.y);
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int row = miny - 1; row < maxy + 1; row++){
			for(int col = minx - 1; col < maxx + 1; col++){
				sb.append(getGridSquare(new Point(col, row)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	

	private boolean isOdd(int x) {
		return (x & 1) == 1;
	}
	
}
