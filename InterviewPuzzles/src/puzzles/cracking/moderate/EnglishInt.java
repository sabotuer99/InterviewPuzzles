package puzzles.cracking.moderate;

public class EnglishInt {

	private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", 
		                       "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String[] BOTTOM = {"", "One", "Two", "Three", "Four", "Five", "Six",
								"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
								"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] MAGNITUDES = {"", "Thousand", "Million", "Billion", "Trillion", 
								"Quadrillion", "Quintillion"};
	
	public static String toEnglish(long n){
		String english = "";
		
		if(n < 0){
			english = "Negative ";
			int mag = 0;
			long leftgroup = 0;
			if(n == Long.MIN_VALUE){
				long safe = n + 1;
				mag = (int) (Math.log(-safe) / Math.log(1000));
				leftgroup = -safe / (long)Math.pow(1000, mag);
			} else {
				mag = (int) (Math.log(-n) / Math.log(1000));
				leftgroup = -n / (long)Math.pow(1000, mag);
			}

			long rightgroup = -(n + leftgroup * (long)Math.pow(1000, mag));
			english += toEnglish(leftgroup) + " " + MAGNITUDES[mag];
			String rightStr = toEnglish(rightgroup);
			if(rightStr.length() > 0){
				english += ", " + rightStr;
			}
		} else if(n >= 1000){
			int mag = (int) (Math.log(n) / Math.log(1000));
			long leftgroup = n / (long)Math.pow(1000, mag);
			long rightgroup = n - leftgroup * (long)Math.pow(1000, mag);
			english += toEnglish(leftgroup) + " " + MAGNITUDES[mag];
			String rightStr = toEnglish(rightgroup);
			if(rightStr.length() > 0){
				english += ", " + rightStr;
			}
		} else if(n > 99 && n <= 999){
			long hundreds = n / 100;
			long remain = n - hundreds * 100;
			english = toEnglish(hundreds) + " Hundred " + toEnglish(remain);
		} else if(n > 19 && n <= 99){
			int tens = (int) (n / 10);
			int remain = (int) (n - tens * 10);
			english = TENS[tens] + " " + BOTTOM[remain];
		} else {
			english = BOTTOM[(int) n];
		}
		
		return english.trim();
	}
}
