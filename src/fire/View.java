package fire;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class View {
	private Controller c;
	private JFrame frame;
	private JPanel main;
	private Field p;
	
	
	public View(Controller controller){
		this.c = controller;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = new JPanel();
		main.setPreferredSize(new Dimension(1100,800));
		p = new Field(c.getGrid(), c.getSizeOfGridX(), c.getSizeOfGridY(), c, c);
		
		main.add(p);
		
		frame.getContentPane().add(main);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void repaintPanel(){
		p.repaint();
	}
	
	public void startTimer(){
		p.startTimer();
	}
}
