package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DagNode {

	private String id;
	private DagNode parent;
	private Set<DagNode> children = new HashSet<>();
	
	public DagNode(String id){
		this.id = id;
	}
	
	public boolean addChild(DagNode child){

		children.add(child);
		child.parent = this;
		
		if(root() == null){ //call root() to check for cycles
			return false;
		}
		return true;
	}

	private DagNode root() {
		DagNode root = this;
		while(root.parent != null && root.parent != this){
			root = root.parent;
		}
		if(root.parent == this){
			return null;
		}
		return root;
	}
	
	public String printBFS(){
		StringBuilder sb = new StringBuilder();
		Deque<DagNode> q = new ArrayDeque<>();
		q.offer(this);
		Set<DagNode> seen = new HashSet<>();
		while(q.size() > 0){
			DagNode node = q.poll();
			
			sb.append(node.id);
			sb.append(" ");
			
			for(DagNode child : node.children){
				if(!seen.contains(child)){
					seen.add(child);
					q.offer(child);
				}
			}
		}
		return sb.toString().trim();
	}
}
