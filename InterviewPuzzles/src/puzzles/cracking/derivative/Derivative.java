package puzzles.cracking.derivative;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Derivative {

	public static Map<Integer, Integer> derive(Map<Integer, Integer> equation) {
		Map<Integer, Integer> dx = new HashMap<>();
		
		for(Integer key : equation.keySet()){
			if(key > 0){
				Integer newCo = equation.get(key) * key;
				dx.put(key -1 , newCo);
			}
		}
		
		return dx;
	}
	
	
	
	public static Map<Integer,Integer> parse(String formula) {
		String[] symbols = formula.split(" ");
		String regex = "([-]?)(\\d*)(x?)(\\^\\d+)?";
		Pattern pattern = Pattern.compile(regex);
		int positive = 1;
		Map<Integer,Integer> parsed = new HashMap<>();
		
		for(int i = 0; i < symbols.length; i++){
			String symbol = symbols[i];
			
			if(0 == (i & 1)){
				Matcher matcher = pattern.matcher(symbol);
				matcher.find();
				String sign = matcher.group(1);
				String coef = matcher.group(2);
				String var = matcher.group(3);
				String exp = matcher.group(4);
				
				if("-".equals(sign)){
					positive *= -1;
				}
				
				if("".equals(coef) || coef == null){
					coef = "1";
				}
				
				if("".equals(var) || var == null){
					exp = "0";
				} else if ("".equals(exp) || exp == null){
					exp = "1";
				} else {
					exp = exp.substring(1);
				}
				
				Integer pcoef = positive * Integer.parseInt(coef);
				Integer pexp = Integer.parseInt(exp);
				parsed.put(pexp, pcoef);
			} else {
				if("+".equals(symbol)){
					positive = 1;
				} else {
					positive = -1;
				}
			}
		}
		
		return parsed;
	}



}
