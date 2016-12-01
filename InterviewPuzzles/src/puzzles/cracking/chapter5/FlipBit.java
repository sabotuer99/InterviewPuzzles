package puzzles.cracking.chapter5;

public class FlipBit {

	public static int bitToWin(int num) {
		
		int seq = 0, flip = 0, max = 0, maxi = 0;
		
		for(int i = 0; i < 32; i++){
			if((num & 1) == 1){
				seq++;
				flip = flip > 0 ? flip + 1: 0;
			} else {
				if(flip == 0){
					flip = seq + 1;
					max = flip;
					maxi = i;
				} else {
					flip = seq + 1;
					if(flip > max){
						max = flip;
						maxi = i;
					}
				}
				seq = 0;
			}
			num >>= 1;
		}
	
		return 1 << (maxi);
	}
	
	public static int maxScore(int num) {
		
		int seq = 0, flip = 0, max = 0;
		
		for(int i = 0; i < 32; i++){
			if((num & 1) == 1){
				seq++;
				flip = flip > 0 ? flip + 1: 0;
			} else {
				if(flip == 0){
					flip = seq + 1;
					max = flip;
				} else {
					max = Math.max(max, flip);
					flip = seq + 1;
				}
				seq = 0;
			}
			num >>= 1;
		
		System.out.println(num + " " + seq + " " + flip + " " + max);
		}
	
		return Math.max(max, flip);
	}

}
