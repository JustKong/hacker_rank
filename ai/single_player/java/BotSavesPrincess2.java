package ai;

public class BotSavesPrincess2 {

	static final String LEFT = "LEFT";
	static final String RIGHT = "RIGHT";
	static final String UP = "UP";
	static final String DOWN = "DOWN";
	static final String ERROR = "ERROR";
	
	static final char PRINCESS = 'p';
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void nextMove(int n, int x, int y, String[] board) {
		Position princessPos = getPrincessPosition(n, board);
		printMove(princessPos, y, x);		
	}
	
	static Position getPrincessPosition(int n, String[] board) {
		for (int y = 0; y < n; y++) {
			String line = board[y];
			int x = line.indexOf(PRINCESS);
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
	static void printMove(Position princessPos, int x, int y) {
		int diffX = princessPos.x - x;
		int diffY = princessPos.y - y;
		
		if (diffX < 0) {
			System.out.println(LEFT);
		}
		else if (diffX > 0) {
			System.out.println(RIGHT);
		}
		else if (diffY < 0) {
			System.out.println(UP);
		}
		else if (diffY > 0) {
			System.out.println(DOWN);
		}
	}
	

	/*	static void nextMove(int n, int x, int y, String[] board) {
	// Examine the cells above and below
	for (int i = 0; i < n; i++) {
		String line = board[i];
		if (line.charAt(x) == PRINCESS) {
			if (i < y)
				System.out.println(UP);
			else if (i > y) 
				System.out.println(DOWN);
			else
				System.out.println(ERROR);
		}
	}
	
	String line = board[y];
	int xPos = line.indexOf(PRINCESS);
	if (xPos == -1 || xPos == x)
		System.out.println(ERROR);
	else if (xPos < x)
		System.out.println(LEFT);
	else
		System.out.println(RIGHT);
}*/
	
}
