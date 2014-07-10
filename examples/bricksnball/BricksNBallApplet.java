package bricksnball;

import com.kilvish.view.GameApplet;

public class BricksNBallApplet extends GameApplet {

	public void init(){
		this.setGamePane(new BricksNBall());
	}
	
	public void start(){
		this.getGamePane().play();
	}
	
	public void stop(){
		this.getGamePane().pause(true);
		this.remove(this.getContentPane());
	}
	
}