package bricksnball;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class BricksNBall extends GamePane {
	
	Brick[] bricks=new Brick[50];
	Paddle paddle;
	Ball ball;
	
	public BricksNBall(){
		super(600, 400);
		this.setBackground(new Color(200, 191, 231));
		
		int[][] map={{1,1,1,1,1,1,1,1,1,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,0,0,0,1,1,0,0,0,1},
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
		paddle.setLocation((this.getWidth()-paddle.getWidth())/2, this.getHeight()-paddle.getHeight()-30);
		this.add(paddle);
		
		ball = new Ball();
		this.add(ball);

		initBall();
	}

	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT))
			paddle.dir = -1;
		else if(isKeyDown(KeyEvent.VK_RIGHT))
			paddle.dir = 1;
		else
			paddle.dir = 0;
		
		if(paddle.has(ball)){
			ball.placeAbove(paddle, 1);
			ball.ydir *= -1;
		}
		
		boolean broken;
		int type;
		Brick b;
		for(int i=0; i<bricks.length; i++){
			b = bricks[i];
			if(b==null)
				continue;
			
			broken = false;
			type = b.type;
			if(b.has(ball)){
				broken = true;
				if(ball.ydir==-1 && ball.isBelow(b)){
					ball.ydir = 1;
					ball.placeBelow(b, 1);
				}else if(ball.ydir==1 && ball.isAbove(b)){
					ball.ydir = -1;
					ball.placeAbove(b, 1);
				}
			}
			
			if(b.has(ball)){
				broken = true;
				if(ball.xdir==-1 && ball.isRightTo(b)){
					ball.xdir = 1;
					ball.placeRightOf(b, 1);
				}else if(ball.xdir==1 && ball.isLeftTo(b)){
					ball.xdir = -1;
					ball.placeLeftOf(b, 1);
				}
			}
			
			if(broken){
				if(type==Brick.RED){
					Brick b1 = new Brick(Brick.YELLOW);
					b1.setLocation(b.getLocation());
					b1.setVisible(true);
					this.add(b1);
					
					bricks[i] = b1;
				}else
					bricks[i] = null;
				b.setVisible(false);
				this.remove(b);
			}
		}
		
		if((ball.getX()<=0 && ball.xdir==-1) || (ball.getX()+ball.getWidth()>=getWidth() && ball.xdir==1))
			ball.xdir *= -1;
		if(ball.getY()<=0)
			ball.ydir = 1;
		else if(ball.getY()>getHeight()){
			ball.setLocation((this.getWidth()-ball.getWidth())/2, paddle.getY()-100);
		}
	}
	
	void initBall(){
		ball.xvel = 5;
		ball.yvel = 5;
		ball.xdir = 1;
		ball.ydir = 1;
		ball.setLocation((this.getWidth()-ball.getWidth())/2, paddle.getY()-100);
	}
	
	public static void main(String[] args) {
		BricksNBall bnb = new BricksNBall();
		new GameWindow(bnb);
		bnb.play();
	}

}