package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SumPathCount {

	public static int countPathsWithSum(int sum, TreeNode root) {

		if(root == null){
			return 0;
		}
		
		Deque<Deque<TreeNode>> paths = new ArrayDeque<>();
		Deque<Integer> sums = new ArrayDeque<>();
		
		Deque<TreeNode> start = new ArrayDeque<>();
		start.push(root);
		paths.offer(start);
		sums.offer(root.value);
		
		int sumCount = 0;
		while(paths.size() > 0){
			Deque<TreeNode> currentPath = paths.poll();
			int currentSum = sums.poll();
			
			//debug
			//printPathSum(currentPath, currentSum);
			
			if(currentSum == sum){
				sumCount++;
			}
			if(currentPath.size() == 1){
				addPaths(paths, sums, currentPath.peek(), new ArrayDeque<>(), 0);
			} 
			
			addPaths(paths, sums, currentPath.peek(), currentPath, currentSum);
		}
		return sumCount;
	}

	@SuppressWarnings("unused")
	private static void printPathSum(Deque<TreeNode> currentPath, int currentSum) {
		String message = "[ ";
		for(TreeNode node : new ArrayList<>(currentPath)){
			message += node.value + " ";
		}
		message += "]  sum: " + currentSum;
		System.out.println(message);
	}




	private static void addPaths(Deque<Deque<TreeNode>> paths,
								Deque<Integer> sums, 
								TreeNode parent, 
								Deque<TreeNode> pathToExtend, 
								int currentSum) {
		for(TreeNode child : parent.getChildren()){
			Deque<TreeNode> newPath = new ArrayDeque<>(pathToExtend);
			newPath.push(child);
			paths.offer(newPath);
			sums.offer(child.value + currentSum);
		}
	}


	
}
