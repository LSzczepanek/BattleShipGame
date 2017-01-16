package game;

public class GameHelper {

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;

	public static String fire(int x, int y, String[][] playerBoard, Ship[][] realBoard) {

		if (playerBoard[x][y].equals("B") && realBoard[x][y] == null) {
			return "MISS!";
		} else if (playerBoard[x][y].equals("S") && realBoard[x][y] !=null) {
			playerBoard[x][y] = "H";
			realBoard[x][y].getHit();
			return "HIT";
		} else {
			return "WRONG";
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

}
