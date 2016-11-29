package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DagNode {

	DagNode parent;
	List<DagNode> children = new ArrayList<>();
	
	public boolean addChild(DagNode child){
		if(child.root() != this.root() || !hasPath(this, child)){
			children.add(child);
			child.parent = this;
			return true;
		}
		return false;
	}

	private boolean hasPath(DagNode from, DagNode to) {
		if(from == to){
			return true;
		}
		Deque<DagNode> q = new ArrayDeque<>();
		q.offer(this);
		Set<DagNode> seen = new HashSet<>();
		while(q.size() > 0){
			DagNode node = q.poll();
			if(node == to){
				return true;
			}
			for(DagNode child : node.children){
				if(seen.contains(child)){
					throw new RuntimeException("DAG cannot have cycles!");
				}
				seen.add(child);
				q.offer(child);
			}
		}
		return false;
	}

	private DagNode root() {
		DagNode root = this;
		while(root.parent != null && root.parent != this){
			root = root.parent;
		}
		if(root.parent == this){
			throw new RuntimeException("DAG cannot have cycles!");
		}
		return root;
	}
}
