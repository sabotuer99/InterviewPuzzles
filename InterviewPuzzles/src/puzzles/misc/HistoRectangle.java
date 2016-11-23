package puzzles.misc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/************
 * 
 * Question from here: 
 * https://www.youtube.com/watch?v=VNbkzsnllsU
 * 
************/
public class HistoRectangle {

	public static int stackRect(int[] histogram) {
		
		if(histogram == null || histogram.length == 0){
			return 0;
		}
		
		Deque<Integer> positions= new LinkedList<>();
		Deque<Integer> heights = new LinkedList<>();
		
		positions.push(0);
		heights.push(histogram[0]);
		int maxarea = histogram[0];
		
		for(int i = 1; i < histogram.length; i++){
			if(heights.peekFirst() != null && histogram[i] > heights.peekFirst()){
				heights.push(histogram[i]);
				positions.push(i);
			} else if(heights.peekFirst() != null && histogram[i] < heights.peekFirst()) {
				int lastpos = 0;
				while(heights.peekFirst() != null && histogram[i] < heights.peekFirst()){
					int h = heights.pop();
					lastpos = positions.pop();
					maxarea = Math.max(maxarea, h * (i-lastpos));
				}
				heights.push(histogram[i]);
				positions.push(lastpos);
			}
		}
		
		while(heights.peek() != null){
			int h = heights.pop();
			int p = positions.pop();
			maxarea = Math.max(maxarea, h * (histogram.length - p));
		}
		
		return maxarea;
	}
	
	public static int maxRect(int[] histogram) {
		
		if(histogram == null || histogram.length == 0){
			return 0;
		}
		
		List<Integer> D = new ArrayList<>();
		
		for(int i = 0; i < histogram[0]; i++){
			D.add(1);
		}
		
		int maxArea = histogram[0];
		
		for(int i = 1; i < histogram.length; i++){
			List<Integer> tD = new ArrayList<>();
			int colMax = 0;
			for(int j = 0; j < histogram[i]; j++){
				int area = j+1;
				if(j < D.size()){
					tD.add(D.get(j) + 1);
					area = tD.get(j) * (j+1);				
				} else {
					tD.add(1);
				}
				colMax = Math.max(area, colMax);
			}
			maxArea = Math.max(maxArea, colMax);
			
			D = tD;
		}
		return maxArea;
	}
}
