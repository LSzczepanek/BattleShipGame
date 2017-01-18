package game;

import static game.GameHelper.A;
import static game.GameHelper.B;
import static game.GameHelper.C;
import static game.GameHelper.D;
import static game.GameHelper.E;

public class GameHelper {

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;

	public static String firePlayer(int x, int y, String player){
		
		if(player.equals(Game.player1.nick)){
			System.out.println("Fire Player1");
			return fire(x,y, Game.boardOfPlayer2, Game.realBoardOfPlayer2);
		}else if(player.equals(Game.player2.nick)){
			System.out.println("Fire player2");
			return fire(x,y,Game.boardOfPlayer1, Game.realBoardOfPlayer1);
		}else{
			return null;
		}
		
	}
	
	public static String fire(int x, int y, String[][] playerBoard, Ship[][] realBoard) {

		if(x==-1 || y>Game.boardOfPlayer1[0].length){
			return "OUT OF BOARD";
		}
		if (playerBoard[x][y].equals("B") && realBoard[x][y] == null) {
			playerBoard[x][y] = "H";
			return "MISS!";
		} else if (playerBoard[x][y].equals("S") && realBoard[x][y] !=null) {
			playerBoard[x][y] = "X";
			realBoard[x][y].getHit();
			if(realBoard[x][y].isShipDestroyed()){
				return "SHIP DESTROYED";
			}
			return "HIT";
		} else {
			return "WRONG";
		}
	}
	
	public static void setShipOnBoard(String coor, Ship ship, String player){
		if(player.equals(Game.player1.nick)){
			System.out.println("Player 1 set ship");
			setShipOnBoard(ship, coor, Game.boardOfPlayer1, Game.realBoardOfPlayer1);
			Game.player1.setAmountOfShips(Game.player1.getAmountOfShips()+1);
		}else if(player.equals(Game.player2.nick)){
			System.out.println("Player 2 set ship");
			setShipOnBoard(ship, coor, Game.boardOfPlayer2, Game.realBoardOfPlayer2);
			Game.player2.setAmountOfShips(Game.player2.getAmountOfShips()+1);
		}else{
			System.out.println("Something went wrong");
		}
		
	}

	public static void setShipOnBoard(Ship ship, String coor, String[][] board, Ship[][] realBoard) {
		String[] coord = coor.split("-");

		ship.setCoordinatesStart(coord[0]);
		ship.setCoordinatesEnd(coord[1]);

		if (ship.coordStart.getX() == ship.coordEnd.getX()) {
			for(int i = ship.coordStart.getY(); i <= ship.coordEnd.getY(); i++){
				board[ship.coordStart.getX()][i] = "S";
			}
			
			for(int i = ship.coordStart.getY(); i <= ship.coordEnd.getY(); i++){
				realBoard[ship.coordStart.getX()][i] = ship;
			}
		}else if(ship.coordStart.getY() == ship.coordEnd.getY()) {
			for(int i = ship.coordStart.getX(); i <= ship.coordEnd.getX(); i++){
				board[i][ship.coordStart.getY()] = "S";
			}
			
			for(int i = ship.coordStart.getX(); i <= ship.coordEnd.getX(); i++){
				realBoard[i][ship.coordStart.getY()] = ship;
			}
		} else {
			System.out.println("NOPE");
		}

	}
	
	public static int[] getCoords(String coord){
		int x;
		int y;
		y = Character.getNumericValue(coord.charAt(1));
		
		if(coord.charAt(0) == 'A'){
			x = A;
		}else if(coord.charAt(0) == 'B'){
			x = B;
		}else if(coord.charAt(0) == 'C'){
			x = C;
		}else if(coord.charAt(0) == 'D'){
			x = D;
		}else if(coord.charAt(0) == 'E'){
			x = E;
		}else{
			x = -1;
		}
		int[] coords  = {x,y};
		return coords;
	}

}
