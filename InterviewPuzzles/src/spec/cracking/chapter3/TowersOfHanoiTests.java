package spec.cracking.chapter3;

//import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter3.TowersOfHanoi;

public class TowersOfHanoiTests {

	@Test
	public void Run3Tower() {
		TowersOfHanoi sut = new TowersOfHanoi(3);
		sut.solve();
	}
	
	@Test
	public void Run4Tower() {
		TowersOfHanoi sut = new TowersOfHanoi(4);
		sut.solve();
	}
	
	@Test
	public void Run5Tower() {
		TowersOfHanoi sut = new TowersOfHanoi(5);
		sut.solve();
	}
	
	@Test
	public void Run6Tower() {
		TowersOfHanoi sut = new TowersOfHanoi(6);
		sut.solve();
	}

}
