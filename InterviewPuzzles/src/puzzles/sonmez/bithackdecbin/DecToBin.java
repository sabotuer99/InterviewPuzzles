package puzzles.sonmez.bithackdecbin;

public class DecToBin {

	public static String convert(int num) {
		if(num == 0){
			return "0";
		}

		/*
		for(int j = 0; j <= 32; j++){
			int a = 1 << j;
			System.out.println(j + ": " + a);
		}*/
		
		String on = "1";
		String off = "0";

		if(num < 0){
			on = "0";
			off = "1";
			num = Math.abs(num + 1);
		}
		
		String result = off;
		
		for(int i = 30; i >= 0; i--){
			int power =  1 << i;
			if(num >= power){
				result += on;
				num -= power;
			} else {
				result += off;
			}
		}
		
		return result.substring(result.indexOf('1'));		
	}
}
