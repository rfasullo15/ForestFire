package fire;

import java.awt.Color;
import java.awt.Graphics;


public class PlotsOfLand {
	private int x;
	private int y;
	private int side;
	private Color color;
	private boolean isOnFire;


	public PlotsOfLand(Color c, int counterX, int counterY){
		//Make a square know its location in the array
		this.color = c;

		this.side = 20;
		
		this.x = counterX * side;
		this.y = counterY * side;
		isOnFire=false;
	}
	
	//Draws the square for you
	public void draw(Graphics page){
		page.setColor(this.color);
		page.fillRect(this.x, this.y, this.side, this.side);
	}
	
	public int getRow(){
		return this.y/side;
	}
	public int getCol(){
		return this.x/side;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getSide(){
		return this.side;
	}
	
	public boolean isInside(int clickX, int clickY){
		boolean isInside = false;
		if(((clickX > x) && (clickX < (x + side))) && ((clickY > y) && (clickY< y + side))) {
			isInside=true;
		}
		return isInside;
		
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setFire(){
		if (color== Color.green){
		color= Color.red;
		isOnFire=true;
		} else if (color == Color.red){
			color=Color.darkGray;
			isOnFire=false;
		}
	}
	
	public boolean isOnFire(){
		return isOnFire;
	}
	public boolean isAdjacent(PlotsOfLand other){
		boolean isAdjacent= false;
		if((x == other.x && (other.y== y + side || other.y == y-side)) ||
				(y== other.y && (other.x == x +side || other.x == x-side))){
			isAdjacent=true;
		}
		return isAdjacent;
		
	}
	
	
}