package puzzles.cracking.chapter5;

public class NextNumber {

	public static int nextSmaller(int n){
		if(n == 0){
			return 0;
		}
		int result = 0;
		if((n & (n+1)) == 0){
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
		return next(n, 0, 1);
	}
	
	public static int next(int n, int a, int b){
		if(n == 0){
			return 0;
		}
		int result = n;
		for(int i = 1; i < 31; i++){
			if(getBit(n, i) == a && getBit(n, i-1) == b){
				result = clearBit(result,i-1);
				result = setBit(result, i);
				result = pushRight(result, i-1, a, b);
				break;
			}
		}
		
		return result; 
	}
	
	private static int pushRight(int num, int i, int a, int b){
		int left = i;
		int right = 0;
		while (left > right){
			while(getBit(num, left) == a){
				left--;
			}
			while(getBit(num, right) == b){
				right++;
			}
			if(left > right){
				num = updateBit(num, left, a);
				num = updateBit(num, right, b);
				left--;
				right++;
			}
		}
		return num;
	}
	
	
	public static int getPrev(int n) {
		
		if((n & (n+1)) == 0){
			n >>= 1;
			int result = Integer.MIN_VALUE;
			while(n > 0){
				n >>= 1;
				result >>= 1;
			}
			return result;
		}
		
		
		 int temp = n;
		 int c0 = 0;
		 int c1 = 0;
		 while ((temp & 1) == 1){
			 c1++;
			 temp >>= 1;
		 }
		 
		 if(temp == 0) return -1;
		 
		 while(((temp & 1) == 0) && (temp != 0)){
			 c0++;
			 temp >>= 1;
		 }
		 
		 int p = c0 + c1;
		 n &= ((~0) << (p + 1));
		 
		 int mask = (1 << (c1 + 1)) - 1;
		 n |= mask << (c0 - 1);
		
		 return n;
	 }
	
	
	
	
	private static int updateBit(int num, int i, int bit) {
		return BitUtils.updateBit(num, i, bit);
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
