package puzzles.cracking.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfDepths {

	public static Map<Integer, List<TreeNode>> getDepths(TreeNode root) {
		if(root == null){
			return null;
		}
		
		Map<Integer, List<TreeNode>> listOfDepths = new HashMap<>();
		Deque<TreeNode> q = new ArrayDeque<>();
		Deque<Integer> depths = new ArrayDeque<>();
		TreeNode current = root;
		q.offer(root);
		depths.offer(1);
		while(q.size() > 0){
			current = q.poll();
			int curDepth = depths.poll();
			if(current.left != null){
				q.offer(current.left);
				depths.offer(curDepth + 1);
			}
			if(current.right != null){
				q.offer(current.right);
				depths.offer(curDepth + 1);
			}
			if(!listOfDepths.containsKey(curDepth)){
				listOfDepths.put(curDepth, new ArrayList<TreeNode>());
			}
			listOfDepths.get(curDepth).add(current);
		}
		return listOfDepths;
	}

	
}
