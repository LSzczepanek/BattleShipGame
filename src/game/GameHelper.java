package game;

public class GameHelper {

	public static final int A = 1;
	public static final int B = 2;
	public static final int C = 3;
	public static final int D = 4;
	public static final int E = 5;
	public static final int F = 6;
	public static final int G = 7;
	public static final int H = 8;
	public static final int I = 9;
	public static final int J = 10;

	public static String firePlayer(int x, int y, String player) {

		if (player.equals(Game.player1.nick)) {
			if (Game.player1.getAmountOfShips() == 0) {
				return "YOU LOST";
			}
			System.out.println("Fire Player1");
			String result = fire(x, y, Game.boardOfPlayer2, Game.realBoardOfPlayer2);
			if (result.equals("SHIP DESTROYED")) {
				Game.player2.setAmountOfShips(Game.player2.getAmountOfShips() - 1);
			}
			if (Game.player2.getAmountOfShips() == 0) {
				result = "YOU WON";
			}
			return result;
		} else if (player.equals(Game.player2.nick)) {
			if (Game.player2.getAmountOfShips() == 0) {
				return "YOU LOST";
			}
			System.out.println("Fire player2");
			String result = fire(x, y, Game.boardOfPlayer1, Game.realBoardOfPlayer1);
			if (result.equals("SHIP DESTROYED")) {
				Game.player1.setAmountOfShips(Game.player1.getAmountOfShips() - 1);
			}
			if (Game.player1.getAmountOfShips() == 0) {
				result = "YOU WON";
			}
			return result;
		} else {
			return null;
		}

	}

	public static String fire(int x, int y, String[][] playerBoard, Ship[][] realBoard) {

		int newY = y + 1;
		if (x == -1 || newY > Game.boardOfPlayer1[0].length) {
			return "OUT OF BOARD";
		}
		// y++;
		if (playerBoard[x][newY].equals("W") && realBoard[x][newY] == null) {
			playerBoard[x][newY] = "O";
			return "MISS!";
		} else if (playerBoard[x][newY].equals("S") && realBoard[x][newY] != null) {
			playerBoard[x][newY] = "X";
			realBoard[x][newY].getHit();
			if (realBoard[x][newY].isShipDestroyed()) {
				return "SHIP DESTROYED";
			}
			return "HIT";
		} else {
			return "WRONG";
		}
	}

	public static boolean setShipOnBoard(String coor, Ship ship, String player) {
		if (player.equals(Game.player1.nick)) {
			System.out.println("Player 1 set ship");
			if (setShipOnBoard(ship, coor, Game.boardOfPlayer1, Game.realBoardOfPlayer1)) {
				Game.player1.setAmountOfShips(Game.player1.getAmountOfShips() + 1);
				return true;
			} else {
				System.out.println("Player 1 failed to set ship!");
				return false;
			}

		} else if (player.equals(Game.player2.nick)) {
			System.out.println("Player 2 set ship");
			if (setShipOnBoard(ship, coor, Game.boardOfPlayer2, Game.realBoardOfPlayer2)) {
				Game.player2.setAmountOfShips(Game.player2.getAmountOfShips() + 1);
				return true;
			} else {
				System.out.println("Player 2 failed to set ship!");
				return false;
			}

		} else {
			System.out.println("Something went wrong");
			return false;
		}

	}

	public static boolean setShipOnBoard(Ship ship, String coor, String[][] board, Ship[][] realBoard) {
		String[] coord = coor.split("-");

		ship.setCoordinatesStart(coord[0]);
		ship.setCoordinatesEnd(coord[1]);

		int start;
		int end;
		if (ship.coordStart.getX() == ship.coordEnd.getX()) {
			if (ship.getSize() != (Math.abs(ship.coordStart.getY() - ship.coordEnd.getY()) + 1)) {
				return false;
			}

			for (int i = ship.coordStart.getY() - 1; i <= ship.coordEnd.getY() + 1; i++) {
				try {
					if (board[ship.coordStart.getX()][i].equals("S")) {
						return false;
					}

					if (board[ship.coordStart.getX() - 1][i].equals("S")) {
						return false;
					}
					if (board[ship.coordStart.getX() + 1][i].equals("S")) {
						return false;
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println("Out of board");
				}
			}

			if (ship.coordStart.getY() > ship.coordEnd.getY()) {
				start = ship.coordEnd.getY();
				end = ship.coordStart.getY();
			} else {
				start = ship.coordStart.getY();
				end = ship.coordEnd.getY();
			}

			for (int i = start; i <= end; i++) {

				board[ship.coordStart.getX()][i] = "S";
			}

			for (int i = start; i <= end; i++) {
				realBoard[ship.coordStart.getX()][i] = ship;
			}
			return true;
		} else if (ship.coordStart.getY() == ship.coordEnd.getY()) {
			if (ship.getSize() != (Math.abs(ship.coordStart.getX() - ship.coordEnd.getX()) + 1)) {
				return false;
			}

			for (int i = ship.coordStart.getX() - 1; i <= ship.coordEnd.getX() + 1; i++) {
				try {
					if (board[i][ship.coordStart.getY()].equals("S")) {
						return false;
					}

					if (board[i][ship.coordStart.getY() - 1].equals("S")) {
						return false;
					}
					if (board[i][ship.coordStart.getY() + 1].equals("S")) {
						return false;
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println("Out of board");
				}
			}

			if (ship.coordStart.getX() > ship.coordEnd.getX()) {
				start = ship.coordEnd.getX();
				end = ship.coordStart.getX();
			} else {
				start = ship.coordStart.getX();
				end = ship.coordEnd.getX();
			}

			for (int i = start; i <= end; i++) {

				board[i][ship.coordStart.getY()] = "S";
			}

			for (int i = start; i <= end; i++) {
				realBoard[i][ship.coordStart.getY()] = ship;
			}
			return true;
		} else {

			System.out.println("Error while setting ship");
			return false;
		}

	}

	public static int[] getCoords(String coord) {
		int x;
		int y;
		y = Character.getNumericValue(coord.charAt(1));

		if (coord.charAt(0) == 'A') {
			x = A;
		} else if (coord.charAt(0) == 'B') {
			x = B;
		} else if (coord.charAt(0) == 'C') {
			x = C;
		} else if (coord.charAt(0) == 'D') {
			x = D;
		} else if (coord.charAt(0) == 'E') {
			x = E;
		} else if (coord.charAt(0) == 'F') {
			x = F;
		} else if (coord.charAt(0) == 'G') {
			x = G;
		} else if (coord.charAt(0) == 'H') {
			x = H;
		} else if (coord.charAt(0) == 'I') {
			x = I;
		} else if (coord.charAt(0) == 'J') {
			x = J;
		} else {
			x = -1;
		}
		int[] coords = { x, y };
		return coords;
	}

}
