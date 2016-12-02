package spec.cracking.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter5.BitUtils;
import puzzles.cracking.chapter5.DrawLine;

public class DrawLineTests {

	@Test
	public void DrawHorizontal(){
		byte[] screen = new byte[80];
		int width = 80;
		int x1 = 21;
		int x2 = 63;
		int y = 3;
		DrawLine.drawHorizontal(screen, width, x1, x2, y);
		
		assertEquals(7, screen[32]);
		assertEquals(-2, screen[37]);
		assertEquals(0, screen[38]);
		assertEquals(-1, screen[34]);
		
		printScreen(screen, width);
	}
	
	@Test
	public void DrawHorizontal_xCoordsReversed(){
		byte[] screen = new byte[80];
		int width = 80;
		int x1 = 21;
		int x2 = 63;
		int y = 3;
		DrawLine.drawHorizontal(screen, width, x2, x1, y);
		
		assertEquals(7, screen[32]);
		assertEquals(-2, screen[37]);
		assertEquals(0, screen[38]);
		assertEquals(-1, screen[34]);
	}
	
	@Test
	public void DrawMultipleHorizontal(){
		byte[] screen = new byte[80];
		int width = 80;

		DrawLine.drawHorizontal(screen, width, 0, 80, 2);
		DrawLine.drawHorizontal(screen, width, 21, 63, 3);
		DrawLine.drawHorizontal(screen, width, 15, 16, 5);
		DrawLine.drawHorizontal(screen, width, 45, 48, 7);
		
		assertEquals(7, screen[32]);
		assertEquals(-2, screen[37]);
		assertEquals(0, screen[38]);
		assertEquals(-1, screen[34]);
		
		printScreen(screen, width);
	}
	
	@Test
	public void NullScreen_QuitsGracefully(){
		DrawLine.drawHorizontal(null, 0, 0, 0, 0);
	}
	
	private void printScreen(byte[] screen, int width){
		int cellRowWidth = width/8;
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		//header row
		for(int i = 0; i < width; i++){
			sb.append(i%10);
		}
		sb.append("#\n");
		
		//body
		for(int i = 0; i < screen.length / cellRowWidth; i++){
			sb.append(i);
			for(int j = 0; j < cellRowWidth; j++){
				int index = i * cellRowWidth + j;
				String bits = BitUtils.toBitString(screen[index]);
				bits = bits.replaceAll("0", " ").replaceAll("1", "-");
				sb.append(bits);
			}
			sb.append("#\n");
		}
		
		//footer row
		sb.append("#");
		for(int i = 0; i < width; i++){
			sb.append("#");
		}
		sb.append("#\n");
		
		System.out.println(sb.toString());
	}
}
