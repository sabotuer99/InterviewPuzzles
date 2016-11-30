package puzzles.cracking.chapter5;

public class Insertion {

	public static int insert(int N, int M, int i, int j) {
		int mask = (-1 << j+1) | ~(-1 << i);
		return (N & mask) | (M << i);
	}
}
