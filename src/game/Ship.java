package game;

import static game.GameHelper.*;

public class Ship {

	int sizeOfShip;
	boolean isDestroyed;
	int lifeOfShip;
	Coordinate coordStart;
	Coordinate coordEnd;
	
	public Ship(int size){
		this.sizeOfShip = size;
		this.lifeOfShip = size;
		
	}
	
	public int getHP(){
		return lifeOfShip;
	}
	
	public void getHit(){
		this.lifeOfShip = this.lifeOfShip-1;
	}
	
	public int getSize(){
		return sizeOfShip;
	}
	
	public boolean isShipDestroyed(){
		if(this.lifeOfShip == 0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Ustawia początek statku na podanej pozycji
	 * @param coord kordynaty
	 */
	public void setCoordinatesStart(String coord){
		int x;
		int y;
		y = Character.getNumericValue(coord.charAt(1));
		y++;
		
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
		}else if(coord.charAt(0) == 'F'){
			x = F;
		}else if(coord.charAt(0) == 'G'){
			x = G;
		}else if(coord.charAt(0) == 'H'){
			x = H;
		}else if(coord.charAt(0) == 'I'){
			x = I;
		}else if(coord.charAt(0) == 'J'){
			x = J;
		}else{
			x = -1;
		}
		coordStart = new Coordinate(x, y);
	}
	/**
	 * Ustawia koniec statku na podanej pozycji
	 * @param coord koordynaty
	 */
	public void setCoordinatesEnd(String coord){
		int x;
		int y;
		y = Character.getNumericValue(coord.charAt(1));
		y++;
		
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
		}else if(coord.charAt(0) == 'F'){
			x = F;
		}else if(coord.charAt(0) == 'G'){
			x = G;
		}else if(coord.charAt(0) == 'H'){
			x = H;
		}else if(coord.charAt(0) == 'I'){
			x = I;
		}else if(coord.charAt(0) == 'J'){
			x = J;
		}else{
			x = -1;
		}
		coordEnd = new Coordinate(x, y);
	}
	
	
}
