package puzzles.kennyyu;

public class StockProfit {

	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		
		int maxProfit = 0;
		int minPriceSeen = prices[0];
		
		for(int i = 0; i < prices.length; i++){			
			maxProfit = Math.max(maxProfit, prices[i]-minPriceSeen);
			minPriceSeen = Math.min(minPriceSeen, prices[i]);
		}
		
		return maxProfit;		
	}
}
