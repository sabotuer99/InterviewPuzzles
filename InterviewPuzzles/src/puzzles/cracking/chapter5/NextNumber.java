package puzzles.cracking.chapter5;

public class NextNumber {

	public static int nextSmaller(int n){
		if(n == 0){
			return 0;
		}
		int result = 0;
		if((n & (n+1)) == 0){
			//return ~n;  //WRONG
		  n >>= 1;
		  result = Integer.MIN_VALUE;
		  while(n > 0){
			  n >>= 1;
			  result >>= 1;
		  }
		} else {
			result = n;
			for(int i = 1; i < 31; i++){
				if(getBit(n, i) == 1 && getBit(n, i-1) == 0){
					result = clearBit(result,i);
					result = setBit(result, i-1);
					break;
				}
			}
		}
		
		return result; 
	}

	public static int nextBigger(int n){
		if(n == 0){
			return 0;
		}
		int result = n;
		for(int i = 1; i < 31; i++){
			if(getBit(n, i) == 0 && getBit(n, i-1) == 1){
				result = clearBit(result,i-1);
				result = setBit(result, i);
				if((1 << i) > n){ //all the ones were on the left, move one back
					int l = i - 1;
					for(;getBit(n,l) == 1; l--){  System.out.println(l); }
					int r = 0;
					for(;getBit(n,r) == 0; r++){  System.out.println(r); }
					result = clearBit(result, l);
					result = setBit(result, r);
				}
				break;
			}
		}
		
		return result; 
	}
	
	
	
	private static int setBit(int n, int i) {
		return BitUtils.setBit(n, i);
	}

	private static int clearBit(int n, int i) {
		return BitUtils.clearBit(n, i);
	}

	private static int getBit(int n, int i) {
		return BitUtils.getBit(n, i);
	}
	
}
