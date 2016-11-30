package puzzles.cracking.chapter4;


public class SubTreeCheck {

	
	public static boolean isSubTreeNaive(TreeNode  T1, TreeNode T2){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		buildSign(sb1, T1);
		buildSign(sb2, T2);
		
		return sb1.toString().indexOf(sb2.toString()) > -1;
	}
	
	
	public static void buildSign(StringBuilder sb, TreeNode node){
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
