package game;

import static game.GameHelper.*;

public class Game {

	static String[][] boardOfPlayer1 = new String[5][5];
	static Ship[][] realBoardOfPlayer1 = new Ship[5][5];
	static String[][] boardOfPlayer2 = new String[5][5];
	static Player player1 = new Player();
	static Player player2 = new Player();
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
	
	public static boolean isGamePrepared(){
		return gameIsPrepared;
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
