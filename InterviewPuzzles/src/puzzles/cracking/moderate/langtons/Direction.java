package puzzles.cracking.moderate.langtons;

public abstract class Direction {

	public abstract Point inFront(Point from);
	public abstract Direction turnClockwise();
	public abstract Direction turnCounterClockwise();
	
	public static class East extends Direction {

		@Override
		public Point inFront(Point from) {
			return new Point(from.x + 1, from.y);
		}

		@Override
		public Direction turnClockwise() {
			return new South();
		}

		@Override
		public Direction turnCounterClockwise() {
			return new North();
		}

	}
	
	public static class West extends Direction {

		@Override
		public Point inFront(Point from) {
			return new Point(from.x - 1, from.y);
		}

		@Override
		public Direction turnClockwise() {
			return new North();
		}

		@Override
		public Direction turnCounterClockwise() {
			return new South();
		}

	}
	
	public static class North extends Direction {

		@Override
		public Point inFront(Point from) {
			return new Point(from.x, from.y + 1);
		}

		@Override
		public Direction turnClockwise() {
			return new East();
		}

		@Override
		public Direction turnCounterClockwise() {
			return new West();
		}

	}
	
	public static class South extends Direction {

		@Override
		public Point inFront(Point from) {
			return new Point(from.x, from.y - 1);
		}

		@Override
		public Direction turnClockwise() {
			return new West();
		}

		@Override
		public Direction turnCounterClockwise() {
			return new East();
		}

	}

}
