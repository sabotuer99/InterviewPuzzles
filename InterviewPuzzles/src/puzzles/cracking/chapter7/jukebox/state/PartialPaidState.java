package puzzles.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class PartialPaidState extends BaseState {

	public PartialPaidState(InternalState state){
		internalState = state;
	}
	
	@Override
	public State insertCoin(Coin coin) {
		internalState.addCoin(coin);
		if(internalState.enoughMoney()){
			internalState.makeChange();
			return new ReadyState(internalState);
		} else {
			return this;
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
			internalState.returnCoins();
			return new UnloadedState(internalState);
		}
	}

	@Override
	public State returnCoins() {
		internalState.returnCoins();
		return new LoadedState(internalState);
	}

	@Override
	public State makeSelection(int index) {
		return this;
	}
	
	@Override
	public String status() {
		return "Partially Paid";
	}

}
