package puzzles.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class UnloadedState extends BaseState {

	public UnloadedState(InternalState state){
		internalState = state;
	}
	
	@Override
	public State insertCoin(Coin coin) {
		internalState.coinReturn.add(coin);
		return this;
	}

	@Override
	public State insertRecord(Record record) {
		internalState.records.add(record);
		return new LoadedState(internalState);
	}

	@Override
	public State removeRecord(int index) {
		return this;
	}

	@Override
	public State returnCoins() {
		return this;
	}

	@Override
	public State makeSelection(int index) {
		return this;
	}

}
