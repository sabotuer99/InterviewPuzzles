package puzzles.cracking.chapter5;

public class PairwiseSwap {

	public static int swapBits(int n){
		return ((n & BitUtils.EVEN_BITS) << 1) | ((n & BitUtils.ODD_BITS) >> 1);
	}
}
