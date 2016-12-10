package puzzles.cracking.chapter10;

public class SparseSearch {

	public static int sparseSearch(String[] input, String target) {
		if (input == null || input.length == 0 || target == null) {
			return -1;
		}

		int left = 0;
		int right = input.length - 1;

		while ("".equals(input[left])) {
			left++;
		}

		while ("".equals(input[right])) {
			right--;
		}

		while (left < right) {
			int leftMiddle = (left + right) / 2;
			int rightMiddle = (left + right) / 2;

			String leftValue = input[leftMiddle];
			while ("".equals(leftValue)) {
				leftMiddle--;
				leftValue = input[leftMiddle];
			}

			String rightValue = input[rightMiddle];
			while ("".equals(rightValue)) {
				rightMiddle++;
				rightValue = input[rightMiddle];
			}

			if (rightValue.equals(target)) {
				return rightMiddle;
			}
			if (leftValue.equals(target)) {
				return leftMiddle;
			}

			if (target.compareTo(leftValue) < 0) {
				right = leftMiddle;
			} else {
				left = rightMiddle;
			}
		}

		return -1;
	}
}
