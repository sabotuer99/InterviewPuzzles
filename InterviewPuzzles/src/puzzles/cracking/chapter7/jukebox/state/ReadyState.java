package puzzles.cracking.chapter7.jukebox.state;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class ReadyState extends BaseState {

	public ReadyState(InternalState state){
		internalState = state;
	}
	
	@Override
	public State insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State insertRecord(Record record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State removeRecord(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State returnCoins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State makeSelection(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String status() {
		return "Ready";
	}

}
