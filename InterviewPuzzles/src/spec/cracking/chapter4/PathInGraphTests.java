package spec.cracking.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter4.GraphNode;
import puzzles.cracking.chapter4.PathInGraph;

public class PathInGraphTests {

	@Test
	public void TwoIndependentSoloNodes_ReturnsFalse() {
		GraphNode start = new GraphNode(1);
		GraphNode end = new GraphNode(2);
		
		boolean result = PathInGraph.isPath(start, end);
		
		assertFalse(result);
	}
	
	@Test
	public void TwoIndependentGraphs_ReturnsFalse() {
		GraphNode start = new GraphNode(1);
		GraphNode end = new GraphNode(2);
		start.children.add(new GraphNode(10));
		start.children.add(new GraphNode(10));
		end.children.add(new GraphNode(10));
		end.children.add(new GraphNode(10));
		
		boolean result = PathInGraph.isPath(start, end);
		
		assertFalse(result);
	}
	
	@Test
	public void PathExistsBetweenNodes_ReturnsTrue() {
		GraphNode start = new GraphNode(1); //           start
		GraphNode end = new GraphNode(2);   //          /     \
		GraphNode A = new GraphNode(10);    //        A        B
		GraphNode B = new GraphNode(10);    //      /   \      |
		GraphNode C = new GraphNode(10);    //   end     D     C
		GraphNode D = new GraphNode(10);    //
		
		start.children.add(A);
		start.children.add(B);
		B.children.add(C);
		A.children.add(D);
		A.children.add(end);
		
		boolean result = PathInGraph.isPath(start, end);
		
		assertTrue(result);
	}
	
	@Test
	public void ConnectedGraphNoPath_ReturnsFalse() {
		GraphNode start = new GraphNode(1); //           start
		GraphNode end = new GraphNode(2);   //          /     \
		GraphNode A = new GraphNode(10);    //        A        B   end
		GraphNode B = new GraphNode(10);    //          \       \ /
		GraphNode C = new GraphNode(10);    //           D       C
		GraphNode D = new GraphNode(10);    //
		
		start.children.add(A);
		start.children.add(B);
		B.children.add(C);
		end.children.add(C);
		A.children.add(D);
		
		boolean result = PathInGraph.isPath(start, end);
		
		assertFalse(result);
	}

}
