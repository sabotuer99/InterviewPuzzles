package puzzles.cracking.chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuildOrder {

	public static String[] computeOrder(String[] projects, String[][] dependencies) {
		Map<String, DagNode> nodes = new HashMap<>();
		Set<DagNode> roots = new HashSet<>();
		for(String project : projects){
			DagNode pnode = new DagNode(project);
			nodes.put(project, pnode);
			roots.add(pnode);
		}
		for(String[] deps : dependencies){
			DagNode parent = nodes.get(deps[0]);
			DagNode child = nodes.get(deps[1]);
			if(!parent.addChild(child)){
				return null;  //invalid DAG means no schedule possible
			}
			roots.remove(child);
		}  //valid DAGs at this point 
		
		DagNode start = new DagNode("");
		for(DagNode root : roots){
			start.addChild(root);
		}
		
		return start.printBFS().split(" ");
	}
}
