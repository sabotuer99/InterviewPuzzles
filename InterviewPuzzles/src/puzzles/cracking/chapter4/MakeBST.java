package puzzles.cracking.chapter4;

public class MakeBST {

	private static TreeNode makeBst(int start, int end, int[] array){
		if(start == end){
			return new TreeNode(array[start]);
		}
		
		int middle = start + (end - start)/2;
		TreeNode root = new TreeNode(array[middle]);
		if(start != middle){
			root.left = makeBst(start, middle-1, array);
		}
		if(end != middle){
			root.right = makeBst(middle + 1, end, array);
		}
		return root;
	}
	
	public static TreeNode toBst(int[] array){
		if(array == null || array.length == 0){
			return null;
		}
		
		return makeBst(0, array.length - 1, array);
	}
}
