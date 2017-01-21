package game;

import static game.GameHelper.*;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class Game {

	static String[][] boardOfPlayer1 = new String[11][11];
	static Ship[][] realBoardOfPlayer1 = new Ship[11][11];
	static String[][] boardOfPlayer2 = new String[11][11];
	static Ship[][] realBoardOfPlayer2 = new Ship[11][11];
	static Player player1 = new Player("user");
	static Player player2 = new Player("user2");
	static Ship ship = new Ship(2);
	static Ship ship2 = new Ship(3);
	static boolean gameIsPrepared = false;
/**
 * Funkcja realizje przygotwanie gry, inicjalzuje każdy obiekt wymagany do startu
 */
	public static void prepareGame() {
		Board.initlize(boardOfPlayer1);
		Board.initlize(boardOfPlayer2);

		System.out.println("Board player1");
		printBoard(boardOfPlayer1);

		System.out.println("\nBoard player2");
		printBoard(boardOfPlayer2);
		
		gameIsPrepared = true;
		player1 = new Player("user");
		player2 = new Player("user2");
		
		player1.setMyTurn(true);
		player2.setMyTurn(false);

	}
	
	
	/**
	 * Funkcja zwraca plansze odpowiedniego gracza
	 * @param nick - nazwa loginu gracza
	 * @return zwraca tablice 2 wymiarowa, która jest de facto naszą planszą
	 */
	public static String[][] getPlayerBoard(String nick){
		if(nick.equals(Game.getNickOfPlayer1())){
			return getBoardOfPlayer1();
		}if(nick.equals(Game.getNickOfPlayer2())){
			return getBoardOfPlayer2();
		}else{
			return null;
		}
		
	}
	
	public static Ship[][] getRealP2(){
		return realBoardOfPlayer2;
	}
	public static boolean isGamePrepared(){
		return gameIsPrepared;
	}
	
	public static void setisGamePreparedFalse(){
		gameIsPrepared = false;
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
	/**
	 * Funkcja pokazuje kogo jest obecnie tura
	 * @param nick - potrzebny do identyfikacji kto woła metode
	 * @return zwraca "MY TURN" albo "ENEMY TURN"
	 */
	public static String showWhosTurn(String nick){
		String result;
		if(nick.equals(Game.getNickOfPlayer1())){
			
			if(player1.checkIsMyTurn()){
				result = "MY TURN";
			}else{
				result = "ENEMY TURN";
			}
		}else if(nick.equals(Game.getNickOfPlayer2())){
			
			if(player2.checkIsMyTurn()){
				result = "MY TURN";
			}else{
				result = "ENEMY TURN";
			}
		}else{
			result = "NO ONE TURN";
		}
		
		return result;
	}
	/**
	 * Sprawdza czy jest to tura danego gracza
	 * @param nick wymagany do identyfikacji kto wywołał metode
	 * @return
	 */
	public static boolean isPlayerTurn(String nick){
		if(nick.equals(Game.getNickOfPlayer1())){
			return player1.checkIsMyTurn();
		}if(nick.equals(Game.getNickOfPlayer2())){
			return player2.isMyTurn();
		}else{
			return false;
		}
		
	}
	
	/**
	 * Przekazuje ture do drugiego gracza
	 * @param nick wymagany do identyfikacji kto wywołał metode
	 */
	
	public static void setSecondPlayerTurn(String nick){
		if(nick.equals(Game.getNickOfPlayer1())){
			player1.setMyTurn(false);
			player2.setMyTurn(true);
		}if(nick.equals(Game.getNickOfPlayer2())){
			player1.setMyTurn(true);
			player2.setMyTurn(false);
		}
	}
	/**
	 * Ustawia graczowu, że jest gotowy na gre, które jest potem potrzebne do wystartowania partii
	 * @param nick wymagany do identyfikacji kto wywołał metode
	 * @param isReady wartość na jaka powinna ustawic sie gracza gotowość
	 */
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
	/**
	 * Zwraca gracza
	 * @param login wymagany do identyfikacji kto wywołał metode
	 * @return Player
	 */
	public static Player getPlayer(String login){
		if(login.equals(player1.nick)){
			return player1;
		}else if(login.equals(player2.nick)){
			return player2;
		}else{
			return null;
		}
	}

/**
 * Uzyta tylko wewnetrznie na konsoli, wystepuje w celach sprawdzania poprawności na serwerze
 * @param board plansza do wyświetlenia
 */
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
	
}
