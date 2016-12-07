package puzzles.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class ReadyState extends BaseState {

	public ReadyState(InternalState state){
		internalState = state;
	}
	
	@Override
	public State insertCoin(Coin coin) {
		internalState.addCoinToReturn(coin);
		return this;
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
		Record songToPlay = internalState.getSong(index);
		internalState.setSongToPlay(songToPlay);
		internalState.moveCoinsToSafe();
		internalState.setCurrentBalance(0);
		return new LoadedState(internalState);
	}
	
	@Override
	public String status() {
		return "Ready";
	}

}
