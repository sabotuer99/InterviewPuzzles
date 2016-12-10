package puzzles.cracking.chapter10;

public class StreamTracker {
	
	public class Node {
		public Node left;
		public Node right;
		public int size = 1;
		public int count = 1;
		public int value;

		public Node(int value){
			this.value = value;
		}
		
		public Node insert(int value) {
			return insert(new Node(value));
		}

		public Node insert(Node node) {
			size++;
			if (this.value == node.value) {
				this.count++;
			} else {
				if (this.value > node.value) {
					left = left == null ? node : left.insert(node);
				} else {
					right = right == null ? node : right.insert(node);
				}
			}
			return this;
		}

		public int rank(int target) {
			int leftSize = left == null ? 0 : left.size;
			if (value == target) {
				return count + leftSize;
			} else {
				if (value < target) {
					int rightRank = right == null ? 0 : right.rank(target);
					return count + leftSize + rightRank;
				} else {
					return left == null ? 0 : left.rank(target);
				}
			}
		}
	}

	public StreamTracker() {
	}

	private Node root;

	public void track(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	}

	public int rank(int value) {
		if (root == null) {
			return -1;
		} else {
			return root.rank(value) - 1;
		}
	}

}
