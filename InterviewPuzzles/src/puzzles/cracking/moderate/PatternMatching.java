package puzzles.cracking.moderate;

import java.util.regex.Pattern;

public class PatternMatching {

	public static boolean matchesPattern(String pattern, String value){
		if(pattern == null || value == null ||
				"".equals(pattern) || "".equals(value) ||
				Pattern.matches("[^ab]", pattern)){
			return false;
		}
		
		StringBuilder regSb = new StringBuilder();
		regSb.append("(\\w+)");
		boolean aseen = true;
		boolean bseen = false;
		String asub = "\\1";
		String bsub = "\\2";
		
		if(pattern.charAt(0) == 'b'){
			aseen = false;
			bseen = true;
			asub = "\\2";
			bsub = "\\1";
		}
		
		for(int i = 1; i < pattern.length(); i++){
			if(pattern.charAt(i) == 'a'){
				regSb.append(aseen ? asub : "(\\w+)");
				aseen = true;
			} else {
				regSb.append(bseen ? bsub : "(\\w+)");
				bseen = true;
			}
		}
		
		return Pattern.matches(regSb.toString(), value);
	}
}
