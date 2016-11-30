package spec.cracking.chapter4;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter4.RandNode;

public class RandomNodeTests {

	@Test
	public void getRandomNode_ShouldHaveUniformDistribution(){
		RandNode sut = getGenTree(3);
		int[] results = new int[7];
		
		for(int i = 0; i < 10000; i++){
			int rand = sut.getRandomNode().id;
			results[rand]++;
		}
		
		System.out.println(Arrays.toString(results));
	}
	
	
	
	private RandNode getGenTree(int levels){
		nodeNum = 0;
		return genTree(levels);
	}

	private int nodeNum = 0;
	private RandNode genTree(int levels){
		RandNode root = new RandNode(nodeNum);
		nodeNum++;
		if(levels > 1){
			root.setLeft(genTree(levels-1));
			root.setRight(genTree(levels-1));
		}
		return root;
	}
	
}

