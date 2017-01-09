package puzzles.cracking.moderate.langtons;

import puzzles.cracking.moderate.langtons.Board;
import puzzles.cracking.moderate.langtons.Point;

public class Ant {

	private Board board = new Board();
	Point position = new Point(0,0);
	Direction orientation = new Direction.East();
	
	private void move(){
		char color = board.getGridSquare(position);
		board.flipGridSquare(position);
		if(color == board.BLACK){
			orientation = orientation.turnCounterClockwise();
		} else {
			orientation = orientation.turnClockwise();
		}
		position = orientation.inFront(position);
	}
	
	public void printKMoves(int k){
		for(int i = 0; i < k; i++){
			move();
		}
		System.out.println(board.toString());
	}
	
	public Board getBoard(){
		return board;
	}
}
