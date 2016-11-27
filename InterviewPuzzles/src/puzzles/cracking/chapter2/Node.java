package puzzles.cracking.chapter2;

public class Node{
	
	public int val;
	public Node next = null;
	public Node prev = null;
	
	public Node(int val){
		this.val = val;
	}
	
	public int getVal(){
		return val;
	}
	
	public void setVal(int val){
		this.val = val;
	}
	
	@Override
	public String toString(){
		String result = Integer.toString(val);
		if(next != null){
			result += " => " + next.toString();
		}
		
		return result;
	}
}
