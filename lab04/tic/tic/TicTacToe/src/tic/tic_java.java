package tic;

public class tic_java {
	
	/*	public static String emptyboard(int indxX, int indxY){
	String[][] board= new String[indxX][indxY];
	for (int x=0; x<indxX; x++) {
		for(int y=0; y<indxY; y++) {
			board[x][y]="_";
		}
	}
	return board[indxX-1][indxY-1];
}	*/
	
	String[][] board = new String[3][3];		// default board is 3x3 
	
	public void makeBoard(int X, int Y) {		// can specify a board size
		String[][] newBoard = new String[X][Y];
		board=newBoard;
	}
	

	
	public String placeX(int X, int Y) {		// can place X within board

		board[X-1][Y-1]="X";
		return board[X-1][Y-1];
		
	}
}
