package puzzles.cracking.chapter4;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	public GraphNode(int number){
		this.number = number;
	}
	
	public boolean visited;
	public int number;
	public List<GraphNode> children = new ArrayList<>();
}
