package puzzles.cracking.chapter7.callcenter;

import puzzles.cracking.chapter7.callcenter.events.CallEvent;
import puzzles.cracking.chapter7.callcenter.events.CallEventHandler;
import puzzles.cracking.chapter7.callcenter.events.EmployeeEventHandler;
import puzzles.cracking.chapter7.callcenter.events.LogEvent;
import puzzles.cracking.chapter7.callcenter.events.LogEventHandler;

public class Employee {
	
	private int patience;
	private int minServiceLevel;
	private int maxServiceLevel;
	private boolean canEscalate;
	private EmployeeEventHandler freeListener;
	private CallEventHandler resolvedListener;
	private CallEventHandler escalateListener;
	private LogEventHandler logger;
	private String name;
	
	public Employee(){
		canEscalate = true;
		minServiceLevel = 0;
		maxServiceLevel = 0;
		patience = 3;
	}
	
	public void service(Call call){
		boolean success = false;
		String callerId = call.getId();
		for(int i = 0; i < patience; i++){
			int service = provideService();
			success = call.receiveService(service);
			String feedback = call.serviceFeedback();
			logger.handle(new LogEvent(callerId + ": " + feedback));
		}
		
		if(success || !canEscalate){
			resolvedListener.handle(new CallEvent(call, this));
		} else {
			escalateListener.handle(new CallEvent(call, this));
		}
	}
	
	public int provideService(){
		int service = (int) (Math.random() * (1.0 * maxServiceLevel - minServiceLevel) + minServiceLevel);
		return service;
	}
	
	public int getMinServiceLevel() {
		return minServiceLevel;
	}

	public void setMinServiceLevel(int minServiceLevel) {
		this.minServiceLevel = minServiceLevel;
	}

	public int getMaxServiceLevel() {
		return maxServiceLevel;
	}

	public void setMaxServiceLevel(int maxServiceLevel) {
		this.maxServiceLevel = maxServiceLevel;
	}

	public boolean canEscalate() {
		return canEscalate;
	}
	public void setCanEscalate(boolean canEscalate) {
		this.canEscalate = canEscalate;
	}
	public EmployeeEventHandler getFreeListener() {
		return freeListener;
	}
	public void setFreeListener(EmployeeEventHandler freeListener) {
		this.freeListener = freeListener;
	}
	public CallEventHandler getResolvedListener() {
		return resolvedListener;
	}
	public void setResolvedListener(CallEventHandler resolvedListener) {
		this.resolvedListener = resolvedListener;
	}
	public CallEventHandler getEscalateListener() {
		return escalateListener;
	}
	public void setEscalateListener(CallEventHandler escalateListener) {
		this.escalateListener = escalateListener;
	}
	public LogEventHandler getLogListener() {
		return logger;
	}
	public void setLogger(LogEventHandler logger) {
		this.logger = logger;
	}
	public int getPatience() {
		return patience;
	}
	public void setPatience(int patience) {
		this.patience = patience;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
}
