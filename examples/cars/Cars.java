package cars;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Cars extends GamePane {

	Player p,c;
	Map map;
	Random r;
	
	public Cars() {
		super(800, 600);
		this.setFPS(15);
		
		r = new Random();
		
		p = new Player(0);
		this.add(p);
		
		c = new Player(1);
		c.velY = 1;
		this.add(c);
		
		map = new Map(this);
		for(int i=0;i<6;i++){
			map.loadNext();
			this.shiftScreenBy(0, 100);
		}
		
		p.setLocation(320, 600-p.getHeight());
		c.setLocation(420, 600-c.getHeight());
	}
	
	///*
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
		
		if(p.getY()<-p.getHeight()){
			for(int i=0;i<8;i++){
				map.loadNext(true);
				this.shiftScreenBy(0, 100);
			}
		}
	}
	//*/

	public static void main(String[] args) {
		Cars c = new Cars();
		
		GameWindow game = new GameWindow(c);
		game.setTitle("Cars - Kilvish Demo");
		
		c.play();
	}

}