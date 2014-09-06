package cars;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import com.kilvish.core.Sprite;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class Cars extends GamePane {
	
	Random r;
	Player p,c,temp;
	
	Map map;
	
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
		for(int i=0;i<7;i++)
			map.loadNext();	
		this.shiftScreenBy(0, 600);
		
		p.setLocation(320, 600-p.getHeight());
		c.setLocation(420, 600-c.getHeight());
	}
	
	public void update(){
		//screen should follow player
		this.shiftScreenBy(0, this.getHeight()-p.getHeight()-p.getY());
		
		//switch player
		if(isKeyDown(KeyEvent.VK_SPACE)){
			temp = p;
			p = c;
			c = temp;
			try{
				Thread.sleep(250);
			}catch(Exception e){}
		}
				
		//player control
		if(p.velY>300)
			p.velY-=2;
		else if(GamePane.isKeyDown(KeyEvent.VK_UP))
			p.velY+=p.velY>1?1:3;
		else if(GamePane.isKeyDown(KeyEvent.VK_DOWN))
			p.velY-=p.velY<5?(p.velY<1?0:2):5;
		else //friction
			p.velY = p.velY<1?0:p.velY-2;
		
		//computer control
		if(c.velY>200 && p.getY()>c.getY()+200)
			c.velY-=5;
		else if(r.nextBoolean())
			c.velY+=2;
		
		//end of game
		Sprite s;
		//player wins
		s=p.collidingWithSome("stone");
		if(s!=null){
			p.placeBelow(s, 0);
			p.velY = 0;
		}
		//computer wins
		s=c.collidingWithSome("stone");
		if(s!=null){
			c.placeBelow(s, 0);
			c.velY = 0;
		}
		//show score
		if(s!=null && c.velY==0 && p.velY==0){
			JOptionPane.showMessageDialog(this, "Game Over!");
			System.exit(0);
		}
		
		//load map
		if(map.lastLoaded.getY()>-200)
			map.loadNext(true);
	}

	public static void main(String[] args) {
		Cars c = new Cars();
		
		GameWindow game = new GameWindow(c);
		game.setTitle("Cars - Kilvish Demo");
		
		c.play();
	}
}