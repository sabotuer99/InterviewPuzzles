package puzzles.cracking.chapter7.jukebox.state;

import java.util.ArrayList;
import java.util.List;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public abstract class BaseState implements State {

	protected class InternalState{
		public List<Coin> safe = new ArrayList<>();
		public List<Coin> coins = new ArrayList<>();
		public List<Coin> coinReturn = new ArrayList<>();
		public List<Record> records = new ArrayList<>();
	}
	
	protected InternalState internalState = new InternalState();
	
	public BaseState(){}
	
	protected BaseState(InternalState state){
		this.internalState = state;
	}
	
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
		List<String> titles = new ArrayList<>();
		for(Record record : internalState.records){
			titles.add(record.title);
		}
		return titles;
	}

	@Override
	public int getCoinBalance() {
		int balance = 0;
		for(Coin coin : internalState.coins){
			balance += coin.value;
		}
		return balance;
	}

	@Override
	public List<Coin> emptyCoinReturn() {
		List<Coin> coins = internalState.coinReturn;
		internalState.coinReturn = new ArrayList<>();
		return coins;
	}

}
