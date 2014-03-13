package dragon_egg;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	Dragon d;
	
	public Game(){
		super(600, 400);
		this.setFPS(15);
		
		d = new Dragon();
		this.add(d);
	}
	
	public static void main(String[] args){
		Game g = new Game();
		new GameWindow(g);
		g.play();
	}
}