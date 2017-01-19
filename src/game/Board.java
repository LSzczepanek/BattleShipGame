package game;


public class Board {
	
	public Board(){
		
	}
	public static void initlize(String[][] board){
//		String[][] tmpBoard = board.clone();
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        board[i][j] = "W";
		    }
		}
		char letter = 'A';
		for(int i = 1; i < board.length; i++ ){
			board[i][0] = Character.toString(letter++);
		}
		
		for(int i = 1; i < board[0].length; i++ ){
			board[0][i] = Integer.toString(i-1);
		}
		board[0][0] = "";
		
//		return tmpBoard;
	}

}
