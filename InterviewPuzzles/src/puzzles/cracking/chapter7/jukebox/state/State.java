package puzzles.cracking.chapter7.jukebox.state;

import java.util.List;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public interface State {
	State insertCoin(Coin coin);
	State insertRecord(Record record);
	State removeRecord(int index);
	State returnCoins();
	State makeSelection(int index);
	
	String status();
	List<String> getAvailableSongs();
	int getCoinBalance();
	List<Coin> emptyCoinReturn();
}
