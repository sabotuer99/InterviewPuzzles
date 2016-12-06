package puzzles.cracking.chapter7.jukebox.state;

import java.util.ArrayList;
import java.util.List;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public abstract class BaseState implements State {

	private List<Coin> safe = new ArrayList<>();
	private List<Coin> coins = new ArrayList<>();
	private List<Coin> coinReturn = new ArrayList<>();
	private List<Record> records = new ArrayList<>();
	
	
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
		for(Record record : records){
			titles.add(record.title);
		}
		return titles;
	}

	@Override
	public int getCoinBalance() {
		int balance = 0;
		for(Coin coin : coins){
			balance += coin.value;
		}
		return balance;
	}

	@Override
	public List<Coin> emptyCoinReturn() {
		List<Coin> coins = coinReturn;
		coinReturn = new ArrayList<>();
		return coins;
	}

}
