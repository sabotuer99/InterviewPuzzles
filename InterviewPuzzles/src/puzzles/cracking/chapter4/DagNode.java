package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DagNode {

	private String id;
	private Set<DagNode> parents = new HashSet<>();
	private Set<DagNode> children = new HashSet<>();
	
	public DagNode(String id){
		this.id = id;
	}
	
	public boolean addChild(DagNode child){

		children.add(child);
		child.parents.add(this);
		
		if(roots(child) == null){ //call root() to check for cycles
			return false;
		}
		return true;
	}

	private Set<DagNode> roots(DagNode cycleCheck) {

		Set<DagNode> roots = new HashSet<>();
		if(parents.size() == 0){		
			roots.add(this);
			return roots;
		}
		
		for(DagNode parent : parents){
			if(parent == cycleCheck){
				return null;
			}
			Set<DagNode> proots = parent.roots(cycleCheck);
			if(proots == null){
				return null;
			}
			roots.addAll(proots);
		}
		return roots;
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
