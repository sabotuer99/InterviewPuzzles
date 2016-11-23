package puzzles.misc;

import java.util.ArrayList;
import java.util.List;

/************
 * 
 * Question from here: 
 * https://www.youtube.com/watch?v=VNbkzsnllsU
 * 
************/
public class HistoRectangle {

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
