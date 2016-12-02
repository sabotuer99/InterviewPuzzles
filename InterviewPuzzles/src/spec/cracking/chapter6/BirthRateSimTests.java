package spec.cracking.chapter6;

import org.junit.Test;

import puzzles.cracking.chapter6.BirthRateSim;

public class BirthRateSimTests {

	@Test
	public void RunSim(){
		double ratio = BirthRateSim.runSim();
		
		System.out.println(ratio);
	}
}
