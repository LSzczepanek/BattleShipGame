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
	
	public boolean isShipDestroyed(){
		if(this.lifeOfShip == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void setCoordinatesStart(String coord){
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
		coordStart = new Coordinate(x, y);
	}
	
	public void setCoordinatesEnd(String coord){
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
		coordEnd = new Coordinate(x, y);
	}
	
	
}
