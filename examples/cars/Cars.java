package cars;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Cars extends GamePane {

	Player d;
	Map map;
	
	public Cars() {
		super(600, 400);
		this.setFPS(80);
		
		map = new Map(this);
		map.loadNext();
		
		d = new Player();
		d.setLocation(0, 160);
		this.add(d);
	}
	
	public void update(){
	}

	public static void main(String[] args) {
		Cars c = new Cars();
		
		GameWindow game = new GameWindow(c);
		game.setTitle("Cars - Fuck You");
		
		c.play();
	}

}