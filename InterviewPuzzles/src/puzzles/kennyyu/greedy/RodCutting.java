package puzzles.kennyyu.greedy;

import java.util.Arrays;
import java.util.List;

public class RodCutting {

	public static int maxProfit(int rodlength, int[] prices){
		return maxProfit(rodlength, prices, null);
	}
	
	public static int maxProfit(int rodlength, int[] prices, List<Integer> cuts){
		int[] BT = new int[rodlength + 1];
		int[] DP = new int[rodlength + 1];
		
		for(int j = 1; j <= prices.length; j++){
			int price = prices[j-1];
			for(int i = j; i <= rodlength; i++){
				int includeCut = DP[i - j] + price;
				if(includeCut > DP[i]){
					DP[i] = includeCut;
					BT[i] = i-j;
				}
			}
			System.out.println(Arrays.toString(DP));
		}
		
		//do backtracking
		fillCuts(rodlength, BT, cuts);
		
		
		
		return DP[rodlength];
	}
	
	private static void fillCuts(int rodlength, int[] BT, List<Integer> cuts){
		if(cuts != null){
			int left = rodlength;
			while(left > 0 && BT[left] > 0){
				int cut = left - BT[left];
				left -= cut;
				cuts.add(cut);
			}
			if(left > 0){
				cuts.add(left);
			}
		}
	}
	
}
