package cars;

import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Cars extends GamePane {

	Player p;
	Map map;
	
	public Cars() {
		super(600, 400);
		this.setFPS(15);
		
		p = new Player();
		p.setLocation(200, 260);
		this.add(p);
		
		map = new Map(this);
		map.loadNext();
	}
	
	public void update(){
		if(GamePane.isKeyDown(KeyEvent.VK_UP))
			p.velY+=1;
		else if(GamePane.isKeyDown(KeyEvent.VK_DOWN))
			p.velY-=1;
		else{
			p.velY = (int) (Math.abs(p.velY)>0?p.velY-Math.signum(p.velY):0);
		}
		
		if(GamePane.isKeyDown(KeyEvent.VK_LEFT))
			p.velX=-5;
		else if(GamePane.isKeyDown(KeyEvent.VK_RIGHT))
			p.velX= 5;
		else
			p.velX= 0;
		
		if(p.getY()<10){
			this.shiftScreenBy(0, 400);
			map.loadNext(true);
		}
	}

	public static void main(String[] args) {
		Cars c = new Cars();
		
		GameWindow game = new GameWindow(c);
		game.setTitle("Cars - Kilvish Demo");
		
		c.play();
	}

}