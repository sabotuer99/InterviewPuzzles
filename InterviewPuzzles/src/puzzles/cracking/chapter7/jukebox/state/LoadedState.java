package puzzles.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;
import puzzles.cracking.chapter7.jukebox.state.InternalState;

public class LoadedState extends BaseState {

	public LoadedState(InternalState state){
		internalState = state;
	}
	
	@Override
	public State insertCoin(Coin coin) {
		internalState.addCoin(coin);
		if(internalState.enoughMoney()){
			internalState.makeChange();
			return new ReadyState(internalState);
		} else {
			return new PartialPaidState(internalState);
		}
	}

	@Override
	public State insertRecord(Record record) {
		internalState.addRecord(record);
		return this;
	}

	@Override
	public State removeRecord(int index) {
		internalState.removeRecord(index);
		if(internalState.isLoaded()){
			return this;
		} else {
			return new UnloadedState(internalState);
		}
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
