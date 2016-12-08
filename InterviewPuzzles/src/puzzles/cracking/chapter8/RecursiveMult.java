package puzzles.cracking.chapter8;

public class RecursiveMult {

	public static int multiply(int a, int b){
		if(a > b){ //xor swap ain't I clever lol...
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		
		if(a == 0){
			return 0;
		}
		if(a == 1){
			return b;
		}
		
		int answer = 0;
		if((a & 1) == 1){
			answer += b;
		}
		a >>= 1;
		b <<= 1;
		return answer + multiply(a,b);
	}
	
	public static int naive(int a, int b){
		if(a > b){
			int temp = b;
			b = a;
			a = temp;
		}
		
		if(a == 0){
			return 0;
		}
		if(a == 1){
			return b;
		}
		
		return b + naive(a-1, b);
	}
}
