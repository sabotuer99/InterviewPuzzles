package puzzles.cracking.chapter5;

public class DrawLine {

	private static final byte[] leftEnd = {-1, 127, 63, 31, 15, 7, 3, 1, 0};
	private static final byte[] rightEnd = {0, -128, -64, -32, -16, -8, -4, -2, -1};
	public static void drawHorizontal(byte[] screen, int width, int x1, int x2, int y){
		
		if(screen == null || screen.length == 0 || width == 0){
			return;
		}
		
		if(x1 > x2){  //if values reversed, do the sensible thing;
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		
		int cellRowWidth = width / 8;
		int startCellRow = y * cellRowWidth;
		int firstCell = x1 / 8 + startCellRow;
		int lastCell = x2 / 8 + startCellRow;
		if(firstCell == lastCell){		
			screen[firstCell] = (byte)(leftEnd[x1 % 8] & rightEnd[x2 % 8]);
			return;
		} else {
			screen[firstCell] = (byte)(leftEnd[x1 % 8]);
			screen[lastCell] = (byte)(rightEnd[x2 % 8]);
			for(int i = firstCell + 1; i < lastCell; i++){
				screen[i] = -1;
			}
		}
	}
}
