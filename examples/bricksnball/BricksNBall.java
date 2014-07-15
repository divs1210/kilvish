package bricksnball;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.kilvish.core.Sprite;
import com.kilvish.util.MediaLoader;
import com.kilvish.view.GamePane;
import com.kilvish.view.GameWindow;

public class BricksNBall extends GamePane {
	
	Paddle paddle;
	Ball ball;
	
	Sprite wallL,
		   wallR,
	       roof;
	
	static final ImageIcon wallImg_1 = MediaLoader.getImageIcon("media/bricksnball/walls/wall.png"),
						   wallImg_2 = MediaLoader.getImageIcon("media/bricksnball/walls/wall_2.png"),
			               roofImg   = MediaLoader.getImageIcon("media/bricksnball/walls/roof.png");
	
	static final AudioClip hit   = MediaLoader.getSound("media/bricksnball/sounds/hit.wav"),
						   blast = MediaLoader.getSound("media/bricksnball/sounds/blast.wav"),
						   music = MediaLoader.getSound("media/bricksnball/sounds/music.wav");
	
	public BricksNBall(){
		super(600, 400);
		this.setBackground(new Color(215, 212, 210));
		this.setFPS(100);
		
		int[][] map={{1,1,1,1,1,1,1,1,1,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,0,0,0,1,1,0,0,0,1},
				     {1,0,0,0,0,0,0,0,0,1},
				     {1,1,1,1,1,1,1,1,1,1}};
		
		Brick b;
		int startX=(this.getWidth()-400)/2,
			startY= this.getHeight()/5;
		for(int r=0; r<5; r++){
			for(int c=0; c<10; c++){
				if(map[r][c]>=0){
					b = new Brick(map[r][c]);
					b.setLocation(startX+40*c, startY+20*r);
					this.add(b);
				}
			}
		}
		
		wallL = new Sprite("left_wall");
		wallL.addImage(wallImg_1, 50);
		wallL.addImage(wallImg_2, 50);
		wallL.setLocation(0,0);
		this.add(wallL);
		
		wallR = new Sprite("right_wall");
		wallR.addImage(wallImg_1, 50);
		wallR.addImage(wallImg_2, 50);
		wallR.setLocation(getWidth()-wallR.getWidth(),0);
		this.add(wallR);
		
		roof = new Sprite("roof");
		roof.addImage(roofImg);
		roof.setLocation(0,0);
		this.add(roof);
		
		paddle = new Paddle();
		paddle.setLocation((this.getWidth()-paddle.getWidth())/2, 
				           this.getHeight()-paddle.getHeight());
		this.add(paddle);
		
		ball = new Ball();
		initBall();
		this.add(ball);
	}

	@Override
	public void update(){
		if(isKeyDown(KeyEvent.VK_LEFT))
			paddle.dir = -1;
		else if(isKeyDown(KeyEvent.VK_RIGHT))
			paddle.dir = 1;
		else
			paddle.dir = 0;
		
		/*  Auto-Pilot
		if(ball.ydir==1){
			if(ball.isLeftTo(paddle))
				paddle.dir = -1;
			else if(ball.isRightTo(paddle))
				paddle.dir = 1;
			else
				paddle.dir = 0;
		}else
			paddle.dir = 0;
		//*/
		
		if(paddle.has(ball)){
			ball.placeAbove(paddle, ball.yvel);
			ball.ydir = -1;
		}else if(roof.has(ball)){
			ball.placeBelow(roof, ball.yvel);
			ball.ydir = 1;
		}else if(ball.getY()>getHeight()){
			initBall();
		}
		
		if(wallL.has(ball)){
			ball.placeRightOf(wallL, ball.xvel);
			ball.xdir = 1;
		}else if(wallR.has(ball)){
			ball.placeLeftOf(wallR, ball.xvel);
			ball.xdir = -1;
		}
		
		Brick b = (Brick) ball.collidingWithSome("brick");
		if(b!=null){
			b.kill();
			
			if(ball.xdir==-1 && ball.isRightTo(b)){
				ball.placeRightOf(b, ball.xvel);
				ball.xdir = 1;
			}else if(ball.xdir==1 && ball.isLeftTo(b)){
				ball.placeLeftOf(b, ball.xvel);
				ball.xdir = -1;
			}else if(ball.ydir==-1 && ball.isBelow(b)){
				ball.placeBelow(b, ball.yvel);
				ball.ydir = 1;
			}else if(ball.ydir==1 && ball.isAbove(b)){
				ball.placeAbove(b, ball.yvel);
				ball.ydir = -1;
			}
			
			if(b.type==Brick.RED){
				Brick b1 = new Brick(Brick.YELLOW);
				b1.setLocation(b.getLocation());
				b1.setVisible(true);
				this.add(b1);
				hit.play();
			}else
				blast.play();
		}
	}
	
	void initBall(){
		ball.xdir = 1;
		ball.ydir = 1;
		ball.setLocation((this.getWidth()-ball.getWidth())/2, 
				         (this.getHeight()*7)/10);
		music.loop();
	}
	
	public static void main(String[] args) {
		BricksNBall bnb = new BricksNBall();
		new GameWindow(bnb);
		bnb.play();
	}

}