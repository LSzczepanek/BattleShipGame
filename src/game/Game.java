package game;

import static game.GameHelper.*;

public class Game {

	static String[][] boardOfPlayer1 = new String[5][5];
	static Ship[][] realBoardOfPlayer1 = new Ship[5][5];
	static String[][] boardOfPlayer2 = new String[5][5];
	static Ship[][] realBoardOfPlayer2 = new Ship[5][5];
	static Player player1 = new Player("user");
	static Player player2 = new Player("user2");
	static Ship ship = new Ship(2);
	static Ship ship2 = new Ship(3);
	static boolean gameIsPrepared = false;

	public static void prepareGame() {
		Board.initlize(boardOfPlayer1);
		Board.initlize(boardOfPlayer2);

		System.out.println("Board player1");
		printBoard(boardOfPlayer1);

		System.out.println("\nBoard player2");
		printBoard(boardOfPlayer2);
		
		gameIsPrepared = true;

	}
	public static Ship[][] getRealP2(){
		return realBoardOfPlayer2;
	}
	public static boolean isGamePrepared(){
		return gameIsPrepared;
	}
	
	public static String getNickOfPlayer1(){
		return player1.nick;
	}
	public static String getNickOfPlayer2(){
		return player2.nick;
	}
	
	public static boolean areAllPlayersReady(){
		if(player1.isReady && player2.isReady){
			return true;
		}else{
			return false;
		}
	}
	
	public static void setReadyForPlayer(String nick, boolean isReady){
		if(nick.equals(player1.nick)){
			System.out.println("in set ready for player1");
			player1.setReady(isReady);
		}else if(nick.equals(player2.nick)){
			System.out.println("in set ready for player2");
			player2.setReady(isReady);
		}else{
			System.out.println("Error");
		}
	}
	
	public static Player getPlayer(String login){
		if(login.equals(player1.nick)){
			return player1;
		}else if(login.equals(player2.nick)){
			return player2;
		}else{
			return null;
		}
	}

	private static void printBoard(String[][] board) {
		for (String[] string : board) {
			System.out.println();
			for (String string2 : string) {
				System.out.print(string2 + " | ");
			}
		}
		System.out.println();
	}

	public static String[][] getBoardOfPlayer1(){
		return boardOfPlayer1;
	}
	
	public static String[][] getBoardOfPlayer2(){
		return boardOfPlayer2;
	}
	
	private static void actualGame() {

	}

	public static void main(String[] args) {

		prepareGame();
		ship = new Ship(3);
		setShipOnBoard(ship, "A0-A3", boardOfPlayer1, realBoardOfPlayer1);
		printBoard(boardOfPlayer1);
//		boardOfPlayer1[A][3] = "S";
//		printBoard(boardOfPlayer1);
		System.out.println("Ship life: "+ship.lifeOfShip);
		System.out.println(GameHelper.fire(A, 2, boardOfPlayer1, realBoardOfPlayer1));
		System.out.println("Ship life: "+ship.lifeOfShip);
		System.out.println(GameHelper.fire(A, 1, boardOfPlayer1, realBoardOfPlayer1));
		System.out.println("Ship life: "+ship.lifeOfShip);
		printBoard(boardOfPlayer1);
	}

}
