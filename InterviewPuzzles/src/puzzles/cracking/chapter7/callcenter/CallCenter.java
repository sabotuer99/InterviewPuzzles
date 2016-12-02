package puzzles.cracking.chapter7.callcenter;

import java.sql.Timestamp;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import puzzles.cracking.chapter7.callcenter.events.CallEvent;
import puzzles.cracking.chapter7.callcenter.events.CallEventHandler;
import puzzles.cracking.chapter7.callcenter.events.EmployeeEvent;
import puzzles.cracking.chapter7.callcenter.events.EmployeeEventHandler;
import puzzles.cracking.chapter7.callcenter.events.LogEvent;
import puzzles.cracking.chapter7.callcenter.events.LogEventHandler;

public class CallCenter {

	int satisfiedCallers = 0;
	int unhappyCallers = 0;
	
	Deque<Employee> availableRespondents = new ConcurrentLinkedDeque<>();
	Deque<Employee> availableManagers = new ConcurrentLinkedDeque<>();
	Deque<Employee> availableDirectors = new ConcurrentLinkedDeque<>();
	
	Deque<Call> waitingRespondent = new ConcurrentLinkedDeque<>();
	Deque<Call> waitingManager = new ConcurrentLinkedDeque<>();
	Deque<Call> waitingDirector = new ConcurrentLinkedDeque<>();

	
	public void acceptCall(Call call){
		call.setStartTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
		Employee rep = availableRespondents.poll();
		String caller = call.getId();
		if(rep == null){	
			waitingRespondent.offer(call);
			log("No Representative available, queueing call from " + caller);
		} else {
			assignToCall(rep, call);
			log("Representative "+ rep.getName() +" taking call from " + caller);
		}
	}
	
	public void addRespondent(Employee employee){
		employee.setEscalateListener(escToManagerHandler);
		employee.setFreeListener(repFreeHandler);
		employee.setResolvedListener(resolvedListener);
		employee.setLogger(logger);
		availableRespondents.offer(employee);
	}
	
	public void addManager(Employee employee){
		employee.setEscalateListener(escToDirectorHandler);
		employee.setFreeListener(manFreeHandler);
		employee.setResolvedListener(resolvedListener);
		employee.setLogger(logger);
		availableManagers.offer(employee);
	}
	
	public void addDirector(Employee employee){
		employee.setCanEscalate(false);
		employee.setEscalateListener(null);
		employee.setFreeListener(dirFreeHandler);
		employee.setResolvedListener(resolvedListener);
		employee.setLogger(logger);
		availableDirectors.offer(employee);
	}
	
	ExecutorService executor = Executors.newCachedThreadPool();
	public void assignToCall(Employee employee, Call call){
		Runnable task = new Runnable(){
			@Override
			public void run() {
				employee.service(call);
			}};
		executor.submit(task);
	}
	
	/*
	 * EVENT HANDLERS
	 * 
	 */
	
	LogEventHandler logger = new LogEventHandler(){
		@Override
		public void handle(final LogEvent logevent) {
			try{
				log(logevent.getMessage());
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	};
	
	CallEventHandler escToManagerHandler = new CallEventHandler(){
		@Override
		public void handle(CallEvent e) {
			String caller = e.getCall().getId();
			Employee employee = e.getEmployee();
			log("Representative " + employee.getName() + " escalated call from " + caller);
			
			Employee manager = availableManagers.poll();
			if(manager == null){
				Employee director = availableDirectors.poll();
				if(director == null){
					log("No Manager or Director available, queueing call from " + caller);
					waitingManager.offer(e.getCall());
				} else {
					log("No Manager available, Director " + director.getName() + " taking call from " + caller);
					assignToCall(director, e.getCall());
				}
			} else {
				log("Manager "+ manager.getName() +" taking call from " + caller);
				assignToCall(manager, e.getCall());
			}	
		}
	};
	
	CallEventHandler escToDirectorHandler = new CallEventHandler(){
		@Override
		public void handle(CallEvent e) {	
			String caller = e.getCall().getId();
			Employee employee = e.getEmployee();
			log("Manager " + employee.getName() + " escalated call from " + caller);
			
			Employee director = availableDirectors.poll();
			if(director == null){
				log("No Director available, queueing call from " + caller);
				waitingManager.offer(e.getCall());
			} else {	
				log("Director "+ director.getName() +" taking call from " + caller);
				assignToCall(director, e.getCall());
			}
		}
	};
	
	EmployeeEventHandler repFreeHandler = new EmployeeEventHandler(){
		@Override
		public void handle(EmployeeEvent e) {
			employeeNextCall(waitingRespondent.poll(), availableRespondents, e.getEmployee(), "Representative");
		}	
	};
	
	EmployeeEventHandler manFreeHandler = new EmployeeEventHandler(){
		@Override
		public void handle(EmployeeEvent e) {
			employeeNextCall(waitingManager.poll(), availableManagers, e.getEmployee(), "Manager");
		}	
	};
	
	EmployeeEventHandler dirFreeHandler = new EmployeeEventHandler(){
		@Override
		public void handle(EmployeeEvent e) {
			Call next = waitingDirector.poll();
			if(next == null){
				next = waitingManager.poll();
			}
			employeeNextCall(next, availableDirectors, e.getEmployee(), "Director");
		}	
	};
	
	private void employeeNextCall(Call next, Deque<Employee> empQueue, Employee emp, String title){
		if(next == null){
			log(title + " " + emp.getName() + " is free, awaiting calls...");
			empQueue.offer(emp);
		} else {
			log(title + " " +  emp.getName() + " is taking call from " + next.getId());
			assignToCall(emp, next);
		}
	}
	
	CallEventHandler resolvedListener = new CallEventHandler(){
		@Override
		public void handle(CallEvent e) {
			Call call = e.getCall();
			call.setEndTimeStamp(new Timestamp(System.currentTimeMillis()).toString());
			if(call.isSatisfied()){
				satisfiedCallers++;
				log(call.getId() + " was satisfied with " + e.getEmployee().getName() + "'s service!");
			} else {
				unhappyCallers++;
				log(call.getId() + " was NOT satisfied with " + e.getEmployee().getName() + "'s service! Boo!");
			}
		}
	};
	
	/*
	 * LOGGING
	 */
	
	public void log(String message){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%1$-" + 56 + "s", message));
		sb.append("# ");
		sb.append(currentState());
		System.out.println(sb.toString());
	}

	private String currentState() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%1$-" + 4 + "s", waitingRespondent.size()));
		sb.append(String.format("%1$-" + 4 + "s", waitingManager.size()));
		sb.append(String.format("%1$-" + 4 + "s", waitingDirector.size()));
		sb.append(String.format("%1$-" + 4 + "s", availableRespondents.size()));
		sb.append(String.format("%1$-" + 4 + "s", availableManagers.size()));
		sb.append(String.format("%1$-" + 4 + "s", availableDirectors.size()));
		return sb.toString();
	}
}
