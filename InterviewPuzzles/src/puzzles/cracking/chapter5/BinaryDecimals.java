package puzzles.cracking.chapter5;

public class BinaryDecimals {

	public static String getBits(double num) {
		double epsilon = 1.0/Integer.MAX_VALUE;
		System.out.println(epsilon);
		char[] bits = new char[32];
		for(int i = 1; i <= 32 && num > epsilon; i++){
			double currentBit = 1.0/(1 << i);
			//System.out.println(currentBit);
			//System.out.println(num);
			if(num >= currentBit){
				bits[i-1] = '1';
				num -= currentBit;
			} else {
				bits[i-1] = '0';
			}
		}
		
		if(num > epsilon){
			return "ERROR";
		}
		
		return "." + new String(bits);
	}
	
	//this is Gayle's solution
	public static String getBits2(double n){
		
		StringBuilder sb = new StringBuilder();
		while(n > 0 && sb.length() <= 32){
			n *= 2;
			if(n >= 1){
				sb.append('1');
				n -= 1;
			} else {
				sb.append('0');
			}
		}
		
		if(n > 0){
			return "ERROR";
		}
		
		return "." + sb.toString();
			
	}

}
