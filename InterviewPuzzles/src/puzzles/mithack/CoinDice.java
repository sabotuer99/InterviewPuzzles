package puzzles.mithack;

public class CoinDice {

	public static int coinflip(){
		return Math.random() < 0.5 ? 0 : 1;
	}
	
	public static int dieroll(){
		int val = 0;
		while(val > 6 || val < 1){
			val = 0;
			for(int i = 0; i < 3; i++){
				val <<= 1;
				val += coinflip();
			}
		}
		return val;
	}
	
}
