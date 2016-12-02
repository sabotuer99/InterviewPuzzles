package puzzles.cracking.chapter7.callcenter.events;

import puzzles.cracking.chapter7.callcenter.Call;

public class CallEvent {

	private Call call;

	public CallEvent(Call call){
		this.call = call;
	}
	
	public Call getCall(){
		return call;
	};
}
