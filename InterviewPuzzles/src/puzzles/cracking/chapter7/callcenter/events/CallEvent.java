package puzzles.cracking.chapter7.callcenter.events;

import puzzles.cracking.chapter7.callcenter.Call;
import puzzles.cracking.chapter7.callcenter.Employee;

public class CallEvent {

	private Call call;
	private Employee employee;

	public CallEvent(Call call, Employee employee){
		this.call = call;
		this.employee = employee;
	}
	
	public Call getCall(){
		return call;
	};
	
	public Employee getEmployee(){
		return employee;
	}
}
