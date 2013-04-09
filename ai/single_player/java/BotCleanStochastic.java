package ai;

public class BotCleanStochastic {

	static final char BOT_CHAR = 'b';
	static final char DIRTY_CHAR = 'd';
	static final char CLEAN_CHAR = '-';
	
	static final String LEFT = "LEFT";
	static final String RIGHT = "RIGHT";
	static final String UP = "UP";
	static final String DOWN = "DOWN";
	static final String CLEAN = "CLEAN";
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void nextMove(int posx, int posy, String[] board) {
		// If we're on a dirty cell, clean it
		String line = board[posx];
		if (line.charAt(posy) == DIRTY_CHAR) {
			System.out.println(CLEAN);
			return;
		}
		
		Position dirtyCell = null;
		for (int row = 0; row < board.length; row++) {
			line = board[row];
			int dirtyCol = line.indexOf(DIRTY_CHAR);
			if (dirtyCol != -1) {
				dirtyCell = new Position(dirtyCol, row); // There should only be one dirty cell per board
				break;
			}
		}
		
		// Shouldn't happen
		if (dirtyCell == null)
			return;
		
		printMove(dirtyCell, posy, posx);
	}

	/*
	 *  Legend:
	 *  -diffX = move LEFT
	 *  +diffX = move RIGHT
	 *  -diffY = move UP
	 *  +diffY = move DOWN
	 */
	static void printMove(Position dirtyCell, int x, int y) {
		int diffX = dirtyCell.x - x;
		int diffY = dirtyCell.y - y;
		
		if (diffX < 0) 
			System.out.println(LEFT);
		else if (diffX > 0) 
			System.out.println(RIGHT);
		else if (diffY < 0) 
			System.out.println(UP);
		else if (diffY > 0) 
			System.out.println(DOWN);
	}
	
}
