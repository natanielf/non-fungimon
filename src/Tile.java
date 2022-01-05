public class Tile {

	private int[][] board;
	private double chance;

	public Tile() {
		board = new int[20][30];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				// set the type of ground (0 = floor, 1 = grass)
				if (r < 10)
					board[r][c] = 1;
				else
					board[r][c] = 0;
			}
		}
	}
	
	public int getWidth() {
		return board[0].length;
	}
	
	public int getHeight() {
		return board.length;
	}
	
	public int getType(int r, int c) {
		return board[r][c];
	}
}