package fire;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;



public class Controller implements MouseListener, ActionListener {

	private Model m;
	private View v;
	private int counter;
	private int mouseX;
	private int mouseY;
	private PlotsOfLand p;
	private ArrayList<PlotsOfLand> tmp2;

	public Controller(){
		m= new Model(this);
		v= new View(this);
		counter = 0;
		tmp2 = new ArrayList<PlotsOfLand>();
	}

	public int getSizeOfGridX(){
		return m.getSizeOfGridX();
	}

	public int getSizeOfGridY(){
		return m.getSizeOfGridY();
	}

	public ArrayList<ArrayList<PlotsOfLand>> getGrid(){
		return m.getGrid();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PlotsOfLand tmp;
		for(int n = 0; n<m.getSizeOfFire(); n++){
			tmp = m.getFire().get(n);
			//look between the row-1 and row+1 
			// look between the col-1 and col+1
			//check to see if the index is larger than the index of the grid, you dont want it to be out of bounds
			for(int k =m.getRow(tmp)-1; k<=m.getRow(tmp) +1; k++){
				for(int w=m.getCol(tmp)-1; w<=m.getCol(tmp)+1; w++){
					if(!(k>=m.getSizeOfGridX() || w>=m.getSizeOfGridY() || w<0 || k<0)){ 
						//if(tmp.isAdjacent(m.getGrid().get(w).get(k))){
						m.getGrid().get(w).get(k).setFire(); 
						if(m.getGrid().get(w).get(k).isOnFire()){
							tmp2.add(m.getGrid().get(w).get(k));
						}

						//						m.addToFire(m.getGrid().get(k).get(w));
						//if these squares are adjacent to the clicked square,
						//tmp.isAdjacent(m.getGrid().get(k).get(w))
						// then burn the adjacent squares
						//The question is, how do I make the other squares burn?
						//ok, well, they burn, but.... not in all directions... and it disregards dirt
						//Now they burn, but at some point it stops
						//Not all of the burning squares are turning red?




						//I need to know which squares are on fire
						//I need to know which squares are adjacent to the ones that are on fire
						//Then i set the ones that are adjacent to those on fire 
						//rinse and repeat
					}
				}
			}
		}
		for(int w=0; w<tmp2.size(); w++){
			m.addToFire(tmp2.get(w));
		}

		p.setFire();
		v.repaintPanel();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i =0; i<m.getSizeOfGridX(); i++){
			for(int j=0; j<m.getSizeOfGridY(); j++){
				if(m.getGrid().get(i).get(j).isInside(e.getX(), e.getY())) {
					m.getGrid().get(i).get(j).setFire();
					p= m.getGrid().get(i).get(j);
					m.addToFire(m.getGrid().get(i).get(j));
				}
			}
		}
		mouseX= e.getX();
		mouseY= e.getY();

		v.repaintPanel();
		v.startTimer();

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

//for(int g = 0; g<m.getFire().size(); g++){
//if(!m.getFire().get(g).isOnFire()){
//	m.getFire().remove(m.getFire().get(g));
//}
//}
//if(m.getGrid().get(k).get(w).isOnFire()){
//					for(int i = 0; i<m.getSizeOfGridX(); i++){
//						for(int j=0; j<m.getSizeOfGridY(); j++){
//							if(m.getGrid().get(k).get(w).isAdjacent(m.getGrid().get(i).get(j))){
//								m.getGrid().get(i).get(j).setFire();
//							}
//						}
//					}
//				}
//Thats not it 