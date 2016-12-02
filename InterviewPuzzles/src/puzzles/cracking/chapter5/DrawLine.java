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
		
		int leftMask = leftEnd[x1 % 8];
		int rightMask = rightEnd[x2 % 8];
		
		//correct for very last pixel
		if(firstCell == screen.length){
			firstCell--;
			leftMask = 0;
		}
		
		if(lastCell == screen.length){
			lastCell--;
			rightMask = -1;
		}
		
		if(firstCell == lastCell){		
			screen[firstCell] = (byte)(leftMask & rightMask);
			return;
		} else {
			screen[firstCell] = (byte)(leftMask);
			screen[lastCell] = (byte)(rightMask);
			for(int i = firstCell + 1; i < lastCell; i++){
				screen[i] = -1;
			}
		}
	}
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y1, int y2){
		if(screen == null || screen.length == 0 || width == 0){
			return;
		}
		
		if(x1 > x2){  //if values reversed, do the sensible thing;
			int temp = x1;
			x1 = x2;
			x2 = temp;
			
			temp = y1;
			y1 = y2;
			y2 = temp;
		}
		
		int rise = Math.abs(y2 - y1);
		int run = x2 - x1;
		int dir = y2 > y1 ? 1 : -1;
		int j = 0;
		int lastx = x1;
		
		for(int i = 0; i <= run; i++){
			if(i * rise > j * run + run/2 || i == run){
				drawHorizontal(screen, width, lastx, x1 + i, y1 + (j * dir));
				lastx = x1 + i;
				j++;
			}
		}
	}
}
