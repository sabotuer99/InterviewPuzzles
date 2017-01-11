package puzzles.cracking.moderate;

public class Rand7 {
	
	
	public static int coinFlip(){
		int flip = -1;
		while(flip == -1){
			int rand = rand5();
			if(rand > 2){
				flip = 1;
			}
			if( rand < 2){
				flip = 0;
			}
		}
		return flip;
	}
	
	public static int rand7(){
		int result = 7;
		int failsafe = 0;
		while(result > 6 && failsafe < 100){
			int rand = coinFlip();
			rand <<= 1;
			rand += coinFlip();
			rand <<= 1;
			rand += coinFlip();
			result = rand;
		}
		
		return result;
	}
	
	public static int rand7T(){
		int baseNum = -1;
		int failsafe = 0;
		while((baseNum < 0 || baseNum >= 119) && failsafe < 100){
			String base5 = rand5() + "" + rand5() + "" + rand5();
			baseNum = Integer.parseInt(base5, 5);
			//System.out.println(baseNum);
			failsafe++;
		}
		return baseNum % 7;
	}
	
	public static int rand5(){
		return (int) (Math.random() * 5);
	}
	
}
