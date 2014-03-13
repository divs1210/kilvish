package example1_Wasp;

import com.kilvish.view.GameApplet;

public class WaspApplet extends GameApplet {
	
	public void init(){
		setGamePane(new WaspPane());
	}
	
	public void start(){
		getGamePane().play();
	}
	
}