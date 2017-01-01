package puzzles.kennyyu.bitwise;

public class BitwiseDiv {

	public static int mult(int a, int b){
		
		int product = 0;
		
		while(a != 0){
			if((a & 1) == 1){
				product += b;
			}			
			
			b <<= 1;
			a >>= 1;
		}
		
		return product;
	}
	
	public static int div(int num, int den){
		if(den == 0){
			throw new IllegalArgumentException("Divide by zero is undefined");
		}
		
		int numHsb = hsb(num);
		int denHsb = hsb(den);
		int align = numHsb - denHsb;
		den <<= align;
		System.out.printf("%d %d\n", num, den);
		
		int q = 0;
		for(int i = 0; i <= align; i++){
			int temp = num - den;
			if(temp >= 0){
				q += 1;
				num = temp;
			}
			num <<= 1;
			q <<= 1;
		}
		return q >> 1;
	}
	
	//sort of clever but not correct, don't bother
	public static int hsbBS(int bits){
		
		int step = 16;
		int index = 16;
		int mask = (((1 << index) - 1) << 1) + 1;
				
		while(step > 0){
			step /= 2;
			int rightShift = (((bits - (1 << index)) >> 31) & 1) * step * -1;
			int leftShift =  ((((bits & mask) - bits) >> 31) & 1) * step;
			index += rightShift + leftShift;
			mask = (1 << index + 1) - 1;
		}
		
		return index;
	}
	
	public static int hsb(int bits){
		int count = 0;
		while(bits != 0){
			count++;
			bits >>>= 1;
		}
		return count;
	}
	
}
