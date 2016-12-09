package puzzles.cracking.chapter10;


public class ListySearch {

	public static class Listy{
		
		private int[] vals;
		
		public Listy(int[] vals){
			this.vals = vals;
		}
		
		public int elementAt(int index){
			if(index < 0 || index >= vals.length){
				return -1;
			} else {
				return vals[index];
			}
		}
	}

	public static int search(int target, Listy test) {
		
		int factor = 1;
		boolean growing = true;
		boolean found = false;
		int index = 0;
		
		while(factor > 0){
			
			System.out.println(index);
			
			int value = test.elementAt(index);
			
			if(target == value){
				found = true;
				break;
			}
			
			if(target > value && value >= 0){
				factor = growing ? factor * 2 : factor / 2;
				index += factor;
			} else {
				growing = false;
				factor /= 2;
				index -= factor;
			}
		}
		
		if(found){
			return index;
		} else {
			return -1;
		}
		
	}
	
}
