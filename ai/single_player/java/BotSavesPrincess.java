public class BotSavesPrincess {

	static final String LEFT = "LEFT";
	static final String RIGHT = "RIGHT";
	static final String UP = "UP";
	static final String DOWN = "DOWN";
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void nextMove(int m, String[] grid) {
		Position princessPos = getPrincessPosition(m, grid);
		Position botPos = getBotPosition(m, grid);
		printMoves(princessPos, botPos);		
	}
	
	static Position getPrincessPosition(int m, String[] grid) {
		String line = grid[0];
		if (line.charAt(0) == 'p')
			return new Position(0, 0); // Top left
		else if (line.charAt(m - 1) == 'p')
			return new Position(m - 1, 0); // Top right
		
		line = grid[m - 1];
		if (line.charAt(0) == 'p')
			return new Position(0, m - 1); // Bottom left 
		else if (line.charAt(m - 1) == 'p')
			return new Position(m - 1, m - 1); // Bottom right

		return new Position(-1, -1); // Shouldn't reach this point
	}
	
	static Position getBotPosition(int m, String[] grid) {
		for (int y = 0; y < m; y++) {
			String line = grid[y];
			int x = line.indexOf('m');
			if (x != -1)
				return new Position(x, y);
		}
		
		return new Position(-1, -1); // Shouldn't reach this point
	}
	
	/*
	 *  Legend:
	 *  -diffX = move LEFT
	 *  +diffX = move RIGHT
	 *  -diffY = move UP
	 *  +diffY = move DOWN
	 */
	static void printMoves(Position princessPos, Position botPos) {
		int diffX = princessPos.x - botPos.x;
		int diffY = princessPos.y - botPos.y;
		
		StringBuilder builder = new StringBuilder();
		if (diffX < 0) {
			diffX *= -1;
			for (int i = 0; i < diffX; i++) {
				builder.append(LEFT);
				builder.append('\n');
			}
		}
		else if (diffX > 0) {
			for (int i = 0; i < diffX; i++) {
				builder.append(RIGHT);
				builder.append('\n');
			}
		}
		
		if (diffY < 0) {
			diffY *= -1;
			for (int i = 0; i < diffY; i++) {
				builder.append(UP);
				builder.append('\n');
			}
		}
		else if (diffY > 0) {
			for (int i = 0; i < diffY; i++) {
				builder.append(DOWN);
				builder.append('\n');
			}
		}
		
		System.out.println(builder.toString());
	}
	
}
