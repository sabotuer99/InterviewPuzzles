package puzzles.somnez.titlecase;

import java.util.Arrays;
import java.util.List;

public class TitleCase {

	private static List<String> lowers = 
			Arrays.asList("a", "the", "to", "at", "in", "with", "and", "but", "or");
	
	public static String toTitleCase(String title){
		
		//Guard Clauses
		if("".equals(title) || title == null){
			return "";
		}
			
		// Lowercase the title string
		String title_lower = title.toLowerCase();
		
		// Split the title string by spaces
		String[] tokens = title_lower.split(" ");
		
		// For i from 0 to # of words
		for(int i = 0; i < tokens.length; i++){
			// If first or last
			if(i == 0 || i == tokens.length-1){
				// Capitalize word
				tokens[i] = capitalize(tokens[i]);
			} else {		
			// Else
				// If list does not contains the word
				if(lowers.indexOf(tokens[i]) == -1){
					// Capitalize word
					tokens[i] = capitalize(tokens[i]);
				}					
			}
		}
		
		//Combine words into sentence
		String result = join(tokens);
		return result;
	}
	
	private static String capitalize(String word){
		
		// Lowercase word
		String result = word.toLowerCase();
		// Uppercase first letter	
		result = result.substring(0,1).toUpperCase() + result.substring(1);
		
		return result;
	}
	
	private static String join(String[] tokens){
		StringBuilder sb = new StringBuilder();
		for(String token : tokens){
			sb.append(token).append(" ");
		}
		
		return sb.toString().trim();
	}
	
}
