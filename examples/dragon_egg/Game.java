package dragon_egg;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	public Game(){
		super(600, 400);
	}
	
	public static void main(String[] args){
		Game g = new Game();
		new GameWindow(g);
		g.play();
	}
}