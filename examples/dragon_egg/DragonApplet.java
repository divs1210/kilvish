package dragon_egg;

import com.kilvish.view.GameApplet;

public class DragonApplet extends GameApplet {

	public void init(){
		setGamePane(new Game());
	}
	
	public void start(){
		getGamePane().play();
	}
	
}
