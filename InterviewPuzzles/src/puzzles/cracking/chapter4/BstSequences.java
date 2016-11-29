package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BstSequences {

	private static List<List<TreeNode>> getSequences(TreeNode root){
		Deque<List<TreeNode>> sequences = new ArrayDeque<>();
		Deque<List<TreeNode>> frontiers = new ArrayDeque<>();
		List<List<TreeNode>> completed = new ArrayList<>();
		
		List<TreeNode> start = new ArrayList<>();
		start.add(root);
		List<TreeNode> frontier = new ArrayList<>();
		addChildren(root, frontier);
		
		sequences.offer(start);
		frontiers.offer(frontier);
		
		while(sequences.size() > 0){
			List<TreeNode> currentSeq = sequences.poll();
			List<TreeNode> currentFront = frontiers.poll();
			if(currentFront.size() == 0){
				completed.add(currentSeq);
			} else {
				for(TreeNode node : currentFront){
					List<TreeNode> newSeq = new ArrayList<>(currentSeq);
					List<TreeNode> newFront = new ArrayList<>(currentFront);
					newSeq.add(node);
					newFront.remove(node);
					addChildren(node, newFront);
					sequences.offer(newSeq);
					frontiers.offer(newFront);
				}
			}
			
		}
		
		return completed;
	}
	
	private static void addChildren(TreeNode node, List<TreeNode> list){
		if(node.left != null){
			list.add(node.left);
		}
		if(node.right != null){
			list.add(node.right);
		}
	}
	
	public static List<String> getPrintableSequences(TreeNode root){
		
		if(root == null){
			return null;
		}
		
		List<List<TreeNode>> allSeq = getSequences(root);
		List<String> printable = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(List<TreeNode> seq : allSeq){
			sb.append("[ ");
			for(TreeNode node : seq){
				sb.append(node.value);
				sb.append(" ");
			}
			sb.append("]");
			printable.add(sb.toString());
			sb.setLength(0);
		}
		return printable;
	}

}
