package puzzles.cracking.chapter7.callcenter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import puzzles.cracking.chapter7.callcenter.events.CallEvent;
import puzzles.cracking.chapter7.callcenter.events.CallEventHandler;

public class CallCenter {

	Deque<Employee> availableRespondends = new ConcurrentLinkedDeque<>();
	Deque<Employee> availableManagers = new ConcurrentLinkedDeque<>();
	Deque<Employee> availableDirectors = new ConcurrentLinkedDeque<>();
	
	Deque<Call> waitingRespondent = new ConcurrentLinkedDeque<>();
	Deque<Call> waitingManager = new ConcurrentLinkedDeque<>();
	Deque<Call> waitingDirector = new ConcurrentLinkedDeque<>();
	
	CallEventHandler escToManagerHandler = new CallEventHandler(){
		@Override
		public void handle(CallEvent e) {
			if(availableManagers.size() == 0){
				if(availableDirectors.size() == 0){
					waitingManager.offer(e.getCall());
				} else {
					Employee director = availableDirectors.poll();
					assignToCall(director, e.getCall());
				}
			} else {
				Employee manager = availableManagers.poll();
				assignToCall(manager, e.getCall());
			}	
		}
	};
	
	CallEventHandler escToDirectorHandler = new CallEventHandler(){
		@Override
		public void handle(CallEvent e) {			
			if(availableDirectors.size() == 0){
				waitingManager.offer(e.getCall());
			} else {
				Employee director = availableDirectors.poll();
				assignToCall(director, e.getCall());
			}
		}
	};
	
	
	public void addRespondent(Employee employee){
		
	}
	
	public void addManager(Employee employee){
		
	}
	
	public void addDirector(Employee employee){
		
	}
	
	public void assignToCall(Employee employee, Call call){
		
	}
}
