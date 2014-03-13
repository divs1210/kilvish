package bricksnball;

import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class BricksNBall extends GamePane {
	
	Brick[] bricks=new Brick[50];
	Paddle paddle;
	
	public BricksNBall(){
		super(600, 400);
		
		int[][] map={{1,1,1,1,1,1,1,1,1,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,1,1,1,1,1,1,1,1,1}};
		
		int i=0;
		for(int r=0; r<5; r++){
			for(int c=0; c<10; c++,i++){
				bricks[i] = new Brick(map[r][c]);
				bricks[i].setLocation(100+40*c, 50+20*r);
				this.add(bricks[i]);
			}
		}
		
		paddle = new Paddle();
		paddle.setLocation((this.getWidth()-Paddle.img.getIconWidth())/2, 400-50);
		this.add(paddle);
	}

	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT))
			paddle.dir = -1;
		else if(isKeyDown(KeyEvent.VK_RIGHT))
			paddle.dir = 1;
		else
			paddle.dir = 0;
	}
	
	public static void main(String[] args) {
		BricksNBall bnb = new BricksNBall();
		new GameWindow(bnb);
		bnb.play();
	}

}