package puzzles.cracking.chapter10;

public class PeakValley {

	public static int[] peakValley(int[] input) {
		if (input == null || input.length < 3) {
			return input;
		}

		for (int i = 1; i < input.length - 1; i++) {
			int left = input[i - 1];
			int here = input[i];
			int right = input[i + 1];
			if ((left > here && here > right) || (left < here && here < right)) {
				input[i] = right;
				input[i + 1] = here;
			}
		}

		return input;
	}

}
