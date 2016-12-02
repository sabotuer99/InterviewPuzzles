package puzzles.cracking.chapter7.callcenter;

import java.util.ArrayList;
import java.util.List;

public class Call {

	private String id;
	private boolean isSatisfied;
	private int satisfactionThreshold;
	private List<String> unsatisfiedResponses;
	private List<String> satisfiedResponses;
	private String startTimeStamp;
	private String endTimeStamp;	
	
	public boolean isSatisfied() {
		return isSatisfied;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Call(){
		unsatisfiedResponses = new ArrayList<>();
		satisfiedResponses = new ArrayList<>();
		satisfactionThreshold = 50;
	}

	public boolean receiveService(int serviceLevel){
		isSatisfied = serviceLevel >= satisfactionThreshold;
		return isSatisfied;
	}
	
	public String serviceFeedback(){
		if(!isSatisfied){
			return getUnsatisfiedResponse();
		} else {
			return getSatisfiedResponse();
		}
	}
	
	public void addUnsatisfiedResponse(String response){
		unsatisfiedResponses.add(response);
	}
	
	public void addSatisfiedResponse(String response){
		satisfiedResponses.add(response);
	}
	
	public String getUnsatisfiedResponse(){
		return getResponse(unsatisfiedResponses, "Unsatisfied");
	}
	
	public String getSatisfiedResponse(){
		return getResponse(satisfiedResponses, "Satisfied");
	}
	
	public void setUnsatisfiedResponses(List<String> unsatisfiedResponses) {
		this.unsatisfiedResponses = unsatisfiedResponses;
	}

	public void setSatisfiedResponses(List<String> satisfiedResponses) {
		this.satisfiedResponses = satisfiedResponses;
	}

	private String getResponse(List<String> reps, String def){
		if(reps.size() == 0){
			return def;
		} else {
			int index = (int) (Math.random() * reps.size());
			return reps.get(index);
		}
	}
	
	public int getSatisfactionThreshold() {
		return satisfactionThreshold;
	}

	public void setSatisfactionThreshold(int satisfactionThreshold) {
		this.satisfactionThreshold = satisfactionThreshold;
	}

	public String getStartTimeStamp() {
		return startTimeStamp;
	}

	public void setStartTimeStamp(String startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}

	public String getEndTimeStamp() {
		return endTimeStamp;
	}

	public void setEndTimeStamp(String endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
	
	
	
	
}
