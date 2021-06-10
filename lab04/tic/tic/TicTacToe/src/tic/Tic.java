package tic;

public class Tic {
	
/*	public static String emptyboard(int indxX, int indxY){
		String[][] board= new String[indxX][indxY];
		for (int x=0; x<indxX; x++) {
			for(int y=0; y<indxY; y++) {
				board[x][y]="_";
			}
		}
		return board[indxX-1][indxY-1];
	}	*/
	
	
	
	public static String placeX(int X, int Y) {
		String[][] board = new String[X][Y];
		board[X-1][Y-1]="X";
		return board[X][Y];
		
	}
}
