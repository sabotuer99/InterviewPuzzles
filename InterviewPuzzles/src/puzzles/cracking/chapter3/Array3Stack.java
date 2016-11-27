package puzzles.cracking.chapter3;

import java.util.Arrays;

public class Array3Stack {

	
	public SubStack a;
	public SubStack b;
	public SubStack c;
	
	private int[] array;
	
	public Array3Stack(){
		array = new int[30];
		a = new SubStack(0, 3, this);
		b = new SubStack(1, 3, this);
		c = new SubStack(2, 3, this);
	}
	
	private int[] growArray(){
		int[] newArray = new int[array.length * 2];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		array = newArray;
		return array;
	}
	
	@Override
	public String toString(){
		return Arrays.toString(array);
	}
	
	public class SubStack{

		int offset;
		int step;
		int size;
		Array3Stack parent;
		
		public SubStack(int offset, int step, Array3Stack parent) {
			this.offset = offset;
			this.step = step;
			this.parent = parent;
			this.size = 0;
		}
		
		public void push(int value){
			size++;
			int[] array = parent.array;
			if(size * step + offset > array.length){
				array = parent.growArray();
			}
			array[(size-1) * step + offset] = value;
		}
		
		public int pop(){
			if(size == 0){
				throw new RuntimeException("Cannot pop from empty stack!");
			}
			int value = parent.array[(size-1) * step + offset];
			size--;
			return value;
		}
		
		@Override
		public String toString(){
			if(size == 0){
				return "empty";
			}
			String result = Integer.toString(parent.array[offset]);
			for(int i = 1; i < size; i++){
				result += " => " + Integer.toString(parent.array[i * step + offset]);
			}
			
			return result;
		}
		
	}
}
