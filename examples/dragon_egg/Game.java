package dragon_egg;

import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Game extends GamePane {
	
	Dragon d;
	Wagon w;
	
	public Game(){
		super(600, 400);
		
		d = new Dragon();
		this.add(d);
		
		w = new Wagon();
		w.setLocation(0, this.getHeight()-70);
		this.add(w);
	}
	
	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT)){
			w.dir = -1;
			w.setCurrentAnimationIndex(1);
		}else if(isKeyDown(KeyEvent.VK_RIGHT)){
			w.dir = 1;
			w.setCurrentAnimationIndex(2);
		}else{
			w.dir = 0;
			w.setCurrentAnimationIndex(0);
		}
	}
	
	public static void main(String[] args){
		Game g = new Game();
		new GameWindow(g);
		g.play();
	}
}