package fire;

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public class Model {
	private Controller c;
	private ArrayList<ArrayList<PlotsOfLand>> grid;
	private int sizeOfGridX;
	private int sizeOfGridY;
	private Random rand;
	private int counter;
	private ArrayList<PlotsOfLand> fire;
	
	public Model(Controller c){
		this.c = c;
		sizeOfGridX=1024;
		sizeOfGridY=768;
		grid = new ArrayList<ArrayList<PlotsOfLand>>();
		fire = new ArrayList<PlotsOfLand>();
		rand = new Random();
		
		for(int i =0; i<sizeOfGridX; i++){
			ArrayList<PlotsOfLand> tmp = new ArrayList<PlotsOfLand>();
			int j;
			for(j=0; j<sizeOfGridY; j++){
				Color tmp2;
				counter = rand.nextInt(2);
				if(counter==1){
					tmp2=Color.green;
				} else {
					tmp2 = Color.gray;
				}
				PlotsOfLand aPlotsOfLand = new PlotsOfLand(tmp2, i, j);
				tmp.add(aPlotsOfLand);
			}
			grid.add(tmp);
		}
	}
	
	public int getSizeOfGridX(){
		return sizeOfGridX;
	}
	
	public int getSizeOfGridY(){
		return sizeOfGridY;
	}
	
	public void addToFire(PlotsOfLand burn){
		fire.add(burn);
	}
	public ArrayList<ArrayList<PlotsOfLand>> getGrid(){
		return grid;
	}

	public int getSizeOfFire() {
		return fire.size();
	}
	
	public ArrayList<PlotsOfLand> getFire(){
		return fire;
	}
	
	public int getRow(PlotsOfLand fireSquare){
		return fireSquare.getRow();
	}
	
	public int getCol(PlotsOfLand fireSquare){
		return fireSquare.getCol();
	}

}
