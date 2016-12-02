package puzzles.cracking.chapter6;

public class BirthRateSim {

	public static double runSim(){
		
		double ratio = 0;
		for(int i = 1; i < 80; i++){
			ratio += (1.0/i) * (1.0/Math.pow(2, i)); 
		}
		
		return ratio;
	}
	
}
