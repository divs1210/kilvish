package example1_Wasp;

import javax.swing.JApplet;

public class WaspApplet extends JApplet {

	WaspPane wp;
	
	public void init(){
		wp = new WaspPane();
		this.setContentPane(wp);
		this.setSize(wp.getSize());
		wp.play();
	}
	
}