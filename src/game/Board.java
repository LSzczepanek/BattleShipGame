package game;


public class Board {
	
	public Board(){
		
	}
	public static void initlize(String[][] board){
//		String[][] tmpBoard = board.clone();
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        board[i][j] = "B";
		    }
		}
		
//		return tmpBoard;
	}

}
