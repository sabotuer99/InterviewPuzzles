package puzzles.cracking.chapter4;

public class RandNode {

    private RandNode left;
	private RandNode right;
	public int id;
	int size;
	
	public RandNode(int id){
		this.id = id;
		size = 1;
	}
	
	public void setRight(RandNode node){
		right = node;
		size += node.size;
	}
	
	public void setLeft(RandNode node){
		left = node;
		size += node.size;
	}
	
	public RandNode getRandomNode(){
		double roll = Math.random();
		double s1 = left == null ? 0 : left.size;
		double s2 = s1 + 1;
		if(roll < s1/size){
			return left.getRandomNode();
		} else if(roll >= s1/size && roll < s2/size) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
}
