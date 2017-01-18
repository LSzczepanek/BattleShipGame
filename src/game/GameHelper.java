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

	public static String firePlayer1(int x, int y){
		System.out.println("Fire Player1");
		return fire(x,y, Game.boardOfPlayer1, Game.realBoardOfPlayer1);
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
			return "HIT";
		} else {
			return "WRONG";
		}
	}
	
	public static void setShipOnBoard(String coor){
		setShipOnBoard(Game.ship, coor, Game.boardOfPlayer1, Game.realBoardOfPlayer1);
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
