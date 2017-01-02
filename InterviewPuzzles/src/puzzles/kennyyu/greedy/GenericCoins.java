package puzzles.kennyyu.greedy;

import java.util.Arrays;

public class GenericCoins {

	public static int minCoins(int[] currency, int target){
		
		if(currency == null || currency.length == 0 || target <= 0){
			return 0;
		}
		
		boolean[] DP = new boolean[target + 1];
		int coins = 0;
		boolean solutionPossible = true;
		
		//initilize DP
		DP[0] = true;
		int safe = 0;
		
		while(solutionPossible && safe < 1000){
			solutionPossible = false;
			coins++;
			
			for(int i = target; i >= 0; i--){
				boolean goodPosition = false;
				for(int coin : currency){
					if(i == target && coin <= 0){
						return 0;
					}
					
					if(coin <= target && i - coin >= 0 && DP[i - coin]){
						
						if(i == target){
							return coins;
						}
						
						goodPosition = true;
						solutionPossible = true;
					} 
				}
				DP[i] = goodPosition;
			}
			
			System.out.println("D:" + Arrays.toString(DP));
			
			
			safe++;
		}
		
		return 0;	
	}
}
