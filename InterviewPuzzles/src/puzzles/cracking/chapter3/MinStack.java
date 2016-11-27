package puzzles.cracking.chapter3;

public class MinStack {

	int minIndex = 0;
	int size = 0;
	int[] values = new int[50];
	int[] downmins = new int[50];
	
	public void push(int value){
		if(size + 1 > values.length){
			growArray();
		}
		
		values[size] = value;
		downmins[size] = minIndex;
		
		if(value < values[minIndex]){
			minIndex = size;
		}
		
		size++;
	}

	public int pop(){
		if(size == 0){
			throw new RuntimeException("Cannot pop empty stack!");
		}
		
		if(size + 1 < values.length / 4 && values.length > 100){
			shrinkArray();
		}
		
		size--;
		int value = values[size];
		if(size == minIndex){
			minIndex = downmins[size];
		}
		return value;
	}
	
	public int min(){
		return values[minIndex];
	}
	
	private void shrinkArray() {
		resize(values.length / 2);
	}

	private void growArray() {
		resize(values.length * 2);
	}
	
	private void resize(int newSize){
		int oldLen = values.length;
		int[] newArray = new int[newSize];
		int[] newMins = new int[newSize];
		for(int i = 0; i < Math.min(oldLen, newSize); i++){
			newArray[i] = values[i];
			newMins[i] = downmins[i];
		}
		
		values = newArray;
		downmins = newMins;
	}
}
