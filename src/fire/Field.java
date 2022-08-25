package fire;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Field extends JPanel {
	private ArrayList<ArrayList<PlotsOfLand>> grid;
	private int sizeOfGridX;
	private int sizeOfGridY;
	private Timer t;

	public Field(ArrayList<ArrayList<PlotsOfLand>> grid, int sizeOfGridX, int sizeOfGridY, MouseListener controller, ActionListener controller2) {
		this.grid = grid;
		this.sizeOfGridX = sizeOfGridX;
		this.sizeOfGridY = sizeOfGridY;
		this.setPreferredSize(new Dimension(1100,800));
		this.setBackground(Color.white);
		this.addMouseListener(controller);
		t= new Timer(75, controller2);
		


		
	}
	
	@Override
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		for(int i =0; i<sizeOfGridX; i++){
			for(int j=0; j<sizeOfGridY; j++){
				grid.get(i).get(j).draw(page);
			}
			
		}
			
	}
	
	public void startTimer(){
		t.start();
	}
}
