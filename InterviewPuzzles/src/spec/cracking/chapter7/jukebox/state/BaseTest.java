package spec.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class BaseTest {
	protected Record testRecord(){
		return new Record("test", "test song");
	}
	
	protected Coin quarter(){
		return new Coin(25);
	}
	
	protected Coin dime(){
		return new Coin(10);
	}
	
	protected Coin nickel(){
		return new Coin(5);
	}
}
