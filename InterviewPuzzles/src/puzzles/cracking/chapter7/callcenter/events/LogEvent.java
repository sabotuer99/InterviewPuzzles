package puzzles.cracking.chapter7.callcenter.events;

public class LogEvent {

	public String message;
	
	public LogEvent(String message){
		this.message = message;
	};
	
	public String getMessage(){
		return message;
	};
}
