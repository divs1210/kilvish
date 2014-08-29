package cars;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Cars extends GamePane {

	Random r;
	Player p,c;
	
	Map map;
	int startAt=0;
	
	public Cars() {
		super(800, 600);
		this.setFPS(30);
		
		r = new Random();
		
		p = new Player(0);
		this.add(p);
		
		c = new Player(1);
		c.velY = 1;
		this.add(c);
		
		map = new Map(this);
		for(int i=0;i<map.repr.length;i++){
			map.loadNext();
			this.shiftScreenBy(0, 100);
		}
		this.shiftScreenBy(0, -100*(map.repr.length-6));
		
		p.setLocation(320, 600-p.getHeight());
		c.setLocation(420, 600-c.getHeight());
	}
	
	public void update(){
		if(GamePane.isKeyDown(KeyEvent.VK_UP))
			p.velY+=1;
		else if(GamePane.isKeyDown(KeyEvent.VK_DOWN))
			p.velY-=3;
		else{
			p.velY = (int) (Math.abs(p.velY)>0?p.velY-Math.signum(p.velY):0);
		}
		
		if(GamePane.isKeyDown(KeyEvent.VK_LEFT))
			p.velX=-5;
		else if(GamePane.isKeyDown(KeyEvent.VK_RIGHT))
			p.velX= 5;
		else
			p.velX= 0;
		
		if(r.nextBoolean())
			c.velY++;
		
		startAt = 600-p.getHeight()-p.getY();
		this.shiftScreenBy(0, startAt);
	}

	public static void main(String[] args) {
		Cars c = new Cars();
		
		GameWindow game = new GameWindow(c);
		game.setTitle("Cars - Kilvish Demo");
		
		c.play();
	}

}