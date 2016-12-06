package puzzles.cracking.chapter7.jukebox.state;

import java.util.List;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public abstract class BaseState implements State {

	protected InternalState internalState;
	
	@Override
	public abstract State insertCoin(Coin coin);

	@Override
	public abstract State insertRecord(Record record);

	@Override
	public abstract State removeRecord(int index);

	@Override
	public abstract State returnCoins();

	@Override
	public abstract State makeSelection(int index);

	@Override
	public List<String> getAvailableSongs() {
		return internalState.getAvailableSongs();
	}

	@Override
	public int getCoinBalance() {
		return internalState.getCoinBalance();
	}

	@Override
	public List<Coin> emptyCoinReturn() {
		return internalState.emptyCoinReturn();
	}

	@Override
	public abstract String status();


}
