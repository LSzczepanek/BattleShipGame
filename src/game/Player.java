package game;

public class Player {

	public boolean isMyTurn;
	public boolean isTaken;
	public boolean isReady;
	public String nick;
	public int amountOfShips = 0;
	public Ship ship2x1 = new Ship(2);
	public Ship ship3x1 = new Ship(3);
	public Ship ship4x1 = new Ship(4);
	
	public Ship getShip2x1() {
		return ship2x1;
	}

	public Ship getShip3x1() {
		return ship3x1;
	}

	public Ship getShip4x1() {
		return ship4x1;
	}

	public Player(String nick){
		this.isReady = false;
		this.nick = nick;
	}
	
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public int getAmountOfShips() {
		return amountOfShips;
	}
	public void setAmountOfShips(int amountOfShips) {
		this.amountOfShips = amountOfShips;
	}
	public boolean isMyTurn() {
		return isMyTurn;
	}
	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
}
