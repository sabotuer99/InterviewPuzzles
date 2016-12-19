package puzzles.cracking.moderate;

public class AddOperations {

	public static int subtract(int a, int b){
		int result = 0; 
		while(result + a < b){
			result++;
		}
		return result;
	}
	
	public static int multiply(int a, int b){
		int result = 0; 
		for(int i = 0; i < b; i++){
			result += a;
		}
		return result;
	}
	
	public static int divide(int a, int b){
		int result = 0; 
		for(int i = a; i <= b; i += a){
			result ++;
		}
		return result;
	}
	
}
