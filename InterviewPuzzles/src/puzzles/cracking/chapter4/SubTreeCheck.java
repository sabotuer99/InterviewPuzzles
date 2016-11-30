package puzzles.cracking.chapter4;


public class SubTreeCheck {

	
	public static boolean isSubTreeNaive(TreeNode  T1, TreeNode T2){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		calls = 0;
		
		buildSign(sb1, T1);
		buildSign(sb2, T2);
		
		System.out.println("Total Calls, Naive: " + calls);
		
		return sb1.toString().indexOf(sb2.toString()) > -1;
	}
	
	public static boolean isSubTree(TreeNode T1, TreeNode T2){
		StringBuilder sb2 = new StringBuilder();
		
		calls = 0;
			
		buildSign(sb2, T2);
		String key = sb2.toString();
		
		boolean found = findKey(new StringBuilder(), T1, key);
		
		System.out.println("Total Calls, Better: " + calls);
		
		return found;
	}
	
	private static int calls = 0;
	private static boolean findKey(StringBuilder sb, TreeNode node, String key) {
		calls++;
		System.out.println(sb.toString());
		
		if(key == null || node == null){
			return false;
		}
		
		//single node subtree is special case
		if(key.length() == 3 && node.left == null && node.right == null){
			return Integer.toString(node.value).equals(key.substring(1, 2));
		}
		
		//this is min node, kick off new sequence
		if(sb.length() == 0 && node.left == null && (node.parent == null || node.parent.left == node)){
			sb.append("L");
			sb.append(node.value);
			if(node.right == null){
				sb.append("R");
				return false;
			} else {
				return findKey(sb, node.right, key);
			}
		}
		
		//check for key in subtrees	
		boolean found = false;
		if(node.left == null && sb.length() > 0){
			sb.append("L");
		} else {
			found = findKey(sb, node.left, key);	
		}	
		if(found){
			return true;
		}
		
		if(sb.length() > 0){
			sb.append(node.value);
		}
		
		if(node.right == null && sb.length() > 0){
			sb.append("R");
		} else {
			found = findKey(sb, node.right, key);
		}	
		if(found){
			return true;
		}
		
		if(sb.length() >= key.length()){
		    found = sb.toString().equals(key);
			sb.setLength(0);
			return found;
		}
		
		return false;
	}

	public static void buildSign(StringBuilder sb, TreeNode node){
		calls++;
		if(node == null){
			return;
		}
		
		
		if(node.left == null){
			sb.append("L");
		} else {
			buildSign(sb, node.left);
		}
		
		sb.append(node.value);
		
		if(node.right == null){
			sb.append("R");
		} else {
			buildSign(sb, node.right);
		}
	}

}
