package ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 *  Using the greedy algorithm to solve this. There are definitely board configurations that would cause this 
 *  algorithm to fail, but since this solution gives the maximum number of points, I'm going with it for now. 
 */

public class BotClean {

	static final int BOARD_SIZE = 5;

	static final char BOT_CELL = 'b';
	static final char DIRTY_CELL = 'd';
	static final char CLEAN_CELL = '-';
	
	static final String LEFT = "LEFT";
	static final String RIGHT = "RIGHT";
	static final String UP = "UP";
	static final String DOWN = "DOWN";
	static final String CLEAN = "CLEAN";
	
	static List<Position> dirtyCells;
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class PositionComparator<T extends Position> implements Comparator<Position> {
		
		private Position p;
		
		public PositionComparator(Position p) {
			this.p = p;
		}
		
		public int compare(Position p1, Position p2) {
			int p1Dist = Math.abs(p1.x - p.x) + Math.abs(p1.y - p.y);
			int p2Dist = Math.abs(p2.x - p.x) + Math.abs(p2.y - p.y);
			
			if (p1Dist > p2Dist)
				return 1;
			else if (p1Dist < p2Dist)
				return -1;
			else
				return 0;
		}
	}
	
	static void next_move(int posx, int posy, String[] board) {
		// Reversing  posx and posy, because their notion of x and y is opposite of what I'm imagining
		int x = posy;
		int y = posx;
		
		if (dirtyCells == null)
			computePath(x, y, board);
		
		printMove(dirtyCells.get(0), x, y);
	}
	
	static void computePath(int x, int y, String[] board) {
		List<Position> dirtyCellsUnsorted = new ArrayList<Position>();
		for (int row = 0; row < board.length; row++) {
			String line = board[row];
			
			int dirtyCol = 0;
			while ((dirtyCol = line.indexOf(DIRTY_CELL, dirtyCol)) != -1) {
				dirtyCellsUnsorted.add(new Position(dirtyCol, row));
				dirtyCol++;
			}
		}
		
		Position currPos = new Position(x, y);
		dirtyCells = new ArrayList<Position>();
		while (!dirtyCellsUnsorted.isEmpty()) {
			Collections.sort(dirtyCellsUnsorted, new PositionComparator<Position>(currPos));
			
			currPos = dirtyCellsUnsorted.remove(0);
			dirtyCells.add(currPos);
		}
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
		
		if (diffX == 0 && diffY == 0)
			System.out.println(CLEAN);
		else if (diffX < 0)
			System.out.println(LEFT);
		else if (diffX > 0)
			System.out.println(RIGHT);
		else if (diffY < 0)
			System.out.println(UP);
		else if (diffY > 0)
			System.out.println(DOWN);
	}

}
