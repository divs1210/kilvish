package dragon_egg;

import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class DragonGame extends GamePane {
	
	Dragon d;
	Wagon w;
	
	public DragonGame(){
		super(600, 400);
		
		d = new Dragon();
		d.setLocation(-d.getWidth(), 0);
		this.add(d);
		
		w = new Wagon();
		w.setLocation((this.getWidth()-w.getWidth())/2, this.getHeight()-w.getHeight()-30);
		this.add(w);
	}
	
	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT)){
			w.dir = -1;
			w.setCurrentAnimation("move_left");
		}else if(isKeyDown(KeyEvent.VK_RIGHT)){
			w.dir = 1;
			w.setCurrentAnimation("move_right");
		}else{
			w.dir = 0;
			w.setCurrentAnimation("idle");
		}
	}
	
	public static void main(String[] args){
		DragonGame g = new DragonGame();
		new GameWindow(g);
		g.play();
	}
}